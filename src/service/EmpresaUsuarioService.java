package service;

import dao.EmpresaUsuarioDao;
import model.EmpresaUsuario;

public class EmpresaUsuarioService {
	

	/**
	 * Instanciar o responsavel por chamar o EmpresaUsuario DAO
	 */
	EmpresaUsuarioDao dao = new EmpresaUsuarioDao();
	
	/**
	 * Metodo responsavel por chamar o empresaUsuario DAO
	 * @since
	 * @param empresaUsuario
	 */
	public void criar(EmpresaUsuario empresaUsuario) {
		dao.inserirEmpresaUsuario(empresaUsuario);
		System.out.println("Deu certo a inclusao");
	}
	
	
	/**
	 * Metodo responsavel por chamar o atualizar DAO
	 * @since
	 * @param empresaUsuario
	 */
	public void atualizar(EmpresaUsuario empresaUsuario){
		dao.atualizarEmpresaUsuario(empresaUsuario);
		System.out.println("Deu certo a atualizacao ! /n"+empresaUsuario.toString());
	}
	
	
	/**
	 * Metodo responsavel por chamar o excluir DAO
	 * @since
	 * @param id
	 * @param int id, 
	 */
	public void excluir(int id){
		dao.deletarEmpresaUsuario(id);
		System.out.println("Deu certo a exclusao");
	}
	
	
	/**
	 * Metodo responsavel por chamar a consulta de empresaUsuario do DAO
	 * @since
	 * @param id
	 * @return
	 */
	public EmpresaUsuario carregar(int id){
		return dao.consultarEmpresaUsuario(id);
	}
	
	
	/**
	 * Metodo responsavel por listar EmpresaUsuarios com ids semelhantes
	 * @since 0.1
	 * @param id
	 * @return ArrayList EmpresaUsuario
	public ArrayList<EmpresaUsuario> listar(int id) {
		return dao.listarEmpresaUsuarios(id);
	}*/
	
}
