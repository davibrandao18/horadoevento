/**
 * 
 */
package model;

import java.util.GregorianCalendar;

/**
 * Classe que representa um Certificado
 * 
 * @author Davi Fonseca
 * @version 1.0
 * @since 2.0 -> desde qual vers�o esta classe est� no projeto
 *
 */
public class Certificado {
	private int id;
	private Usuario user;
	private Evento evento;
	private GregorianCalendar quantidadeHoras; // --> /!\ verificar como fazer isso com o Igor
	
	/**
	 * 
	 */
	public Certificado() {}

	/**
	 * @param id
	 * @param user
	 * @param evento
	 */
	public Certificado(int id, Usuario user, Evento evento, GregorianCalendar quantidadeHoras) {
		this.id = id;
		this.user = user;
		this.evento = evento;
		this.quantidadeHoras = quantidadeHoras;
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
	 * @return the quantidadeHoras
	 */
	public GregorianCalendar getQuantidadeHoras() {
		return quantidadeHoras;
	}

	/**
	 * @param quantidadeHoras the quantidadeHoras to set
	 */
	public void setQuantidadeHoras(GregorianCalendar quantidadeHoras) {
		this.quantidadeHoras = quantidadeHoras;
	}
	
	// To String //
	
	@Override
	public String toString() {
		return "Certificado {Id=" + getId() + ", User=" + getUser() + ", Evento=" + getEvento()
				+ ", Quantidade Horas=" + getQuantidadeHoras() + "}";
	}
	
	
}