package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.EmpresaUsuario;
import service.UsuarioService;
import service.EmpresaService;

/**
 * Data Acess Object para representar a tabela de relacionamento entre empresa e usuario
 * 
 * @author Davi Fonseca
 * @version
 * @since 
 */
public class EmpresaUsuarioDao {
	
	/**
	 * Metodo de insercao de registro EmpresaUsuario no Banco de dados
	 * @param EmpresaUsuario empresaUsr
	 */
	public void inserirEmpresaUsuario(EmpresaUsuario empresaUsr) {
		String sqlInsert = "INSERT INTO empresa_usuario"
				+"(fk_usuario_cpf,fk_empresa_cnpj)"
				+"VALUES (?,?)";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setString(1,empresaUsr.getUser().getCpf());
			pst.setString(2,empresaUsr.getEmpresa().getCnpj());
			
			pst.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo para consultar registros da tabela Empresa_Usuario:
	 * @param id
	 * @return
	 */
	public EmpresaUsuario consultarEmpresaUsuario(int id){
		String sqlConsu = "SELECT * FROM empresa_usuario"
				+"WHERE id = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlConsu);) {
			pst.setInt(1,id);
			
			//quando precisa de retorno do banco "ResultSet"//
			ResultSet resultado = pst.executeQuery();
			
			//+"(cpf,username,nome,email,senha,linkedin,foto)"
			if (resultado.next()){
				EmpresaUsuario empresaUsuario = new EmpresaUsuario();
				String cpfUser = resultado.getString("fk_usuario_cpf");
				String cnpjEmp = resultado.getString("fk_empresa_cnpj");
				
				empresaUsuario.setId(id);
				
				UsuarioService us = new UsuarioService();
				empresaUsuario.setUser(us.carregar(cpfUser));
				
				EmpresaService es = new EmpresaService();
				empresaUsuario.setEmpresa(es.carregar(cnpjEmp));
		
				return empresaUsuario;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Metodo para deletar registro de EmpresaUsuario no Banco de dados
	 * @param id
	 */
	public void deletarEmpresaUsuario(int id){
		String deletar = "DELETE FROM empresa_usuario WHERE id = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(deletar)) {

			pst.setInt(1, id);
			
			//Enviando um comando para o MySQL
			pst.execute();
			
		} catch (Exception e) {
			//Imprimido a pilha de erros:
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para atualizar registro de EmpresaUsuario no Banco de dados
	 * @param empresaUsr
	 */
	public void atualizarEmpresaUsuario(EmpresaUsuario empresaUsr){
		String atualizar = "UPDATE empresa_usuario SET fk_usuario_cpf = ?, fk_empresa_cnpj = ? WHERE id = "+empresaUsr.getId();
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(atualizar)) {
			pst.setString(1, empresaUsr.getUser().getCpf());
			pst.setString(2, empresaUsr.getEmpresa().getCnpj());	
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
