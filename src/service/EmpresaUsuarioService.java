package service;

import dao.EmpresaUsuarioDao;
import model.TagEvento;

public class EmpresaUsuarioService {
	

	/**
	 * Instanciar o responsavel por chamar o EmpresaUsuario DAO
	 */
	EmpresaUsuarioDao dao = new EmpresaUsuarioDao();
	
	/**
	 * Metodo responsavel por chamar o tagEvento DAO
	 * @since
	 * @param tagEvento
	 */
	public void criar(TagEvento tagEvento) {
		dao.inserirTagEvento(tagEvento);
		System.out.println("Deu certo a inclusao");
	}
	
	
	/**
	 * Metodo responsavel por chamar o atualizar DAO
	 * @since
	 * @param tagEvento
	 */
	public void atualizar(TagEvento tagEvento){
		dao.atualizarTagEvento(tagEvento);
		System.out.println("Deu certo a atualizacao ! /n"+tagEvento.toString());
	}
	
	
	/**
	 * Metodo responsavel por chamar o excluir DAO
	 * @since
	 * @param id
	 * @param int id, 
	 */
	public void excluir(int id){
		dao.deletarTagEvento(id);
		System.out.println("Deu certo a exclusao");
	}
	
	
	/**
	 * Metodo responsavel por chamar a consulta de tagEvento do DAO
	 * @since
	 * @param id
	 * @return
	 */
	public TagEvento carregar(int id){
		return dao.consultarTagEvento(id);
	}
	
	
	/**
	 * Metodo responsavel por listar TagEventos com ids semelhantes
	 * @since 0.1
	 * @param id
	 * @return ArrayList TagEvento
	public ArrayList<TagEvento> listar(int id) {
		return dao.listarTagEventos(id);
	}*/
	
}
