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
import model.Usuario;
import service.TagUsuarioService;
import model.Certificado;
import model.EmpresaUsuario;
import model.TagUsuario;

/**
 * Data Acess Object para o Usuario
 * 
 * @author Davi Fonseca
 * @version 0.1
 * @since 0.1
 */
public class UsuarioDao {
	
	/**
	 * Metodo de insercao de usuario no Banco de dados
	 * @since 0.1
	 * @param Usuario usuario
	 */
	public void inserirUsuario(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuario"
				+"(cpf,username,nome,email,senha,linkedin)"
				+"VALUES (?,?,?,?,?,?)";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setString(1,usuario.getCpf());
			pst.setString(2,usuario.getUserName());
			pst.setString(3,usuario.getNome());
			pst.setString(4,usuario.getEmail());
			pst.setString(5,usuario.getSenha());
			pst.setString(6,usuario.getLinkedin());
			
			usuario.getColecaoTags();
			ArrayList<TagUsuario> colecaoTags = usuario.getColecaoTags();
			TagUsuarioService tus = new TagUsuarioService();
			colecaoTags.forEach( i -> {
				tus.criarTagUsuario(i);
			});
			
			usuario.getColecaoCertificados();
			ArrayList<Certificado> colecaoCertificados = usuario.getColecaoCertificados();
			CertificadoDao certificadoDao = new CertificadoDao();
			colecaoCertificados.forEach( i -> {
				certificadoDao.criarCertificado(i);;
			});
			
			usuario.getColecaoEmpresas();
			ArrayList<EmpresaUsuario> colecaoEmpresas = usuario.getColecaoEmpresas();
			EmpresaUsuarioDao empresaUserDao = new EmpresaUsuarioDao();
			colecaoEmpresas.forEach( i -> {
				empresaUserDao.inserirEmpresaUsuario(i);
			});
			
			pst.execute();
			System.out.println("Usuario inseridos com sucesso");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	
	/**
	 * Metodo para consultar usuarios:
	 * @author Davi Fonseca
	 * @since 0.2
	 * @param String usercpf -> cpf
	 */
	public Usuario consultarUsuario(String usercpf) {
		String sqlConsu = "SELECT * FROM usuario"
				+"WHERE username = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlConsu);) {
			pst.setString(1,usercpf);
			
			//quando precisa de retorno do banco "ResultSet"//
			ResultSet resultado = pst.executeQuery();
			
			Usuario usuario = null;
			//+"(cpf,username,nome,email,senha,linkedin,foto)"
			if (resultado.next()){
				usuario = new Usuario();
				String cpf = resultado.getString("cpf");
				String username = resultado.getString("username");
				String nome = resultado.getString("nome");
				String email = resultado.getString("email");
				String senha = resultado.getString("senha");
				String linkedin = resultado.getString("linkedin");
				File foto = recuperarImagem(usercpf);
				
				usuario.setCpf(cpf);
				usuario.setUserName(username);
				usuario.setNome(nome);
				usuario.setEmail(email);
				usuario.setSenha(senha);
				usuario.setLinkedin(linkedin);
				usuario.setFoto(foto); 
				
				return usuario;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Metodo de listagem de usuarios semelhantes utilizando o username
	 * @author Maicon Souza e Davi Fonseca
	 * @since
	 * @param String username
	 * @return arraylist de usuarios
	 */
	public ArrayList<Usuario> listarUsuarios(String username) {
		String sqlSelect = "SELECT * FROM usuario WHERE username LIKE '%" +username +"%'";

		ArrayList<Usuario> listaUsuario = new ArrayList<>();
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlSelect);) {
			
			ResultSet resultado = pst.executeQuery();
			
			while(resultado.next())
				listaUsuario.add(consultarUsuario(resultado.getString("cpf")));

			return listaUsuario;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * Metodo para alteracao de imagem:
	 * @author Davi Fonseca
	 * @since 0.1
	 * @param File foto
	 * @param String username
	 */
	public void inserirImagem(File foto, String username) {
			
		//Preparando a String para insercao:
		String sqlUpdate = "UPDATE usuario SET foto = ?"
				+ "WHERE username = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlUpdate)) {
			
			//criando fluxo de manipulacao de arquivo
			FileInputStream inputStream = new FileInputStream(foto);
			
			pst.setBinaryStream(1,				//Posicao do Sql
					(InputStream) inputStream,	//Fluxo de informacao
					(int) (foto.length())		//Quantidade de bytes
					);
			pst.setString(2, username);
			
			//Enviando um comando para o MySQL
			pst.execute();
			
		} catch (Exception e) {
			//Imprimido a pilha de erros:
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Metodo para recuperar imagem do banco de dados de acordo com o apelido.
	 * @author Davi Fonseca
	 * @since 0.1
	 * @param String username
	 */
	public File recuperarImagem(String username) {
		
		
        // Criando o SQL de consulta:
		String selectImg = "SELECT foto FROM usuario WHERE username = ?";
		
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
	 * Metodo para atualizar usuario no bd
	 * @author Davi Fonseca
	 * @since 0.1
	 * @param cpf
	 * @param username
	 * @param nome
	 * @param email
	 * @param senha
	 * @param linkedin
	 * @throws SQLException
	 */
	public void atualizarUsuario(Usuario user) {
		
		/**
		 * Criando a String de atualizacao
		 */
		String atualizar = "UPDATE usuario SET cpf = ?, username = ?, nome = ?, email = ?, senha = ?, linkedin = ? WHERE username = '"+user.getUserName()+"'";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(atualizar)) {
			
			pst.setString(1, user.getCpf());
			pst.setString(2, user.getUserName());
			pst.setString(3, user.getNome());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getSenha());
			pst.setString(6, user.getLinkedin());
			
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Metodo para deletar usuario no bd
	 * @author Davi Fonseca
	 * @since 0.1
	 * @param username
	 * @param cpf
	 */
	public void deletarUsuario(String username, String cpf) {
		
		//Preparando a String para atualizacao:
		String deletar = "DELETE FROM usuario WHERE username = ? && cpf = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(deletar)) {

			pst.setString(1, username);
			pst.setString(1, cpf);
			
			//Enviando um comando para o MySQL
			pst.execute();
			System.out.println("Dados excluidos com sucesso");
			
		} catch (Exception e) {
			//Imprimido a pilha de erros:
			e.printStackTrace();
		}
	}
}