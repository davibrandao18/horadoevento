package service;

import java.sql.SQLException;

import dao.EventoDao;
import model.Evento;

public class EventoService {

	private EventoDao dao = new EventoDao();
	
	/**
	 * Cria um evento
	 * @param Evento evento
	 * @throws SQLException
	 */
	public void criar(Evento evento) throws SQLException {
		try {
			dao.inserirEvento(evento);
			System.out.println("service:: Evento criado com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Atualiza um evento
	 * @param Evento evento
	 * @throws SQLException
	 */
	public void atualizar(Evento evento) throws SQLException {
		try {
			dao.atualizarEvento(evento);
			System.out.println("service:: Evento atualizado com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Exclui um evento
	 * @param id
	 * @throws SQLException
	 */
	public void excluir(int id) throws SQLException {
		try {
			dao.deletarEvento(id);
			System.out.println("service:: Evento deletado com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Carrega um evento utilizando um id
	 * @param id
	 * @throws SQLException
	 */
	public void carregar(int id) throws SQLException {
		try {
			dao.consultarEvento(id);
			System.out.println("service:: Evento carregado com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Carrega um evento utilizando um cnpj
	 * @param cnpj
	 * @throws SQLException
	 */
	public void carregar(String cnpj) throws SQLException {
		try {
			dao.consultarEvento(cnpj);
			System.out.println("service:: Evento carregado com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
