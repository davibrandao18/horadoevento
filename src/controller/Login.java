package controller;

import java.io.File;
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
 * Servlet implementation class Login
 */
@WebServlet("/login/Login.do")
public class Login extends HttpServlet {
	
	private static final String SAVE_DIR = "uploadFiles";
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		HttpSession sessao = request.getSession();
		
		
		String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;
        
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        
		
		switch (request.getParameter("entidade")) {
			case "usuario": {
				UsuarioService us = new UsuarioService();
				Usuario user = new Usuario();
				
				try {
					user = us.carregar(request.getParameter("username"), savePath);
					if(user.getFoto().exists()) System.out.println(user.getFoto().getAbsolutePath());
				} catch (Exception e) {
					response.sendRedirect("./login.jsp");
				}
				
				if (request.getParameter("senha").equals(user.getSenha())) {
					sessao.setAttribute("tipo_entidade", "usuario");
					sessao.setAttribute("sessao_user", user);
					response.sendRedirect("/horadoevento/home/member/index.jsp");
				} else {
					response.sendRedirect("./login.jsp");
				}
				break;
			}
			case "empresa": {
				EmpresaService es = new EmpresaService();
				Empresa empresa = new Empresa();
				
				try {
					empresa = es.carregar(request.getParameter("username"));
				} catch (Exception e){
					response.sendRedirect("./login.jsp");
				}
				
				if (request.getParameter("senha").equals(empresa.getSenha())) {
					sessao.setAttribute("tipo_entidade", "empresa");
					sessao.setAttribute("sessao_user", empresa);
					response.sendRedirect("/horadoevento/dashboard-empresa/");
				} else {
					response.sendRedirect("./login.jsp");
				}
				break;
			}
		}
	}
}