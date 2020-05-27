package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inscricao
 */
@WebServlet("/Inscricao.do")
public class Inscricao extends HttpServlet {
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
		String cpf = request.getParameter("cpf");
		String idEvento = request.getParameter("idEvento");
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "criar":
			
			break;
		case "deletar":
			
			break;
		case "visualizar":
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + acao);
		}
	}

}
