package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDao {
	Usuario user = new Usuario();
	
	/**
	 * 
	 * @param Usuario user
	 * @return
	 */
	public String criarUsuario(Usuario user) {
		String sqlInsert = "INSERT INTO usuario"
				+"(cpf,username,linklinkedin,nome,email,senha,fk_id_tags,fk_id_certificado,fk_id_evento,fk_id_empresa,foto)"
				+"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		try (Connection conectar =ConnectionFactory.obtemConexao();
				PreparedStatement stm = conectar.prepareStatement(sqlInsert);){
			//TODO
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	

}