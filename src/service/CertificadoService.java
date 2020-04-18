package service;

import dao.CertificadoDao;
import model.Certificado;

public class CertificadoService {
	
	/**
	 * Atributo para instanciar a classe CertificadoDao
	 */
	private CertificadoDao dao = new CertificadoDao();
	
	/**
	 * Metodo responsavel por chamar o criar DAO
	 * 
	 * @param Certificado certificado
	 */
	public void criar(Certificado certificado){
		dao.criarCertificado(certificado);
		System.out.println("Deu certo a inclusao");
	}
	
	/**
	 * Metodo responsavel por chamar o deletar DAO
	 * 
	 * @param int id
	 */
	public void excluir(int id) {
		dao.deletarCertificado(id);
		System.out.println("Deu certo a exclusao");
	}
	
	/**
	 * Metodo responsavel por chamar o atualizar DAO
	 * 
	 * @param Certificado certificado
	 */
	public void atualizar(Certificado certificado) {
		dao.atualizarCertificado(certificado);
		System.out.println("Deu certo a atualizacao ! /n"+certificado.toString());
	}
	
	/**
	 * Metodo responsavel por chamar a consulta de certificado do DAO
	 * 
	 * @param id
	 * @return Certificado
	 */
	public Certificado carregar(int id) {
		return dao.consultarCertificado(id);
	}
	
}
