package model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Classe que representa um Evento.
 * 
 * @author Davi Fonseca
 * @version 1.0
 * @since 2.0 -> desde qual vers�o esta classe est� no projeto
 *
 */
public class Evento {
	private int id;
	private String titulo;
	private String descricao;
	private GregorianCalendar data;
	private String localizacao;
	private String duracao;
	private int quantidadeVagas;
	private String palestrante;
	private ArrayList<TagUsuario> colecaoTags;
	private Empresa empresa;
	
	/**
	 * Void constructor
	 */
	public Evento() {}

	/**
	 * @param id
	 * @param titulo
	 * @param descricao
	 * @param data
	 * @param localizacao
	 * @param duracao
	 * @param quantidadeVagas
	 * @param palestrante
	 * @param colecaoTags
	 * @param empresa
	 */
	public Evento(int id, String titulo, String descricao, GregorianCalendar data, String localizacao, String duracao,
			int quantidadeVagas, String palestrante, ArrayList<TagUsuario> colecaoTags, Empresa empresa) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.localizacao = localizacao;
		this.duracao = duracao;
		this.quantidadeVagas = quantidadeVagas;
		this.palestrante = palestrante;
		this.colecaoTags = colecaoTags;
		this.empresa = empresa;
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
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the data
	 */
	public GregorianCalendar getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	/**
	 * @return the localizacao
	 */
	public String getLocalizacao() {
		return localizacao;
	}

	/**
	 * @param localizacao the localizacao to set
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * @return the duracao
	 */
	public String getDuracao() {
		return duracao;
	}

	/**
	 * @param duracao the duracao to set
	 */
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	/**
	 * @return the quantidadeVagas
	 */
	public int getQuantidadeVagas() {
		return quantidadeVagas;
	}

	/**
	 * @param quantidadeVagas the quantidadeVagas to set
	 */
	public void setQuantidadeVagas(int quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}

	/**
	 * @return the palestrante
	 */
	public String getPalestrante() {
		return palestrante;
	}

	/**
	 * @param palestrante the palestrante to set
	 */
	public void setPalestrante(String palestrante) {
		this.palestrante = palestrante;
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
		return "Evento {ID=" + getId() 
				+ ", Titulo=" + getTitulo()
				+ ", Descricao=" + getDescricao()
				+ ", Data=" + getData()
				+ ", Localizacao=" + getLocalizacao()
				+ ", Duracao="+ getDuracao() 
				+ ", Quantidade Vagas=" + getQuantidadeVagas()
				+ ", Palestrante=" + getPalestrante()
				+ ", ColecaoTags=" + getColecaoTags()
				+ ", Empresa=" + getEmpresa().toString()
				+ "}";
	}

	
	
	
}