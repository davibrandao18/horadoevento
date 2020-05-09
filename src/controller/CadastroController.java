package controller;

//import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Empresa;
import model.Usuario;
import service.EmpresaService;
import service.UsuarioService;

/**
 * Servlet implementation class Cadastro
 */
@WebServlet("/cadastro/Cadastro.do")
public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		switch (request.getParameter("entidade")) {
			case "usuario": {
				UsuarioService us = new UsuarioService();
				Usuario usuario = new Usuario();
				usuario.setNome(request.getParameter("nome"));
				usuario.setCpf(request.getParameter("cpf"));
				usuario.setUserName(request.getParameter("username"));
				usuario.setEmail(request.getParameter("email"));
				usuario.setSenha(request.getParameter("senha"));
				usuario.setLinkedin(request.getParameter("linkedin"));
				//TODO foto
				//File foto = new File("/horadoevento/assets/logo/default250.png"); /!\ N�O FUNCIONA SOCORRO
				//usuario.setFoto(foto);
				
				
				
				if (us.criar(usuario) == false) {
					request.setAttribute("novo_login", false);
					request.getRequestDispatcher("usuario/index.jsp").forward(request, response);
				} else {
					response.sendRedirect("/horadoevento/login/login.jsp");
				}
				//TODO us.criarFoto();
				break;
			}
			case "empresa": {
				EmpresaService es = new EmpresaService();
				Empresa empresa = new Empresa();
				empresa.setCnpj(request.getParameter("cnpj"));
				empresa.setUserName(request.getParameter("username"));
				empresa.setNome(request.getParameter("nome"));
				empresa.setCidade(request.getParameter("cidade"));
				empresa.setEstado(request.getParameter("estado"));
				empresa.setPais(request.getParameter("pais"));
				empresa.setSenha(request.getParameter("senha"));
				empresa.setEmail(request.getParameter("email"));
				empresa.setLinkedin(request.getParameter("linkedin"));
				//TODO foto
				
				if (es.criar(empresa) == false) {
					request.setAttribute("novo_login", false);
					request.getRequestDispatcher("empresa/index.jsp").forward(request, response);
				} else {
					response.sendRedirect("/horadoevento/login/login.jsp");
				}
				//TODO es.criarFoto();
				break;
			}
		}
	}
}
