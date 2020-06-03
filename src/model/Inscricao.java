package model;

/**
 * Classe que representa uma inscricao.
 * 
 * @author Davi Fonseca
 * @version 1.0
 * @since 2.0 -> desde qual vers�o esta classe est� no projeto
 *
 */
public class Inscricao {
	private int id;
	private Usuario user;
	private Evento evento;
	
	/**
	 * Void constructor
	 */
	public Inscricao() {}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param user
	 * @param evento
	 */
	public Inscricao(int id, Usuario user, Evento evento) {
		this.id = id;
		this.user = user;
		this.evento = evento;
	}
	
	//Getters and Setters//

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public Usuario getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Usuario user) {
		this.user = user;
	}

	/**
	 * @return the evento
	 */
	public Evento getEvento() {
		return evento;
	}

	/**
	 * @param evento the evento to set
	 */
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	// To String //

	@Override
	public String toString() {
		return "Inscricao {Id=" + this.id + ", User=" + this.user.toString() + ", Evento=" + this.evento.toString() + "}";
		//return "Inscricao {Id=" + this.id + "}";
	};
	
	
	
}