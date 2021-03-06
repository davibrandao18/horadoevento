package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Certificado;

import service.UsuarioService;
import service.EventoService;

/**
 * Data Acess Object para o certificado
 * 
 * @author Davi Fonseca
 * @version
 * @since 
 */
public class CertificadoDao {
	
	/**
	 * metodo para inserir um certificado no banco de dados
	 * 
	 * @param certificado
	 * @throws MySQLException
	 */
	public void criarCertificado(Certificado certificado) {
		String sqlInsert = "INSERT INTO certificado"
				+"(fk_usuario_cpf, fk_evento_id, quantidade_minutos )"
				+"VALUES (?,?,?)";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			
			pst.setString(1,certificado.getUser().getCpf());
			pst.setInt(2,certificado.getEvento().getId());
			pst.setInt(3,certificado.getQuantidadeMinutos());
			
			pst.execute();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo de consultar certificado.
	 * 
	 * @param id
	 * @return certificado
	 * @throws MySQLException
	 */
	public Certificado consultarCertificado(int id) {
		
		/**
		 * String de consulta
		 */
		String consulta = "SELECT * FROM certificado"
				+ "WHERE id = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(consulta)) {
			
			pst.setInt(1, id);
			
			//quando precisa de retorno do banco "ResultSet"//
			ResultSet resultado = pst.executeQuery();
			
			if (resultado.next()) {				
				String cpfUsuario = resultado.getString("fk_usuario_cpf");
				int evento = resultado.getInt("fk_evento_id");
				int qtdMinutos = resultado.getInt("quantidade_minutos");
				
				Certificado certificado = new Certificado();
				certificado.setId(id);
				
				UsuarioService usuarioService = new UsuarioService();
				certificado.setUser(usuarioService.carregar(cpfUsuario));
				
				EventoService eventoService = new EventoService();
				certificado.setEvento(eventoService.carregar(evento));
				
				certificado.setQuantidadeMinutos(qtdMinutos);
				
				return certificado;
			}
		} catch (SQLException ex) {	
			ex.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Metodo de deletar certificado
	 * 
	 * @param id
	 * @throws MySQLException
	 */
	public void deletarCertificado(int id) {
			
		//Preparando a String para deletar:
		String deletar = "DELETE FROM certificado WHERE id = "+id;
				
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(deletar)) {
			
			pst.execute();
					
		} catch (Exception e) {
				//Imprimido a pilha de erros:
				e.printStackTrace();
		}
	}
	
	/**
	 * Metodo de atualizar certificado
	 * 
	 * @param certificado
	 */
	public void atualizarCertificado(Certificado certificado) {
		String atualizar = "UPDATE certificado SET fk_usuario_cpf = ?, fk_evento_id = ?, quantidade_minutos = ? WHERE id = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(atualizar)) {
			

			pst.setString(1,certificado.getUser().getCpf());
			pst.setInt(2,certificado.getEvento().getId());
			pst.setInt(3,certificado.getId());
			
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
