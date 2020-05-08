package controller;

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
 * Servlet implementation class Atualizar
 */
@WebServlet("/perfil/Perfil.do")
public class BuscaPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscaPerfil() {
        super();
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
		String entidade = request.getParameter("entidade");
		
		switch (entidade) {
			case "usuario": {
				UsuarioService us = new UsuarioService();
				Usuario usuario = us.carregar(request.getParameter("username"));
		        request.setAttribute(entidade, usuario);
				break;
			}
			case "empresa": {
				EmpresaService es = new EmpresaService();
				Empresa empresa = es.carregar(request.getParameter("username"));
				request.setAttribute(entidade, empresa);
				break;
			}
		}
		
		request.getRequestDispatcher(entidade+"/view/").forward(request, response);
	}
}
