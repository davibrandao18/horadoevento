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
			System.out.println("Service:"+evento.toString());
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
			System.out.println("service: Evento atualizado com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Exclui um evento
	 * @param id
	 * @throws SQLException
	 */
	public void excluir(int id)  {
		try {
			dao.deletarEvento(id);
			System.out.println("service: Evento deletado com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Carrega um evento utilizando um id
	 * @param id
	 * @throws SQLException
	 */
	public Evento carregar(int id) {
		try {
			Evento ev = dao.consultarEvento(id);
			System.out.println("service: Evento carregado com sucesso"+ev.toString());
			return ev ;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * metodo para inserir tags
	 * @param tags
	 * @param user
	 */
	public void inserirTag(ArrayList<Tag> tags, Evento evento){
		for (Tag tag : tags) {
			System.out.println("Service evento: Tag id "+tag.getId()+", evento id "+evento.getId());
			dao.inserirTag(evento.getId(), tag.getId());
		}
	}
	
	
	public ArrayList<Evento> listar(String nome) {
		return dao.listarEventos(nome);
	}
}
