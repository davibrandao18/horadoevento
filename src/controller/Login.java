package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		UsuarioService us = new UsuarioService();
		Usuario user = new Usuario();
		
		try {
			user = us.carregar(request.getParameter("username"));
		} catch (Exception e){
			response.sendRedirect("./login.jsp");
		}
		
		if (request.getParameter("senha").equals(user.getSenha())) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("user", user);
			response.sendRedirect("/horadoevento/home/member/index.jsp");
		} else {
			response.sendRedirect("./login.jsp");
		}
		
		
		
	}

}
