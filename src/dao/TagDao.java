package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Evento;
import model.Tag;
import service.EventoService;

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
	
	public ArrayList<Evento> consultarEventoPorTag(int id) {
	    EventoService evs = new EventoService();
	    String consulta = "SELECT fk_evento_id FROM tag_evento WHERE id='" +id +"'";
	    
	    ArrayList<Evento> listaEvento = new ArrayList<>();
	    
	    try (Connection conectar = ConnectionFactory.obtemConexao();
                PreparedStatement pst = conectar.prepareStatement(consulta);){
            ResultSet resultado = pst.executeQuery();
            
            while (resultado.next()) {
                Evento e = new Evento();
                e = evs.carregar(resultado.getInt("fk_evento_id"));
                listaEvento.add(e);
                e = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}
	
	public Tag consultarTag(int id) {
		Tag tag = null;
		String consulta = "SELECT * FROM tag "
				+ "WHERE id="+id;
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(consulta);){
			
			ResultSet resultado = pst.executeQuery();
			
			if (resultado.next()) {
				tag = new Tag(resultado.getInt("id"), resultado.getString("nome"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tag;
	}
	
	/**
	 * Metodo para consultar Tag:
	 * @since 0.1
	 * @param id
	 * @return Tag
	 */
	public ArrayList<Tag> consultarTags(){
		ArrayList<Tag> tags = null;
		
		String consulta = "SELECT * FROM tag";
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(consulta);){
			ResultSet resultado = pst.executeQuery();
			
			tags = new ArrayList<Tag>();
			while (resultado.next()) {
				Tag t = new Tag(resultado.getInt("id"), resultado.getString("nome"));
				tags.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tags;
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
	
	
	/**
	 * Retornar lista de tag_usuario
	 * @param cpf
	 * @return
	 */
	public ArrayList<Tag> tagUsuario(String cpf){
		ArrayList<Tag> tags = null;
		
		String select = "select t.* ," + 
				" (select 1" + 
				" from tag_usuario t1" + 
				" where t1.fk_usuario_cpf = ?" + 
				" and t1.fk_tag_id = t.id) as checked" + 
				" from tag t";
		try(Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(select);){
			
		pst.setString(1, cpf);
		
		ResultSet resultado = pst.executeQuery();
		
		tags = new ArrayList<Tag>();
		
		while (resultado.next()) {				
			Tag t = new Tag(resultado.getInt("id"), resultado.getString("nome"));
			t.setChecado(resultado.getInt("checked"));
			tags.add(t);
		}
		
		} catch(SQLException e) {
		e.printStackTrace();
		}
		
		return tags;
	}
	
	/**
	 * Retornar lista de tag_evento
	 * @param cpf
	 * @return
	 */
	public ArrayList<Tag> tagEvento(int id){
	    ArrayList<Tag> tags = null;
        
        String select = "select t.* ," + 
                " (select 1" + 
                " from tag_evento t1" + 
                " where t1.fk_evento_id = ?" + 
                " and t1.fk_tag_id = t.id) as checked" + 
                " from tag t";
        try(Connection conectar = ConnectionFactory.obtemConexao();
                PreparedStatement pst = conectar.prepareStatement(select);){
            
        pst.setInt(1, id);
        
        ResultSet resultado = pst.executeQuery();
        
        tags = new ArrayList<Tag>();
        
        while (resultado.next()) {              
            Tag t = new Tag(resultado.getInt("id"), resultado.getString("nome"));
            t.setChecado(resultado.getInt("checked"));
            tags.add(t);
        }
        
        } catch(SQLException e) {
        e.printStackTrace();
        }
        
        return tags;
	}
}
