package service;

import java.util.ArrayList;

//import java.util.ArrayList;

import dao.TagDao;
import model.Evento;
import model.Tag;
import model.Usuario;

public class TagService {
	
	/**
	 * Instanciar o responsavel por chamar o Tag DAO
	 */
	private TagDao dao = new TagDao();
	
	/**
	 * Metodo responsavel por chamar o criar DAO
	 * @since
	 * @param tag
	 */
	public void criar(Tag tag) {
		dao.inserirTag(tag);
		System.out.println("Deu certo a inclusao");
	}
	
	
	/**
	 * Metodo responsavel por chamar o atualizar DAO
	 * @since
	 * @param tag
	 */
	public void atualizar(Tag tag){
		dao.atualizarTag(tag);
		System.out.println("Deu certo a atualizacao ! /n"+tag.toString());
	}
	
	
	/**
	 * Metodo responsavel por chamar o excluir DAO
	 * @since
	 * @param id
	 * @param String id, String cnpj
	 */
	public void excluir(int id){
		dao.deletarTag(id);
		System.out.println("Deu certo a exclusao");
	}
	
	
	/**
	 * Metodo responsavel por chamar a consulta de tag do DAO
	 * @since
	 * @param id
	 * @return
	 */
	public ArrayList<Tag> carregar(){
		return dao.consultarTags();
	}
	
	public Tag carregar(int id){
		return dao.consultarTag(id);
	}
	
	/**
	 * Metodo responsavel por carregar ArrayList de tag_usuario
	 * @param user
	 * @return
	 */
	public ArrayList<Tag> carregarTagUsuario(Usuario user){
		return dao.tagUsuario(user.getCpf());
	}
	
	/**
     * Metodo responsavel por carregar ArrayList de tag_evento
     * @param evento
     * @return
     */
	public ArrayList<Tag> carregarTagEvento(Evento evento){
		return dao.tagEvento(evento.getId());
	}
	
	public ArrayList<Evento> carregarEventoPorTag(int id) {
	    return dao.consultarEventoPorTag(id);
	}
	
	/**
	 * Metodo responsavel por listar Tags com ids semelhantes
	 * @since 0.1
	 * @param id
	 * @return ArrayList Tag
	public ArrayList<Tag> listar(String id) {
		return dao.listarTags(id);
	}*/
}
