package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Empresa;
import model.Usuario;
import service.EmpresaService;
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
		EmpresaService es = new EmpresaService();
		Usuario user = new Usuario();
		Empresa empresa = new Empresa();
		HttpSession sessao = request.getSession();
		
		switch (request.getParameter("entidade")) {
			case "usuario": {
				try {
					user = us.carregar(request.getParameter("username"));
				} catch (Exception e){
					response.sendRedirect("./login.jsp");
				}
				
				if (request.getParameter("senha").equals(user.getSenha())) {
					sessao.setAttribute("tipo_entidade", "usuario");
					sessao.setAttribute("sessao_user", user);
					response.sendRedirect("/horadoevento/home/member/");
				} else {
					response.sendRedirect("./login.jsp");
				}
				break;
			}
			case "empresa": {
				try {
					empresa = es.carregar(request.getParameter("username"));
				} catch (Exception e){
					response.sendRedirect("./login.jsp");
				}
				
				if (request.getParameter("senha").equals(empresa.getSenha())) {
					sessao.setAttribute("tipo_entidade", "empresa");
					sessao.setAttribute("sessao_user", empresa);
					response.sendRedirect("/horadoevento/dashboard-empresa/");
				} else {
					response.sendRedirect("./login.jsp");
				}
				break;
			}
		}
		
		System.out.println("Servidor: Fim login");
		
		
	}

}
