package service;

import java.util.ArrayList;

import dao.InscricaoDao;
import model.Inscricao;

/**
 * Classe responsável por chamar as DAO's de Incricao
 * @author Davi Fonseca
 * @version 0.1
 * @since 0.1
 */
public class InscricaoService {
	
	private InscricaoDao dao = new InscricaoDao();
	
	/**
	 * Metodo responsavel por chamar o inserir DAO
	 * @since
	 * @param inscricao
	 */
	public void criar(Inscricao inscricao) {
		dao.criarInscricao(inscricao);
		System.out.println("Deu certo a inclusao");
	}
	
	
	/**
	 * Metodo responsavel por chamar o atualizar DAO
	 * @since
	 * @param inscricao
	 */
	public void atualizar(Inscricao inscricao){
		dao.atualizarInscricao(inscricao);
		System.out.println("Deu certo a atualizacao ! /n"+inscricao.toString());
	}
	
	
	/**
	 * Metodo responsavel por chamar o excluir DAO
	 * @since
	 * @param username
	 * @param id
	 */
	public void excluir(int id){
		dao.deletarInscricao(id);
		System.out.println("Deu certo a exclusao");
	}
	
	
	/**
	 * Metodo responsavel por chamar a consulta de inscricao do DAO
	 * @since
	 * @param username
	 * @return
	 */
	public Inscricao carregar(int id){
		return dao.consultarInscricao(id);
	}
	
	
	/**
	 * Metodo responsavel por listar inscricoes de um determinado usuário
	 * @since 0.1
	 * @param username
	 * @return
	 */
	public ArrayList<Inscricao> listar(String cpf) {
		return dao.listarInscricoes(cpf);
	}
	
}
