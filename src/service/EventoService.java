package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.EventoDao;
import model.Evento;
import model.Tag;

/**
 * Classe que representa um evento
 * @author maicon
 * @version 1.0
 *
 */
public class EventoService {

	private EventoDao dao = new EventoDao();
	
	/**
	 * Cria um evento
	 * @param Evento evento
	 * @throws SQLException
	 */
	public int criar(Evento evento) {
		try {
			int id = dao.inserirEvento(evento);
			return id;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Atualiza um evento
	 * @param Evento evento
	 * @throws SQLException
	 */
	public void atualizar(Evento evento) throws SQLException {
		try {
			dao.atualizarEvento(evento);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Exclui um evento
	 * @param id
	 * @throws SQLException
	 */
	public void excluir(int id) {
		try {
			dao.deletarEvento(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void excluir(String cnpj) throws SQLException {
		dao.deletarEvento(cnpj);
	}
	
	/**
	 * Carrega um evento utilizando um id
	 * @param id
	 * @throws SQLException
	 */
	public Evento carregar(int id) {
		try {
			Evento ev = dao.consultarEvento(id);
			return ev ;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Evento> carregar(String cnpj) {
	    return dao.consultarEventos(cnpj);
	}
	
	public ArrayList<Evento> carregarTresProximosEventos(String cnpj) {
	    return dao.consultarTresProximosEventos(cnpj);
	}
	
	public ArrayList<Evento> carregarEventosPassados(String cnpj) {
        return dao.consultarEventosPassados(cnpj);
    }
	
	public ArrayList<Evento> carregarEventosFuturos(String cnpj) {
        return dao.consultarEventosFuturos(cnpj);
    }
	
	/**
	 * metodo para inserir tags
	 * @param tags
	 * @param user
	 */
	public void inserirTag(ArrayList<Tag> tags, Evento evento){
		for (Tag tag : tags) {
			dao.inserirTag(evento.getId(), tag.getId());
		}
	}
	
	
	public ArrayList<Evento> listar(String nome) {
		return dao.listarEventos(nome);
	}
}
