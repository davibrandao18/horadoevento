package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Evento;
import model.TagEvento;
import model.TagUsuario;

/**
 * Data Acess Object para o TagEventoDao
 * 
 * @author Davi Fonseca
 * @version
 * @since 0.1
 */
public class TagEventoDao {
	
	/**
	 * Metodo de insercao de tag_evento no Banco de dados
	 * @since 0.1
	 * @param tagEvento
	 */
	public void inserirTagEvento(TagEvento tagEvento){
		String sqlInsert = "INSERT INTO tag_evento (fk_tag_id, fk_evento_id)"
				+ "vALUES (?,?)";
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert)){
			pst.setInt(1, tagEvento.getTag().getId());
			pst.setInt(2, tagEvento.getEvento().getId());
			pst.execute();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para consultar TagEvento:
	 * @since 0.1
	 * @param id
	 * @return TagEvento
	 */
	public TagEvento consultarTagEvento(int id) {
		String consultar = "SELECT * From tag_evento WHERE id="+id;
		try(Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(consultar);){
			ResultSet resultado = pst.executeQuery();
			
			if (resultado.next()) {
				int idTag = resultado.getInt("fk_tag_id");
				int idEvent = resultado.getInt("fk_evento_id");
				
				TagEvento tagEvento = new TagEvento();
				tagEvento.setId(id);
				
				TagService ts = new TagService();
				tagEvento.setTag(ts.carregar(idTag));
				
				EventoService es = new EventoService();
				tagEvento.setEvento(es.carregar(idEvent));
				
				return tagEvento;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	return null;	
	}
	
	/**
	 * Metodo para deletar registro de tag_evento no Banco de dados
	 * @param id
	 */
	public void deletarEmpresaUsuario(int id){
		String deletar = "DELETE FROM tag_evento WHERE id = ?";
		
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
	 * Metodo para atualizar registro de tag_evento no Banco de dados
	 * @param tagUsuario
	 */
	public void atualizarEmpresaUsuario(TagEvento tagEvento){
		String atualizar = "UPDATE tag_evento SET fk_tag_id = ?, fk_evento_id = ? WHERE id = "+tagEvento.getId();
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(atualizar)) {
			pst.setInt(1, tagEvento.getTag().getId());
			pst.setInt(2, tagEvento.getEvento().getId());	
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
