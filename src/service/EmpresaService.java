package service;

import java.io.File;
import java.util.ArrayList;

import dao.EmpresaDao;

import model.Empresa;
import teste.ValidaEmpresa;

/**
 * Classe responsável por chamar as DAO's de Empresa
 * @author Davi Fonseca
 * @version 0.2
 * @since 0.1
 */
public class EmpresaService {
	
	private EmpresaDao dao = new EmpresaDao();
	
	/**
	 * Metodo responsavel por chamar o cricao no DAO
	 * @version 0.2
	 * @since
	 * @param empresa
	 */
	public boolean criar(Empresa empresa) {
		if (ValidaEmpresa.validacao(empresa.getUserName(), empresa.getCnpj(), empresa.getSenha()) == true) {
			dao.inserirEmpresa(empresa);
			System.out.println("Deu certo a inclusao");
			return true;
		} else
			System.out.println("Service:"+ValidaEmpresa.validacao(empresa.getUserName(), empresa.getCnpj(), empresa.getSenha()));
			return false;
	}
	
	
	/**
	 * Metodo responsavel por chamar o atualizazao no DAO
	 * @since
	 * @param empresa
	 */
	public void atualizar(Empresa empresa){
		dao.atualizarEmpresa(empresa);
		System.out.println("Deu certo a atualizacao ! /n"+empresa.toString());
	}
	
	
	/**
	 * Metodo responsavel por chamar o exclusao no DAO
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
     * Metodo responsavel por chamar a consulta de empresa do DAO
     * @since
     * @param username
     * @return
     */
    public Empresa carregarCpf(String cnpj){
        return dao.consultarEmpresaCnpj(cnpj);
    }
	
	/**
	 * Metodo responsavel por chamar a consulta de empresa com foto do DAO
	 * @param username
	 * @param path
	 * @return
	 */
	public Empresa carregar(String username, String path){
		return dao.consultarEmpresa(username, path);
	}
	
	/**
	 * metodo para criar imagem
	 * @param foto
	 * @param username
	 */
	public void criarImagem(File foto, String username) {
		dao.inserirImagem(foto, username);
		System.out.println("service empresa: foto inserida com sucesso!");
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
