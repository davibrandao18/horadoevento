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
				+"(cpf,username,nome,email,senha,linklinkedin,foto)"
				+"VALUES (?,?,?,?,?,?,?)";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			/**pst.setString(1,tagUsr.getCpf());
			pst.setString(2,tagUsr.getUserName());
			pst.setString(3,tagUsr.getNome());
			pst.setString(4,tagUsr.getEmail());
			pst.setString(5,tagUsr.getSenha());
			pst.setString(6,tagUsr.getLinkedin());**/
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
}
