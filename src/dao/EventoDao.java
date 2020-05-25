package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Empresa;
import model.Evento;

import service.EmpresaService;

/**
 * Data Acess Object para o Evento
 * 
 * @author Maicon Souza e Davi Fonseca
 * @version
 * @since 
 */
public class EventoDao {
	
	/**
	 * Criacao de um novo evento
	 * @param evento
	 * @throws SQLException
	 */
	public Integer inserirEvento(Evento evento) throws SQLException {
		String sqlInsert = "INSERT INTO evento"
				+ "(data_hora, localizacao, descricao, duracao, quantidade_vagas, palestrante, titulo, fk_empresa_cnpj)"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		
		try(Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setTimestamp(1,  new java.sql.Timestamp(evento.getDataHora().getTime()));
			pst.setString(2, evento.getLocalizacao());
			pst.setString(3, evento.getDescricao());
			pst.setInt(4, evento.getDuracao());
			pst.setInt(5, evento.getQuantidadeVagas());
			pst.setString(6, evento.getPalestrante());
			pst.setString(7, evento.getTitulo());
			pst.setString(8, evento.getEmpresa().getCnpj());
			
			pst.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conectar.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					evento.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return evento.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
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
				
				evento.setDataHora(result.getDate("data_hora"));
				evento.setLocalizacao(result.getString("localizacao"));
				evento.setDescricao(result.getString("descricao"));
				evento.setDuracao(result.getInt("duracao"));
				evento.setQuantidadeVagas(result.getInt("quantidade_vagas"));
				evento.setPalestrante(result.getString("palestrante"));
				evento.setTitulo(result.getString("titulo"));
				
				EmpresaService es = new EmpresaService();
				Empresa empresa = new Empresa();
				
				empresa = es.carregar(result.getString("fk_empresa_cnpj"));
				
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
				
				evento.setDataHora(result.getDate("data_hora"));
				evento.setLocalizacao(result.getString("localizacao"));
				evento.setDescricao(result.getString("descricao"));
				evento.setDuracao(result.getInt("duracao"));
				evento.setQuantidadeVagas(result.getInt("quantidade_vagas"));
				evento.setPalestrante(result.getString("palestrante"));
				evento.setTitulo(result.getString("titulo"));
				
				EmpresaService es = new EmpresaService();
				evento.setEmpresa(es.carregar(cnpj));
				
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
	 * Atualiza�ao de um evento existente
	 * @param evento
	 * @throws SQLException
	 */
	public void atualizarEvento(Evento evento) throws SQLException {
		String sqlUpdate = "UPDATE evento SET data_hora = ?, localizacao = ?, descricao = ?, duracao = ?, quantidade_vagas = ?, palestrante = ?, titulo = ?, fk_empresa_cnpj = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlUpdate)) {
			pst.setTimestamp(1, new java.sql.Timestamp(evento.getDataHora().getTime()));
			pst.setString(2, evento.getLocalizacao());
			pst.setString(3, evento.getDescricao());
			pst.setInt(4, evento.getDuracao());
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
		String sqlDelete = "DELETE FROM evento WHERE id='" +id +"'";
		
		try(Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlDelete);) {
			pst.execute();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Remove todos os eventos de uma empresa
	 * @param cnpj
	 * @throws SQLException
	 */
	public void deletarEvento(String cnpj) throws SQLException {
		String sqlDelete = "DELETE FROM evento WHERE fk_empresa_cnpj='" +cnpj +"'";
		
		try(Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlDelete);) {
			pst.execute();
			
			System.out.println("dao:: Evento deletado com sucesso");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * Insere tag_usuario
	 * @param cpf
	 * @param idTag
	 */
	public void inserirTag(int id, int idTag){
		String sqlInsert = "INSERT INTO tag_evento"
				+"(fk_tag_id, fk_evento_id)"
				+"VALUES (?,?)";
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setInt(1, idTag);
			pst.setInt(2, id);

			pst.execute();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
}
