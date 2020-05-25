package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Evento;
import service.EventoService;

/**
 * Servlet implementation class EventoController
 */
@WebServlet("/Evento.do")
public class EventoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventoController() {
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
		
		request.setCharacterEncoding("UTF-8");
		
		String acao = request.getParameter("acao");
		int id = Integer.parseInt(request.getParameter("eventoId"));
		
		Evento evento = null;
		EventoService es = null;
		
		switch(acao) {
			case "visualizar":{
				evento = new Evento();
				es = new EventoService();
				
				evento = es.carregar(id);
				if (evento == null) {
					request.getRequestDispatcher("/horadoevento/perfil/empresa/").forward(request, response);
				} else {
					request.setAttribute("evento", evento);
					request.getRequestDispatcher("/horadoevento/evento/").forward(request, response);
				}
				
			}
		}
	}

}
