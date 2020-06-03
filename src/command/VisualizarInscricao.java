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
		
		Inscricao i = (Inscricao) request.getAttribute("id");
		
		if (i.getEvento().getId() < 0) {
			//TODO not found
		}
		
		EventoService ev = new EventoService();
		Evento e = ev.carregar(i.getEvento().getId());
		
		request.setAttribute("inscricao", i);
		view = request.getRequestDispatcher("/view/iscricao/");
		view.forward(request, response);
		
	}

}
