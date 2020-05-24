package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Inscricao;
import service.UsuarioService;
import service.EventoService;


/**
 * Data Acess Object para o Inscricao
 * 
 * @author Davi Fonseca
 * @version 0.1
 * @since 0.1
 */
public class InscricaoDao {
	
	/**
	 * Metodo para inserir uma incricao no banco de dados
	 * @param inscricao
	 * @throws MySQLException
	 */
	public void criarInscricao(Inscricao inscricao) {
		String sqlInsert = "INSERT INTO inscricao"
				+"(fk_usuario_cpf, fk_evento_id)"
				+"VALUES (?,?)";
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setString(1,inscricao.getUser().getCpf());
			pst.setInt(2,inscricao.getEvento().getId());
			pst.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Metodo de consultar inscricao.
	 * @param id
	 * @return
	 */
	public Inscricao consultarInscricao(int id){
		String consulta = "SELECT * FROM inscricao WHERE id='" +id +"'";
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(consulta)) {
			
			ResultSet resultado = pst.executeQuery();
			
			if (resultado.next()) {
				Inscricao inscricao = new Inscricao();
				inscricao.setId(id);
				
				UsuarioService us = new UsuarioService();
				inscricao.setUser(us.carregar(resultado.getString("fk_usuario_cpf")));
				
				EventoService es = new EventoService();
				inscricao.setEvento(es.carregar(resultado.getInt("fk_evento_id")));
				
				return inscricao;
			}
		} catch (SQLException ex) {	
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Metodo de listagem de inscricoes de um determinado usuario
	 * @param cpf
	 * @return ArrayList<Inscricao>
	 */
	public ArrayList<Inscricao> listarInscricoes(String cpf) {
		String sqlSelect = "SELECT * FROM inscricao WHERE fk_usuario_cpf='"+cpf+"'";

		ArrayList<Inscricao> listaInscricao = new ArrayList<>();
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlSelect);) {
			
			ResultSet resultado = pst.executeQuery();
			
			while(resultado.next())
				listaInscricao.add(consultarInscricao(resultado.getInt("id")));

			return listaInscricao;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Metodo para deletar inscricao
	 * @param id
	 */
	public void deletarInscricao(int id){
		String deletar = "DELETE FROM inscricao WHERE id = "+id;
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(deletar)) {
			
			pst.execute();
					
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	/**
	 * Método para deletar inscrições referentes a um determinado usuário
	 * @param cpf
	 */
	public void deletarInscricao(String cpf){
		String deletar = "DELETE FROM inscricao WHERE fk_usuario_cpf = "+cpf;
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(deletar)) {
			pst.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Metodo de atualizar inscricao
	 * @param inscricao
	 */
	public void atualizarInscricao(Inscricao inscricao){
		String atualizar = "UPDATE inscricao SET fk_usuario_cpf = ?, fk_evento_id = ? WHERE id = ?";
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(atualizar)) {
			
			pst.setString(1,inscricao.getUser().getCpf());
			pst.setInt(2,inscricao.getEvento().getId());
			pst.setInt(3,inscricao.getId());
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
