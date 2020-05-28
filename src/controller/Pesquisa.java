package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EmpresaService;
import service.EventoService;
import service.UsuarioService;

/**
 * Processa listas de usuarios, empresas e eventos semelhantes ao digitados na pesquisa
 */
@WebServlet("/pesquisa/Pesquisa.do")
public class Pesquisa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsuarioService us = new UsuarioService();
		EmpresaService es = new EmpresaService();
		EventoService evs = new EventoService();
		
		String username = request.getParameter("username");
		
		session.setAttribute("listaUsuario", us.listar(username));
		session.setAttribute("listaEmpresa", es.listar(username));
		session.setAttribute("listaEvento", evs.listar(username));
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
