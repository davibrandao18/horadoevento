package model;


/**
 * Classe que representa uma Tag.
 * 
 * @author Davi Fonseca
 * @version 2.0
 * @since 1.0 -> desde qual vers�o esta classe est� no projeto
 *
 */
public class Tag {
	
	private int id;
	private String nome;
	private int checado;
	
	/**
	 * Void constructor
	 */
	public Tag() {}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param nome
	 */
	public Tag(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	 * @return the checado
	 */
	public int isChecado() {
		return checado;
	}

	/**
	 * @param checado the checado to set
	 */
	public void setChecado(int checado) {
		this.checado = checado;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//To string//

	@Override
	public String toString() {
		return "Tag {getId()=" + getId() + ", getNome()=" + getNome() + "}";
	}
	
}