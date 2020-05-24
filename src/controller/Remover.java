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
		String username = request.getParameter("username");
		String cpf = request.getParameter("cpf");
		String cnpj = request.getParameter("cnpj");
		String senha = request.getParameter("senha");
		
		switch (entidade) {
		case "usuario":
			UsuarioService us = new UsuarioService();
			InscricaoService is = new InscricaoService();

			try {
				Usuario user = us.carregar(request.getParameter("username"));
				
				if (senha.equals(user.getSenha()) && cpf.equals(user.getCpf())) {
					is.excluir(cpf);
					us.excluirTags(cpf);
					us.excluir(username, cpf);
					response.sendRedirect("/horadoevento/inicio/");
				}
				else request.getRequestDispatcher("erro/credenciais/").forward(request, response);;
				
			} catch (Exception e) {
				response.sendRedirect("/horadoevento/erro/not_found/");
			}
			break;
			
		case "empresa":
			EmpresaService es = new EmpresaService();
			
			try {
				Empresa e = es.carregar(request.getParameter("username"));
				
				
				if (senha.equals(e.getSenha()) && cnpj.equals(e.getCnpj())) {
					evs.excluir(cnpj);
					es.excluir(username, cnpj);
					response.sendRedirect("/horadoevento/inicio/");
				}
				else request.getRequestDispatcher("erro/credenciais/").forward(request, response);;
				
			} catch (Exception e) {
				response.sendRedirect("/horadoevento/erro/not_found/");
			}
			break;
			
		case "evento":
			try {
				Empresa e = es.carregar(request.getParameter("username"));
				
				if (senha.equals(e.getSenha()) && cnpj.equals(e.getCnpj())) {
					evs.excluir(request.getParameter("id"));
					response.sendRedirect("/horadoevento/inicio/");
				}
				else request.getRequestDispatcher("erro/credenciais/").forward(request, response);;
				
			} catch (Exception e) {
				response.sendRedirect("/horadoevento/erro/not_found/");
			}
			break;
		}
	}
}
