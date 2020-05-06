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
 * Servlet implementation class Atualizar
 */
@WebServlet("/perfil/Atualizar.do")
public class Atualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Atualizar() {
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
		HttpSession sessao = request.getSession();
		Usuario user = (Usuario) sessao.getAttribute("sessao_user");
		
		user.getCpf();
		user.getUserName();
		user.setNome(request.getParameter("nome"));
		user.setEmail(request.getParameter("email"));
		user.setSenha(request.getParameter("senha"));
		user.setLinkedin(request.getParameter("linkedin"));
		//File foto = new File("/horadoevento/assets/logo/default250.png"); /!\ NÃO FUNCIONA SOCORRO
		
		us.atualizar(user);
		
		sessao.setAttribute("sessao_user", user);
		response.sendRedirect("/horadoevento/home/member/index.jsp");
	}
}
