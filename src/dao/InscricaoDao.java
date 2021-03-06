package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Inscricao;
import model.Usuario;
import service.EventoService;
import service.UsuarioService;


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
	public int criarInscricao(Inscricao inscricao) {
		String sqlInsert = "INSERT INTO inscricao"
				+"(fk_usuario_cpf, fk_evento_id)"
				+"VALUES (?,?)";
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setString(1,inscricao.getUser().getCpf());
			pst.setInt(2,inscricao.getEvento().getId());
			pst.execute();
			
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conectar.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					inscricao.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return inscricao.getId();
	}
	
	/**
	 * Metodo de consultar inscricao.
	 * @param id
	 * @return
	 */
	public Inscricao consultarInscricao(int id){
		String consulta = "SELECT * FROM inscricao WHERE id= ?";
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(consulta)) {
			pst.setInt(1, id);
			
			ResultSet resultado = pst.executeQuery();
			
			if (resultado.next()) {
				Inscricao inscricao = new Inscricao();
				inscricao.setId(id);
				
				UsuarioService us = new UsuarioService();
				inscricao.setUser(us.carregarCPF(resultado.getString("fk_usuario_cpf")));
				
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
	public ArrayList<Inscricao> listarInscricoes(Usuario user) {
		ArrayList<Inscricao> listaInscricao = null;
		String sqlSelect = "SELECT * FROM inscricao WHERE fk_usuario_cpf=?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlSelect);) {
			pst.setString(1, user.getCpf());
			
			ResultSet resultado = pst.executeQuery();

			listaInscricao = new ArrayList<Inscricao>();
			while(resultado.next())
				listaInscricao.add(consultarInscricao(resultado.getInt("id")));

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return listaInscricao;
	}
	
	/**
	 * Metodo para deletar inscricao
	 * @param id
	 */
	public void deletarInscricao(int id){
		String deletar = "DELETE FROM inscricao WHERE id = ?";
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(deletar)) {
			pst.setInt(1, id);
			pst.execute();
					
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	/**
     * Metodo para deletar inscricao
     * @param id
     */
    public void deletarInscricaoEvento(int id){
        String deletar = "DELETE FROM inscricao WHERE fk_evento_id = ?";
        try (Connection conectar = ConnectionFactory.obtemConexao();
                PreparedStatement pst = conectar.prepareStatement(deletar)) {
            pst.setInt(1, id);
            pst.execute();
                    
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
	
	
	/**
	 * M�todo para deletar inscri��es referentes a um determinado usu�rio
	 * @param cpf
	 */
	public void deletarInscricao(String cpf){
		String deletar = "DELETE FROM inscricao WHERE fk_usuario_cpf =?";
		try (Connection conectar = ConnectionFactory.obtemConexao();
		        PreparedStatement pst = conectar.prepareStatement(deletar)) {
            pst.setString(1, cpf);
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
