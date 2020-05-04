package service;

import dao.TagUsuarioDao;
import model.TagUsuario;

public class TagUsuarioService {
	
	TagUsuarioDao dao = new TagUsuarioDao();
	
	/**
	 * Metodo responsavel por chamar o tagUsuario DAO
	 * @since
	 * @param tagUsuario
	 */
	public void criar(TagUsuario tagUsuario) {
		dao.inserirTagUsuario(tagUsuario);
		System.out.println("Deu certo a inclusao");
	}
	
	
	/**
	 * Metodo responsavel por chamar o atualizar DAO
	 * @since
	 * @param tagUsuario
	 */
	public void atualizar(TagUsuario tagUsuario){
		dao.atualizarTagUsuario(tagUsuario);
		System.out.println("Deu certo a atualizacao ! /n"+tagUsuario.toString());
	}
	
	
	/**
	 * Metodo responsavel por chamar o excluir DAO
	 * @since
	 * @param id
	 * @param int id, 
	 */
	public void excluir(int id){
		dao.deletarTagUsuario(id);
		System.out.println("Deu certo a exclusao");
	}
	
	
	/**
	 * Metodo responsavel por chamar a consulta de tagUsuario do DAO
	 * @since
	 * @param id
	 * @return
	 */
	public TagUsuario carregar(int id){
		return dao.consultarTagUsuario(id);
	}
	
	
	/**
	 * Metodo responsavel por listar TagUsuarios com ids semelhantes
	 * @since 0.1
	 * @param id
	 * @return ArrayList TagUsuario
	public ArrayList<TagUsuario> listar(int id) {
		return dao.listarTagUsuarios(id);
	}*/
}
