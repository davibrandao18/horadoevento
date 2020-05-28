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
import service.InscricaoService;
import service.UsuarioService;

/**
 * Servlet implementation class Remover
 */
@WebServlet("/Remover.do")
public class Remover extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventoService evs = new EventoService();
		String entidade = request.getParameter("entidade");
		
		switch (entidade) {
		case "usuario":
			UsuarioService us = new UsuarioService();
			InscricaoService is = new InscricaoService();
			String cpf = request.getParameter("cpf");

			try {
				Usuario user = us.carregar(request.getParameter("username"));
				
				if (request.getParameter("senha").equals(user.getSenha()) && cpf.equals(user.getCpf())) {
					is.excluir(cpf);
					us.excluirTags(cpf);
					us.excluir(user.getUserName(), cpf);
					response.sendRedirect("/horadoevento/inicio/");
				}
				else request.getRequestDispatcher("erro/credenciais/").forward(request, response);;
				
			} catch (Exception e) {
				response.sendRedirect("/horadoevento/erro/not_found/");
			}
			break;
			
		case "empresa":
			EmpresaService es = new EmpresaService();
			String cnpj = request.getParameter("cnpj");
			
			try {
				Empresa e = es.carregar(request.getParameter("username"));
				
				if (request.getParameter("senha").equals(e.getSenha()) && cnpj.equals(e.getCnpj())) {
					evs.excluir(cnpj);
					es.excluir(e.getUserName(), cnpj);
					response.sendRedirect("/horadoevento/inicio/");
				}
				else request.getRequestDispatcher("erro/credenciais/").forward(request, response);;
				
			} catch (Exception e) {
				response.sendRedirect("/horadoevento/erro/not_found/");
			}
			break;
			
		case "evento":
			try {
				Evento e = evs.carregar(Integer.parseInt(request.getParameter("id")));
				evs.excluir(e.getId());
				response.sendRedirect("/horadoevento/inicio/");
			} catch (Exception e) {
				response.sendRedirect("/horadoevento/erro/not_found/");
			}
			break;
		}
	}
}
