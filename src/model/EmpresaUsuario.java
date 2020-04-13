package model;

/**
 * Classe que representa a associa��o entre a classe de Empresa e a classe de Usuario;
 * 
 * @author Davi Fonseca
 * @version 2.0
 * @since 1.0 -> desde qual vers�o esta classe est� no projeto
 *
 */
public class EmpresaUsuario {
	private int id;
	private Usuario user;
	private Empresa empresa;
	
	/**
	 * Void construtor
	 */
	public EmpresaUsuario() {}

	/**
	 * @param id
	 * @param user
	 * @param empresa
	 */
	public EmpresaUsuario(int id, Usuario user, Empresa empresa) {
		this.id = id;
		this.user = user;
		this.empresa = empresa;
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
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "EmpresaUsuario {Id=" + getId()
				+ ", User=" + getUser().toString()
				+ ", Empresa=" + getEmpresa().toString()
				+ "}";
	};
	
}