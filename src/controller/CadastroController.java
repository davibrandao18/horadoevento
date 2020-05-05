package controller;

//import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;

/**
 * Servlet implementation class Cadastro
 */
@WebServlet("/cadastro/Cadastro.do")
public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		UsuarioService us = new UsuarioService();
		
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String linkedin = request.getParameter("linkedin");
		//File foto = new File("/horadoevento/assets/logo/default250.png"); /!\ NÃO FUNCIONA SOCORRO
		
		System.out.println(nome + cpf + username + email + senha + linkedin);
		
		usuario.setNome(nome);
		usuario.setCpf(cpf);
		usuario.setUserName(username);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setLinkedin(linkedin);
		//usuario.setFoto(foto);
		
		System.out.println("GET USUARIO:" + usuario.getNome());
		
		us.criar(usuario);
		//us.criarImagem(usuario.getFoto(), usuario.getUserName());
		
		
		System.out.println("CRIADO");
		
		
	}
}
