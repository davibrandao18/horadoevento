package model;

/**
 * Classe que representa a associa��o entre a classe de tags e a classe de evento;
 *  
 * @author Davi Fonseca
 * @version 1.0
 * @since 2.0 -> desde qual vers�o esta classe est� no projeto
 *
 */
public class TagEvento {
	private int id;
	private Tag tag;
	private Evento evento; // --> /!\ verificar necessidade com o Igor
	
	/**
	 * Void constructor
	 */
	public TagEvento() {}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param tag
	 * @param evento
	 */
	public TagEvento(int id, Tag tag, Evento evento) {
		super();
		this.id = id;
		this.tag = tag;
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
	 * @return the tag
	 */
	public Tag getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(Tag tag) {
		this.tag = tag;
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
		return "TagEvento {Id=" + getId() + ", Tag=" + getTag().toString() + ", Evento=" + getEvento().toString() + "}";
	};
	
	
}