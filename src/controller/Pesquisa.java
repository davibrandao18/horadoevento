package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Evento;
import service.EmpresaService;
import service.EventoService;
import service.TagService;
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
		String criterio = request.getParameter("criterio") != null ? request.getParameter("criterio") : "default";
		
		switch (criterio) {
        case "default":
            session.setAttribute("listaUsuario", us.listar(username));
            session.setAttribute("listaEmpresa", es.listar(username));
            session.setAttribute("listaEvento", evs.listar(username));
            request.getRequestDispatcher("index.jsp").forward(request, response);
            break;
        case "tag": {
            TagService ts = new TagService();
            int idTag = Integer.parseInt(request.getParameter("idTag"));
            ArrayList<Evento> listaEvento = new ArrayList<Evento>();
            listaEvento = ts.carregarEventoPorTag(idTag);
            session.setAttribute("listaUsuario", null);
            session.setAttribute("listaEmpresa", null);
            session.setAttribute("listaEvento", listaEvento);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            break;
        }
        default:
            throw new IllegalArgumentException("Criterio indefinido: " + criterio);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
