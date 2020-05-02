package service;

import java.util.ArrayList;

import dao.EmpresaDao;

import model.Empresa;

/**
 * Classe responsável por chamar as DAO's de Empresa
 * @author Davi Fonseca
 * @version 0.1
 * @since 0.1
 */
public class EmpresaService {
	
	private EmpresaDao dao = new EmpresaDao();
	
	/**
	 * Metodo responsavel por chamar o empresa DAO
	 * @since
	 * @param empresa
	 */
	public void criar(Empresa empresa) {
		dao.inserirEmpresa(empresa);
		System.out.println("Deu certo a inclusao");
	}
	
	
	/**
	 * Metodo responsavel por chamar o atualizar DAO
	 * @since
	 * @param empresa
	 */
	public void atualizar(Empresa empresa){
		dao.atualizarEmpresa(empresa);
		System.out.println("Deu certo a atualizacao ! /n"+empresa.toString());
	}
	
	
	/**
	 * Metodo responsavel por chamar o excluir DAO
	 * @since
	 * @param username
	 * @param String username, String cnpj
	 */
	public void excluir(String username, String cnpj){
		dao.deletarEmpresa(username, cnpj);
		System.out.println("Deu certo a exclusao");
	}
	
	
	/**
	 * Metodo responsavel por chamar a consulta de empresa do DAO
	 * @since
	 * @param username
	 * @return
	 */
	public Empresa carregar(String username){
		return dao.consultarEmpresa(username);
	}
	
	
	/**
	 * Metodo responsavel por listar Empresas com usernames semelhantes
	 * @since 0.1
	 * @param username
	 * @return ArrayList Empresa
	 */
	public ArrayList<Empresa> listar(String username) {
		return dao.listarEmpresas(username);
	}
	
}
