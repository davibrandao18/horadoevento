package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import model.EmpresaUsuario;


public class EmpresaUsuarioDao {
	
	/**
	 * @param Usuario user
	 * @return
	 */
	public void criarEmpresaUsuario(EmpresaUsuario empresaUsr) {
		String sqlInsert = "INSERT INTO usuario"
				+"(cpf,username,nome,email,senha,linklinkedin,foto)"
				+"VALUES (?,?,?,?,?,?,?)";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			/**pst.setString(1,empresaUsr.getCpf());
			pst.setString(2,empresaUsr.getUserName());
			pst.setString(3,empresaUsr.getNome());
			pst.setString(4,empresaUsr.getEmail());
			pst.setString(5,empresaUsr.getSenha());
			pst.setString(6,empresaUsr.getLinkedin());**/
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
}
