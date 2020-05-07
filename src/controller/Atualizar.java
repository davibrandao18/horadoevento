package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Empresa;
import model.Usuario;
import service.EmpresaService;
import service.UsuarioService;

/**
 * Servlet implementation class Atualizar
 */
@WebServlet("/perfil/Atualizar.do")
public class Atualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Atualizar() {
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
		EmpresaService es = new EmpresaService();
		UsuarioService us = new UsuarioService();
		
		HttpSession sessao = request.getSession();
		
		switch (request.getParameter("entidade")) {
			case "usuario": {
				Usuario usuario = (Usuario) sessao.getAttribute("sessao_user");
				usuario.getCpf();
				usuario.getUserName();
				usuario.setNome(request.getParameter("nome"));
				usuario.setEmail(request.getParameter("email"));
				usuario.getSenha(); //TODO alterar senha
				usuario.setLinkedin(request.getParameter("linkedin"));
				//TODO foto = new File("/horadoevento/assets/logo/default250.png"); /!\ NÃO FUNCIONA SOCORRO
				
				us.atualizar(usuario);
				
				sessao.setAttribute("sessao_user", usuario);
				response.sendRedirect("/horadoevento/home/member/");
				break;
			}
			case "empresa": {
				Empresa empresa = (Empresa) sessao.getAttribute("sessao_user");
				empresa.getCnpj();
				empresa.getUserName();
				empresa.setNome(request.getParameter("nome"));
				empresa.setCidade(request.getParameter("cidade"));
				empresa.setEstado(request.getParameter("estado"));
				empresa.setPais(request.getParameter("pais"));
				empresa.getSenha(); //TODO alterar senha
				empresa.setEmail(request.getParameter("email"));
				empresa.setLinkedin(request.getParameter("linkedin"));
				//TODO foto = new File("/horadoevento/assets/logo/default250.png"); /!\ NÃO FUNCIONA SOCORRO
				
				es.atualizar(empresa);
				
				sessao.setAttribute("sessao_user", empresa);
				response.sendRedirect("/horadoevento/dashboard-empresa/");
				break;
			}
		}
	}
}
