package model;

import java.util.ArrayList;
import java.io.File;

/**
 * Classe que representa um Usuario
 * 
 * @author Davi Fonseca
 * @version 2.0
 * @since 1.0 -> desde qual versao esta classe est� no projeto
 *
 */
public class Usuario  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String cpf;
	private String userName;
	private String nome;
	private String email;
	private String senha;
	private String linkedin;
	private ArrayList<TagUsuario> colecaoTags;
	private ArrayList<Certificado> colecaoCertificados;
	private ArrayList<EmpresaUsuario> colecaoEmpresas;
	private File foto;
	
	/**
	 * Void constructor
	 */
	public Usuario() {};
	
	
	
	/**
	 * Construtor cheio
	 * 
	 * @param cpf
	 * @param userName
	 * @param nome
	 * @param email
	 * @param senha
	 * @param linkedin
	 * @param colecaoTags
	 * @param colecaoCertificados
	 * @param colecaoEmpresas
	 * @param foto
	 */
	public Usuario(String cpf, String userName, String nome, String email, String senha, String linkedin,
			ArrayList<TagUsuario> colecaoTags, ArrayList<Certificado> colecaoCertificados,
			ArrayList<EmpresaUsuario> colecaoEmpresas, File foto) {
		this.cpf = cpf;
		this.userName = userName;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.linkedin = linkedin;
		this.colecaoTags = colecaoTags;
		this.colecaoCertificados = colecaoCertificados;
		this.colecaoEmpresas = colecaoEmpresas;
		this.foto = foto;
	}

	
	// Getters e Setters //


	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}



	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	 * @return the colecaoTags
	 */
	public ArrayList<TagUsuario> getColecaoTags() {
		return colecaoTags;
	}



	/**
	 * @param colecaoTags the colecaoTags to set
	 */
	public void setColecaoTags(ArrayList<TagUsuario> colecaoTags) {
		this.colecaoTags = colecaoTags;
	}



	/**
	 * @return the colecaoCertificados
	 */
	public ArrayList<Certificado> getColecaoCertificados() {
		return colecaoCertificados;
	}



	/**
	 * @param colecaoCertificados the colecaoCertificados to set
	 */
	public void setColecaoCertificados(ArrayList<Certificado> colecaoCertificados) {
		this.colecaoCertificados = colecaoCertificados;
	}



	/**
	 * @return the colecaoEmpresas
	 */
	public ArrayList<EmpresaUsuario> getColecaoEmpresas() {
		return colecaoEmpresas;
	}



	/**
	 * @param colecaoEmpresas the colecaoEmpresas to set
	 */
	public void setColecaoEmpresas(ArrayList<EmpresaUsuario> colecaoEmpresas) {
		this.colecaoEmpresas = colecaoEmpresas;
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

	// To String //

	@Override
	public String toString() {
		return "Usuario{CPF: "+this.cpf
					+", User name: "+this.userName
					+", Nome: "+this.nome
					+", E-mail: "+this.email
					+", Senha: "+this.senha
					+", Link Linkedin:"+this.linkedin
					+", Tags: "+this.colecaoTags
					+", Certificados:"+this.colecaoCertificados
					+", Empresas: "+this.colecaoEmpresas
					+", Foto: "+this.foto
				 	+"}";
	}
	
}