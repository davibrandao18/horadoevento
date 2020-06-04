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
	 * Metodo para consultar empresas com a foto
	 * @author Maicon Souza
	 * @since 0.1
	 * @param String usern -> username
	 */
	public Empresa consultarEmpresa(String username, String path) {
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
				File foto = recuperarImagem(username, path);
				
				empresa.setCnpj(cnpj);
				empresa.setUserName(username);
				empresa.setNome(nome);
				empresa.setCidade(cidade);
				empresa.setEstado(estado);
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
	 * Metodo para consultar empresas sem o paramentro para foto
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
				
				empresa.setCnpj(cnpj);
				empresa.setUserName(username);
				empresa.setNome(nome);
				empresa.setCidade(cidade);
				empresa.setEstado(estado);
				empresa.setPais(pais);
				empresa.setSenha(senha);
				empresa.setEmail(email);
				empresa.setLinkedin(linkedin);
				
				
				return empresa;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
     * Metodo para consultar empresas sem o paramentro para foto
     * @author Davi Fonseca
     * @since 0.1
     * @param String cpf -> cpf
     */
    public Empresa consultarEmpresaCnpj(String cnpj) {
        String sqlSelect = "SELECT * FROM empresa WHERE cnpj=?";
        
        try (Connection conectar = ConnectionFactory.obtemConexao();
                PreparedStatement pst = conectar.prepareStatement(sqlSelect);) {
            pst.setString(1, cnpj);
            
            ResultSet resultado = pst.executeQuery();
            
            if (resultado.next()){
                Empresa empresa = new Empresa();
                String username = resultado.getString("username");
                String nome = resultado.getString("nome");
                String cidade = resultado.getString("cidade");
                String estado = resultado.getString("estado");
                String pais = resultado.getString("pais");
                String senha = resultado.getString("senha");
                String email = resultado.getString("email");
                String linkedin = resultado.getString("linkedin");
                
                empresa.setCnpj(cnpj);
                empresa.setUserName(username);
                empresa.setNome(nome);
                empresa.setCidade(cidade);
                empresa.setEstado(estado);
                empresa.setPais(pais);
                empresa.setSenha(senha);
                empresa.setEmail(email);
                empresa.setLinkedin(linkedin);
                
                
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
	 * Metodo para alteracao de imagem:
	 * @author Davi Fonseca
	 * @since 0.1
	 * @param File foto
	 * @param String username
	 */
	public void inserirImagem(File foto, String username) {
			
		//Preparando a String para insercao:
		String sqlUpdate = "UPDATE empresa SET foto = ?"
				+ "WHERE username='"+username+"'";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlUpdate)) {
			
			//criando fluxo de manipulacao de arquivo
			FileInputStream inputStream = new FileInputStream(foto);
			
			pst.setBinaryStream(1,				//Posicao do Sql
					(InputStream) inputStream,	//Fluxo de informacao
					(int) (foto.length())		//Quantidade de bytes
					);
			
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
	public File recuperarImagem(String username, String path) {
		String selectImg = "SELECT foto FROM empresa WHERE username = ?";
		
		try {
			Connection conectar = ConnectionFactory.obtemConexao();
			PreparedStatement pst = conectar.prepareStatement(selectImg);
			
			pst.setString(1, username);
			
			ResultSet resultado = pst.executeQuery();
			// Arquivo onde a imagem sera armazenada no disco:
			File file = new File(path + File.separator + username +".jpg");
			// Objeto para tratar saida de dados para um arquivo:
			FileOutputStream output = new FileOutputStream(file);
			
			// Verificando se encontrou registro para o select:
			if (resultado.next()) {
				// Pegando o campo do tipo blob, chamado "foto":
				InputStream input = resultado.getBinaryStream("foto");
				// Preparando um vetor de bytes para enviar para o arquivo:
		        byte[] buffer = new byte[1024];
		        // Enquanto existir conteudo no fluxo de dados, continua:
		        while (input.read(buffer) > 0) {
		        	// Escreve o conteudo no arquivo de destino no disco:
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
	
	/**
	 * Retornar lista de empresa_usuario
	 * @param cnpj
	 * @param path
	 * @return
	 */
	public ArrayList<Empresa> empresaUsuario(String cnpj, String path){
		ArrayList<Empresa> empresas = null;
		String select = "SELECT empresa.nome, empresa.username, empresa.linkedin FROM tag , tag_evento WHERE tag.id = tag_evento.fk_tag_id and fk_evento_id = ?";
		try(Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(select);){
			
		pst.setString(1, cnpj);
		
		ResultSet resultado = pst.executeQuery();
		
		empresas = new ArrayList<Empresa>();
		
		while (resultado.next()) {
			File foto = recuperarImagem(cnpj, path);
			//cnpj,username,nome,linkedin, foto.
			Empresa emp = new Empresa(resultado.getString("cnpj"), resultado.getString("username"),resultado.getString("nome"), resultado.getString("linkedin"), foto);
			System.out.println("Regitro inserido na lista");
			empresas.add(emp);
		}
		
		} catch(SQLException e) {
		e.printStackTrace();
		}
		
		return empresas;
	}
}