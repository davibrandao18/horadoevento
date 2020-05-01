package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import model.Empresa;
import model.Evento;
import model.Usuario;

import service.EmpresaService;

/**
 * Data Acess Object para o Evento
 * 
 * @author Maicon Souza
 * @version
 * @since 
 */
public class EventoDao {
	
	/**
	 * Criação de um novo evento
	 * @param evento
	 * @throws SQLException
	 */
	public void inserirEvento(Evento evento) throws SQLException {
		String sqlInsert = "INSERT INTO evento"
				+ "(data_hora, localizacao, descricao, duracao, quantidade_vagas, palestrante, titulo, fk_empresa_cnpj)"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		
		try(Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setDate(1, new Date(evento.getDataHora().getInstance().getTimeInMillis())); // /!\
			pst.setString(2, evento.getLocalizacao());
			pst.setString(3, evento.getDescricao());
			pst.setString(4, evento.getDuracao());
			pst.setInt(5, evento.getQuantidadeVagas());
			pst.setString(6, evento.getPalestrante());
			pst.setString(7, evento.getTitulo());
			pst.setString(8, evento.getEmpresa().getCnpj());
			
			pst.execute();
			System.out.println("dao:: Evento " +evento.getTitulo() +" criado com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * Consultar evento usando um id
	 * @param id
	 * @return
	 */
	public Evento consultarEvento(int id) {
		String sqlSelect = "SELECT * FROM evento WHERE id = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlSelect)) {
			pst.setInt(1, id);
			
			ResultSet result = pst.executeQuery();
			
			if (result.next()){
				Evento evento = new Evento();
				
				evento.setDataHora(evento.toGregorian(result.getDate("data_hora")));
				evento.setLocalizacao(result.getString("localizacao"));
				evento.setDescricao(result.getString("descricao"));
				evento.setDuracao(result.getString("duracao"));
				evento.setQuantidadeVagas(result.getInt("quantidade_vagas"));
				evento.setPalestrante(result.getString("palestrante"));
				evento.setTitulo(result.getString("titulo"));
				
				EmpresaService es = new EmpresaService();
				Empresa empresa = new Empresa();
				
				empresa = es.consultar(result.getString("fk_empresa_cnpj"));
				
				evento.setEmpresa(empresa);
				
				return evento;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Consulta evento usando um cnpj
	 * @param cnpj
	 * @return
	 */
	public Evento consultarEvento(String cnpj) {
		String sqlSelect = "SELECT * FROM evento WHERE fk_empresa_cnpj = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlSelect)) {
			pst.setString(1, cnpj);
			
			ResultSet result = pst.executeQuery();
			
			if (result.next()){
				Evento evento = new Evento();
				
				evento.setDataHora(evento.toGregorian(result.getDate("data_hora")));
				evento.setLocalizacao(result.getString("localizacao"));
				evento.setDescricao(result.getString("descricao"));
				evento.setDuracao(result.getString("duracao"));
				evento.setQuantidadeVagas(result.getInt("quantidade_vagas"));
				evento.setPalestrante(result.getString("palestrante"));
				evento.setTitulo(result.getString("titulo"));
				
				EmpresaService es = new EmpresaService();
				evento.setEmpresa(es.consultar(cnpj));
				
				return evento;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Listagem de eventos utilizando um titulo
	 * @param titulo
	 * @return
	 */
	public ArrayList<Evento> listarEventos(String titulo) {
		String sqlSelect = "SELECT * FROM evento WHERE titulo LIKE '%" +titulo +"%'";

		ArrayList<Evento> listaEvento = new ArrayList<>();
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlSelect);) {
			
			ResultSet resultado = pst.executeQuery();
			
			while(resultado.next())
				listaEvento.add(consultarEvento(resultado.getInt("id")));

			return listaEvento;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	
	/**
	 * Atualização de um evento existente
	 * @param evento
	 * @throws SQLException
	 */
	public void atualizarEvento(Evento evento) throws SQLException {
		String sqlUpdate = "UPDATE evento SET data_hora = ?, localizacao = ?, descricao = ?, duracao = ?, quantidade_vagas = ?, palestrante = ?, titulo = ?, fk_empresa_cnpj = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlUpdate)) {
			pst.setDate(1, new Date(evento.getDataHora().getInstance().getTimeInMillis()));
			pst.setString(2, evento.getLocalizacao());
			pst.setString(3, evento.getDescricao());
			pst.setString(4, evento.getDuracao());
			pst.setInt(5, evento.getQuantidadeVagas());
			pst.setString(6, evento.getPalestrante());
			pst.setString(7, evento.getTitulo());
			pst.setString(8, evento.getEmpresa().getCnpj());
			
			pst.executeUpdate();
			System.out.println("dao:: Evento atualizado com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	/**
	 * Deletar um evento utilizando id
	 * @param id
	 * @throws SQLException
	 */
	public void deletarEvento(int id) throws SQLException {
		String sqlDelete = "DELETE FROM evento WHERE id = " +id;
		
		try(Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlDelete);) {
			pst.execute();
			
			System.out.println("dao:: Evento deletado com sucesso");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
