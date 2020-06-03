package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import dao.UsuarioDao;
import model.Empresa;
import model.Tag;
import model.Usuario;
import teste.ValidaUsuario;

/**
 * Classe responsável por chamar as DAO's de Usuario
 * @author Davi Fonseca
 * @version 0.4
 * @since 0.1
 */
public class UsuarioService {
	
	/**
	 * Atributo para instanciar a classe UsuarioDao
	 */
	private UsuarioDao dao = new UsuarioDao();
	
	
	/**
	 * Metodo responsavel por chamar o inserir DAO
	 * @since
	 * @param usuario
	 * @throws FileNotFoundException 
	 */
	public boolean criar(Usuario usuario) {
		if (ValidaUsuario.validacao(usuario.getUserName(), usuario.getCpf(), usuario.getSenha()) == true) {
			dao.inserirUsuario(usuario);
			System.out.println("Deu certo a inclusao");
			return true;
		} else
			return false;
	}
	
	
	/**
	 * Metodo responsavel por chamar o atualizar DAO
	 * @since
	 * @param usuario
	 */
	public void atualizar(Usuario usuario){
		dao.atualizarUsuario(usuario);
	}
	
	
	/**
	 * Metodo responsavel por chamar o excluir DAO
	 * @since
	 * @param username
	 * @param cpf
	 */
	public void excluir(String username, String cpf){
		dao.deletarUsuario(username, cpf);
		System.out.println("Deu certo a exclusao");
	}
	
	
	/**
	 * Metodo responsavel por chamar a consulta de usuario do DAO
	 * @since
	 * @param username
	 * @return
	 */
	public Usuario carregar(String username, String path){
		return dao.consultarUsuario(username, path);
	}
	
	/**
	 * Carregar sem foto
	 * @param username
	 * @return
	 */
	public Usuario carregar(String username){
		return dao.consultarUsuario(username);
	}
	
	/**
	 * Carregar sem foto
	 * @param username
	 * @return
	 */
	public Usuario carregarCPF(String cpf){
		return dao.consultarUsuarioCpf(cpf);
	}
	
	
	/**
	 * metodo para criar imagem
	 * @param foto
	 * @param username
	 */
	public void criarImagem(File foto, String username) {
		dao.inserirImagem(foto, username);
		System.out.println("service: foto inserida com sucesso!");
	}
	
	/**
	 * Metodo responsavel por listar usuarios com usernames semelhantes
	 * @since 0.1
	 * @param username
	 * @return
	 */
	public ArrayList<Usuario> listar(String username) {
		return dao.listarUsuarios(username);
	}
	
	/**
	 * metodo para inserir tags
	 * @param tags
	 * @param user
	 */
	public void inserirTag(Usuario user){
		for (Tag tag : user.getColecaoTags()) {
			dao.inserirTag(user.getCpf(), tag.getId());
		}
	}
	
	public void excluirTags(Usuario user) {
		dao.deletarTags(user.getCpf());
	}
	
	/**
	 * metodo para inserir empresa
	 * @param tags
	 * @param user
	 */
	public void inserirEmpresa(ArrayList<Empresa> empresas, Usuario user){
		for (Empresa empresa : empresas) {
			dao.inserirEmpresa(user.getCpf(), empresa.getCnpj());
		}
	}
}