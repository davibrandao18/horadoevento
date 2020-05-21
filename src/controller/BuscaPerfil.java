package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Empresa;
import model.Evento;
import model.Usuario;
import service.EmpresaService;
import service.EventoService;
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
				Usuario user = us.carregar(request.getParameter("username"));
		        request.setAttribute("usuario", user);
				break;
			}
			case "empresa": {
				EmpresaService es = new EmpresaService();
				Empresa empresa = es.carregar(request.getParameter("username"));
				//System.out.println("Server: empresa = "+empresa.toString());
				request.setAttribute("empresa", empresa);
				break;
			}
			case "evento": {
				EventoService eventS = new EventoService();
				Evento evento = eventS.carregar(Integer.parseInt(request.getParameter("id")));
				//System.out.println("Server: empresa = "+empresa.toString());
				request.setAttribute("evento", evento);
				break;
			}
		}
		
		request.getRequestDispatcher("/perfil/"+entidade+"/view/").forward(request, response);
	}
}
