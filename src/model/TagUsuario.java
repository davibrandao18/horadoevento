package model;

/**
 * Classe que representa a associa��o entre a classe de tags e a classe de usuario;
 * 
 * @author Davi Fonseca
 * @version 1.0
 * @since 2.0 -> desde qual vers�o esta classe est� no projeto
 *
 */
public class TagUsuario {
	
	private int id;
	private Tag tag;
	private Usuario user;
	
	/**
	 * Void constructor
	 */
	public TagUsuario() {};
	
	/**
	 * Constructor
	 * 
	 * @param id
	 * @param tag
	 * @param user
	 */
	public TagUsuario(int id, Tag tag, Usuario user) {
		super();
		this.id = id;
		this.tag = tag;
		this.user = user;
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
	
	//To String//

	@Override
	public String toString() {
		return "TagUsuario {ID=" + getId() + ", Tag=" + getTag() + "User=" + getUser() + "}";
	};
	
	
}