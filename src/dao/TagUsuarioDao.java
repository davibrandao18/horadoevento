package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.TagUsuario;

public class TagUsuarioDao {
	
	/**
	 * @param Usuario user
	 * @return
	 */
	public void criarTagUsuario(TagUsuario tagUsr) {
		String sqlInsert = "INSERT INTO usuario"
				+"(fk_id_tag, fk_cpf_usuario)"
				+"VALUES (?, ?)";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setInt(1,tagUsr.getTag().getId());
			pst.setString(2,tagUsr.getUser().getCpf());
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
}
