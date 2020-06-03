package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tag;
import service.TagService;

/**
 * Servlet implementation class IniciarCadastroEvento
 */
@WebServlet("/perfil/empresa/IniciarCadastroEvento.do")
public class IniciarCadastroEvento extends HttpServlet {
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
		
		TagService ts = new TagService();
		ArrayList<Tag> tags = ts.carregar();
		
		request.setAttribute("lista", tags);
		
		request.getRequestDispatcher("../../evento/novo/index.jsp").forward(request, response);
	}

}
