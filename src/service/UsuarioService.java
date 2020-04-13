package service;

import model.Usuario;
import dao.UsuarioDao;


public class UsuarioService {
	UsuarioDao dao = new UsuarioDao();
	
	public void criar(Usuario usuario) {
		System.out.println("deu certo a cria��o id = "+usuario.getCpf());
	}
	
	public void atualizar(Usuario usuario){
		dao.atualizar(usuario);
	}
	
	public void excluir(Usuario usuario){
		dao.deletar(usuario);
	}
	
	public Usuario carregar(Usuario usuario){
		return dao.carregar(usuario);
	}

}