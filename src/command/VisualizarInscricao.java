package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Evento;
import model.Inscricao;
import service.EventoService;

public class VisualizarInscricao implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher view = null;
		
		Inscricao i = (Inscricao) request.getAttribute("inscricao");
		String id = request.getParameter("idEvento");
		int idEvento = -1;
		
		try {
			idEvento = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			
		}
		
		if (i.getId() < 0) {
			//TODO not found
		}
		
		EventoService ev = new EventoService();
		Evento e = ev.carregar(idEvento);
		
		request.setAttribute("inscricao", i);
		request.setAttribute("Evento", e);
		view = request.getRequestDispatcher("/controller.do");
		view.forward(request, response);
		
	}

}
