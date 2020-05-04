/**
 * 
 */
package model;

/**
 * Classe que representa um Certificado
 * 
 * @author Davi Fonseca
 * @version 1.0
 * @since 2.0 -> desde qual versao a classe esta no projeto
 *
 */
public class Certificado {
	private int id;
	private Usuario user;
	private Evento evento;
	private int quantidadeMinutos;
	
	/**
	 * 
	 */
	public Certificado() {}

	/**
	 * @param id
	 * @param user
	 * @param evento
	 * @param quantidadeMinutos
	 */
	public Certificado(int id, Usuario user, Evento evento, int quantidadeMinutos) {
		this.id = id;
		this.user = user;
		this.evento = evento;
		this.quantidadeMinutos = quantidadeMinutos;
	}
	
	// Getters e Setters //
	
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
	
	/**
	 * @return the quantidadeMinutos
	 */
	public int getQuantidadeMinutos() {
		return quantidadeMinutos;
	}

	/**
	 * @param quantidadeMinutos the quantidadeMinutos to set
	 */
	public void setQuantidadeMinutos(int quantidadeMinutos) {
		this.quantidadeMinutos = quantidadeMinutos;
	}
	
	// To String //
	
	@Override
	public String toString() {
		return "Certificado {Id=" + getId() + ", User=" + getUser() + ", Evento=" + getEvento()
				+ ", Quantidade Minutos=" + getQuantidadeMinutos() + "}";
	}
	
	
}