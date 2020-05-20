package model;

import java.io.File;

/**
 * Classe que representa um projeto
 * 
 * @author Davi Fonseca
 * @version 2.0
 * @since 1.0 -> desde qual vers�o esta classe est� no projeto
 *
 */
public class Empresa {
	private String cnpj;
	private String userName;
	private String nome;
	private String cidade;
	private String estado;
	private String pais;
	private String senha;
	private String email;
	private String linkedin;
	private File foto;
	
	/**
	 * Void constructor
	 */
	public Empresa() {}

	/**
	 * Constructor
	 * 
	 * @param cnpj
	 * @param userName
	 * @param nome
	 * @param cidade
	 * @param pais
	 * @param senha
	 * @param email
	 * @param linkedin
	 * @param foto
	 */
	public Empresa(String cnpj, String userName, String nome, String cidade, String estado, String pais, String senha, String email,
			String linkedin, File foto) {
		super();
		this.cnpj = cnpj;
		this.userName = userName;
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.senha = senha;
		this.email = email;
		this.linkedin = linkedin;
		this.foto = foto;
	}
	
	public Empresa(String cnpj, String userName, String nome, String linkedin, File foto) {
		super();
		this.cnpj = cnpj;
		this.userName = userName;
		this.nome = nome;
		this.linkedin = linkedin;
		this.foto = foto;
	}
	
	// Getters e Setters //
	
	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the linkedin
	 */
	public String getLinkedin() {
		return linkedin;
	}

	/**
	 * @param linkedin the linkedin to set
	 */
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	/**
	 * @return the foto
	 */
	public File getFoto() {
		return foto;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(File foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Empresa {CNPJ=" + this.cnpj 
				+ ", userName=" + this.userName 
				+ ", nome=" + this.nome 
				+ ", cidade=" + this.cidade
				+ ", estado=" + this.estado
				+ ", pais=" + this.pais 
				+ ", senha=" + this.senha 
				+ ", email=" + this.email 
				+ ", linkedin=" + this.linkedin 
				+ ", foto=" + this.foto
				+ "}";
	};
	
	
}