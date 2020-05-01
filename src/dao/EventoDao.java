package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Evento;

/**
 * Data Acess Object para o Evento
 * 
 * @author Davi Fonseca
 * @version
 * @since 
 */
public class EventoDao {
	
	public void criarInscricao(Evento envento){
		String sqlInsert = "INSERT INTO inscricao"
				+"()"
				+"VALUES (?,?)";
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setString(1,envento.
			pst.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
