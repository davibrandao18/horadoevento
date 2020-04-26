package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Empresa;
public class EmpresaDao {
	
	/**
	 * Metodo de insercao de empresa no Banco de Dados
	 * @author Maicon Souza
	 * @param Empresa empresa
	 */
	public void inserirEmpresa(Empresa empresa) {
		String sqlInsert = "INSERT INTO empresa"
				+"(cnpj,username,nome,cidade,pais,senha,email,linkedin)"
				+"VALUES (?,?,?,?,?,?,?,?)";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setString(1,empresa.getCnpj());
			pst.setString(2,empresa.getUserName());
			pst.setString(3,empresa.getNome());
			pst.setString(4,empresa.getCidade());
			pst.setString(4,empresa.getPais());
			pst.setString(5,empresa.getSenha());
			pst.setString(6,empresa.getEmail());
			pst.setString(7,empresa.getLinkedin());
			
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
	public Empresa consultarEmpresa(String usern) {
		String sqlSelect = "SELECT * FROM empresa"
				+"WHERE username = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlSelect);) {
			pst.setString(1,usern);
			
			// Retorno do banco
			ResultSet resultado = pst.executeQuery();
			
			Empresa empresa = null;
			//+"(cpf,username,nome,email,senha,linkedin,foto)"
			if (resultado.next()){
				empresa = new Empresa();
				String cnpj = resultado.getString("cnpj");
				String username = resultado.getString("username");
				String nome = resultado.getString("nome");
				String cidade = resultado.getString("cidade");
				String pais = resultado.getString("pais");
				String senha = resultado.getString("senha");
				String email = resultado.getString("email");
				String linkedin = resultado.getString("linkedin");
				File foto = recuperarImagem(usern);
				
				empresa.setCnpj(cnpj);
				empresa.setUserName(username);
				empresa.setNome(nome);
				empresa.setCidade(cidade);
				empresa.setPais(pais);
				empresa.setSenha(senha);
				empresa.setEmail(email);
				empresa.setLinkedin(linkedin);
				empresa.setFoto(foto);
				
				return empresa;
			}
			
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
	 * @author Maicon Souza
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
	public void atualizarEmpresa(String cnpj, String username, String nome, String cidade, String pais, String senha, String email, String linkedin) {
		
		String atualizar = "UPDATE empresa SET cnpj = ?, username = ?, nome = ?, cidade = ?, pais = ?, senha = ?, email = ?, linkedin = ? WHERE username = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(atualizar)) {
			
			pst.setString(1, cnpj);
			pst.setString(2, username);
			pst.setString(3, nome);
			pst.setString(4, cidade);
			pst.setString(5, pais);
			pst.setString(6, email);
			pst.setString(7, senha);
			pst.setString(8, linkedin);

			pst.executeUpdate();
			System.out.println("Dados atualizados com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Metodo para deletar uma empresa do banco de dados
	 * @author Maicon Souza
	 * @since
	 * @param username
	 * @param cnpj
	 */
	public void deletarUsuario(String username, String cnpj) {
		
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