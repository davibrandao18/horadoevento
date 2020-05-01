package service;

import model.Usuario;
import java.util.ArrayList;
import dao.UsuarioDao;


public class UsuarioService {
	
	/**
	 * Atributo para instanciar a classe UsuarioDao
	 */
	private UsuarioDao dao = new UsuarioDao();
	
	
	/**
	 * Metodo responsavel por chamar o inserir DAO
	 * @since
	 * @param usuario
	 */
	public void criar(Usuario usuario) {
		dao.inserirUsuario(usuario);
		System.out.println("Deu certo a inclusao");
	}
	
	
	/**
	 * Metodo responsavel por chamar o atualizar DAO
	 * @since
	 * @param usuario
	 */
	public void atualizar(Usuario usuario){
		dao.atualizarUsuario(usuario);
		System.out.println("Deu certo a atualizacao ! /n"+usuario.toString());
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
	public Usuario carregar(String cpf){
		return dao.consultarUsuario(cpf);
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
}