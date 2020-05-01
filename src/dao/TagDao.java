package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Tag;

/**
 * Data Acess Object para o Tag
 * 
 * @author Davi Fonseca
 * @version
 * @since 
 */
public class TagDao {
	
	/**
	 * Metodo de insercao de tags no Banco de dados
	 * @since 0.1
	 * @param Tag tag
	 */
	public void inserirTag(Tag tag){
		String sqlInsert = "INSERT INTO tag (nome) VALUES (?)";
		
		try (Connection conectar = 	ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);){
			pst.setString(1, tag.getNome());
			pst.execute();			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Metodo para consultar Tag:
	 * @since 0.1
	 * @param id
	 * @return Tag
	 */
	public Tag consultarTag(int id){
		String consulta = "SELECT * FROM tag"
				+"WHERE id = "+id;
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(consulta);){
			ResultSet resultado = pst.executeQuery();
			
			if(resultado.next()) {
			Tag tag = new Tag();
			tag.setNome(resultado.getString("nome"));
			return tag;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Metodo para atualizar Tag no banco de dados
	 * @param tag
	 * @since 0.1
	 */
	public void atualizarTag(Tag tag) {
		String atualizar = "UPDATE tag Set nome = ? WHERE id ="+tag.getId();
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(atualizar);){
			pst.setString(1, tag.getNome());
			pst.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para deletar Tag no banco de dados
	 * @since 0.1
	 * @param id
	 */
	public void deletarTag(int id){
		String deletar = "DELETE FROM tag WHERE id = "+id;
		try(Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(deletar);){
			pst.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
