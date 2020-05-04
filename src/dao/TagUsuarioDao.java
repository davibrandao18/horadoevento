package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.TagUsuario;
import service.UsuarioService;
import service.TagService;

/**
 * Data Acess Object para o TagUsuarioDao
 * 
 * @author Davi Fonseca
 * @version
 * @since 
 */
public class TagUsuarioDao {
	
	/**
	 * Metodo de insercao de registro Tag_usuario no Banco de dados
	 * @param TagUsuario tagUsr
	 */
	public void inserirTagUsuario(TagUsuario tagUsr) {
		String sqlInsert = "INSERT INTO tag_usuario"
				+"(fk_tag_id, fk_usuario_cpf)"
				+"VALUES (?,?)";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setString(1,tagUsr.getUser().getCpf());
			pst.setInt(2,tagUsr.getTag().getId());
			
			pst.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
			
	}
	
	/**
	 * Metodo para consultar registros da tabela Tag_usuario:
	 * @param id
	 * @return
	 */
	public TagUsuario consultarTagUsuario(int id){
		String sqlConsu = "SELECT * FROM tag_usuario"
				+"WHERE id = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlConsu);) {
			pst.setInt(1,id);
			
			//quando precisa de retorno do banco "ResultSet"//
			ResultSet resultado = pst.executeQuery();
			
			//+"(cpf,username,nome,email,senha,linkedin,foto)"
			if (resultado.next()){
				TagUsuario tagUsuario = new TagUsuario();
				int idTag = resultado.getInt("fk_tag_id");
				String cpfUser = resultado.getString("fk_usuario_cpf");
				
				tagUsuario.setId(id);
				
				TagService ts = new TagService();
				tagUsuario.setTag(ts.carregar(idTag));
				
				UsuarioService us = new UsuarioService();
				tagUsuario.setUser(us.carregar(cpfUser));
		
				return tagUsuario;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
		
	/**
	 * Metodo para deletar registro de Tag_usuario no Banco de dados
	 * @param id
	 */
	public void deletarTagUsuario(int id){
		String deletar = "DELETE FROM tag_usuario WHERE id = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(deletar)) {

			pst.setInt(1, id);
			
			//Enviando um comando para o MySQL
			pst.execute();
			
		} catch (Exception e) {
			//Imprimido a pilha de erros:
			e.printStackTrace();
		}
	}
		
	/**
	 * Metodo para atualizar registro de Tag_usuario no Banco de dados
	 * @param empresaUsr
	 */
	public void atualizarTagUsuario(TagUsuario tagUsuario){
		String atualizar = "UPDATE tag_usuario SET fk_tag_id = ?, fk_usuario_cpf = ? WHERE id = "+tagUsuario.getId();
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(atualizar)) {
			pst.setInt(1, tagUsuario.getTag().getId());
			pst.setString(2, tagUsuario.getUser().getCpf());	
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
