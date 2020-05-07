package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Empresa;

public class EmpresaDao {
	
	/**
	 * Metodo de insercao de empresa no Banco de Dados
	 * @author Maicon Souza
	 * @param Empresa empresa
	 */
	public void inserirEmpresa(Empresa empresa) {
		String sqlInsert = "INSERT INTO empresa"
				+"(cnpj,username,nome,cidade,estado,pais,senha,email,linkedin)"
				+"VALUES (?,?,?,?,?,?,?,?,?)";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setString(1,empresa.getCnpj());
			pst.setString(2,empresa.getUserName());
			pst.setString(3,empresa.getNome());
			pst.setString(4,empresa.getCidade());
			pst.setString(5,empresa.getPais());
			pst.setString(6,empresa.getEstado());
			pst.setString(7,empresa.getSenha());
			pst.setString(8,empresa.getEmail());
			pst.setString(9,empresa.getLinkedin());
			//TODO FOTO
			
			pst.execute();
			System.out.println("empresa inserida com sucesso!");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * Metodo para consultar empresas
	 * @author Maicon Souza
	 * @since 0.1
	 * @param String usern -> username
	 */
	public Empresa consultarEmpresa(String username) {
		String sqlSelect = "SELECT * FROM empresa WHERE username='"+username+"'";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlSelect);) {
			
			ResultSet resultado = pst.executeQuery();
			
			if (resultado.next()){
				Empresa empresa = new Empresa();
				String cnpj = resultado.getString("cnpj");
				String nome = resultado.getString("nome");
				String cidade = resultado.getString("cidade");
				String estado = resultado.getString("estado");
				String pais = resultado.getString("pais");
				String senha = resultado.getString("senha");
				String email = resultado.getString("email");
				String linkedin = resultado.getString("linkedin");
				//TODO File foto = recuperarImagem(usern); /!\ ERRO
				
				empresa.setCnpj(cnpj);
				empresa.setUserName(username);
				empresa.setNome(nome);
				empresa.setCidade(cidade);
				empresa.setEstado(estado);
				empresa.setPais(pais);
				empresa.setSenha(senha);
				empresa.setEmail(email);
				empresa.setLinkedin(linkedin);
				//TODO empresa.setFoto(foto); /!\ ERRO
				
				System.out.println("dao:: " +empresa.toString());
				return empresa;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Metodo de listagem de empresas semelhantes utilizando o username
	 * @author Davi Fonseca
	 * @since
	 * @param String username
	 * @return arraylist de empresass
	 */
	public ArrayList<Empresa> listarEmpresas(String username) {
		String sqlSelect = "SELECT * FROM empresa WHERE username LIKE '%" +username +"%'";

		ArrayList<Empresa> listaEmpresa = new ArrayList<>();
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlSelect);) {
			
			ResultSet resultado = pst.executeQuery();
			
			while(resultado.next())
				listaEmpresa.add(consultarEmpresa(resultado.getString("username")));

			return listaEmpresa;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Metodo para insercao de imagem
	 * @author Maicon Souza
	 * @since
	 * @param foto
	 * @param username
	 */
	public void inserirImagem(File foto, String username) {
			
		// Preparando String de insercao:
		String sqlUpdate = "UPDATE empresa SET foto = ?"
				+ "WHERE username = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlUpdate)) {
			
			// Fluxo de manipulacao de arquivo
			FileInputStream inputStream = new FileInputStream(foto);
			
			pst.setBinaryStream(1,				// Posicao do Sql
					(InputStream) inputStream,	// Fluxo de informacao
					(int) (foto.length())		// Quantidade de bytes
					);
			pst.setString(2, username);
			
			// Enviando a insercao no banco de dados:
			pst.execute();
			
		} catch (Exception e) {
			// Imprimido a pilha de erros:
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Metodo para recuperar a imagem do banco de dados
	 * @author Maicon Souza
	 * @since
	 * @param String username
	 */
	public File recuperarImagem(String username) {

        // Criando o SQL de consulta:
		String selectImg = "SELECT foto FROM empresa WHERE username = ?";
		
		try {
			Connection conectar = ConnectionFactory.obtemConexao();
			PreparedStatement pst = conectar.prepareStatement(selectImg);
			
			pst.setString(1, username);
			
			ResultSet resultado = pst.executeQuery();
			
			// Arquivo onde a imagem sera armazenada no disco:
			File file = new File(username +".jpg");
			
			// Objeto para tratar saida de dados para um arquivo:
			FileOutputStream output = new FileOutputStream(file);
			
			// Verificando se encontrou registro para o select:
			if (resultado.next()) {
				// Pegando o campo do tipo blob, chamado "foto":
				InputStream input = resultado.getBinaryStream("foto");
				
				// Preparando um vetor de bytes para enviar para o arquivo:
		        byte[] buffer = new byte[1024];
		        
		        // Enquanto existir conte�do no fluxo de dados, continua:
		        while (input.read(buffer) > 0) {
		        	// Escreve o conte�do no arquivo de destino no disco:
		            output.write(buffer);
		        }
				
		        // Fechando a entrada:
		        input.close();
			}
			
			// Encerra a saida:
			output.close();
			resultado.close();
			return file;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}


	/**
	 * Metodo para atualizar os dados da empresa
	 * @author Maicon Souza e Davi fonseca
	 * @since
	 * @param cnpj
	 * @param username
	 * @param nome
	 * @param cidade
	 * @param pais
	 * @param senha
	 * @param email
	 * @param linkedin
	 */
	public void atualizarEmpresa(Empresa empresa) {
		
		String atualizar = "UPDATE empresa SET cnpj = ?, username = ?, nome = ?, cidade = ?, estado = ?, pais = ?, senha = ?, email = ?, linkedin = ? WHERE username = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(atualizar)) {
			
			pst.setString(1, empresa.getCnpj());
			pst.setString(2, empresa.getUserName());
			pst.setString(3, empresa.getNome());
			pst.setString(4, empresa.getCidade());
			pst.setString(5, empresa.getEstado());
			pst.setString(6, empresa.getPais());
			pst.setString(7, empresa.getSenha());
			pst.setString(8, empresa.getEmail());
			pst.setString(9, empresa.getLinkedin());
			pst.setString(10, empresa.getUserName());

			pst.executeUpdate();
			System.out.println("Dados atualizados com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Metodo para deletar uma empresa do banco de dados
	 * @author Maicon Souza e Davi Fonseca
	 * @since
	 * @param username
	 * @param cnpj
	 */
	public void deletarEmpresa(String username, String cnpj) {
		
		//Preparando a String para atualizacao:
		String deletar = "DELETE FROM empresa WHERE username = ? && cnpj = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(deletar)) {

			pst.setString(1, username);
			pst.setString(1, cnpj);
			
			//Enviando um comando para o MySQL
			pst.execute();
			System.out.println("Dados excluidos com sucesso");
			
		} catch (Exception e) {
			//Imprimido a pilha de erros:
			e.printStackTrace();
		}
	}
}