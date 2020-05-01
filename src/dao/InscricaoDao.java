package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Inscricao;

/**
 * Data Acess Object para o Inscricao
 * 
 * @author Davi Fonseca
 * @version
 * @since 
 */
public class InscricaoDao {
	
	/**
	 * Metodo para inserir uma incricao no banco de dados
	 * @param inscricao
	 * @throws MySQLException
	 */
	public void criarInscricao(Inscricao inscricao) {
		String sqlInsert = "INSERT INTO inscricao"
				+"(fk_usuario_cpf, fk_evento_id)"
				+"VALUES (?,?)";
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setString(1,inscricao.getUser().getCpf());
			pst.setInt(2,inscricao.getEvento().getId());
			pst.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
}
