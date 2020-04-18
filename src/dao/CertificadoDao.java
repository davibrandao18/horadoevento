package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Certificado;

public class CertificadoDao {
	/**
	 * @param Usuario user
	 * @return
	 */
	public void criarCertificado(Certificado certificado) {
		String sqlInsert = "INSERT INTO usuario"
				+"(cpf,username,nome,email,senha,linklinkedin,foto)"
				+"VALUES (?,?,?,?,?,?,?)";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			/**pst.setString(1,certificado.getCpf());
			pst.setString(2,certificado.getUserName());
			pst.setString(3,certificado.getNome());
			pst.setString(4,certificado.getEmail());
			pst.setString(5,certificado.getSenha());
			pst.setString(6,certificado.getLinkedin());**/
			
			/**usuario.getColecaoEmpresas()
			ArrayList<EmpresaUsuario> listaC = user.getColecaoCertificados();
			TagUserDao lala = new TagUserDao();
			lista.forEach( t -> {
				lala.criarTagUsuario(t);
			});**/
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
}
