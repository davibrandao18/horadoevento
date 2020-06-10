package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Empresa;
import model.Evento;
import model.Inscricao;
import model.Tag;
import model.Usuario;
import service.EmpresaService;
import service.EventoService;
import service.InscricaoService;
import service.TagService;
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
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
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
				} catch (Exception e) {
					response.sendRedirect("./login.jsp");
				}
				
				if (request.getParameter("senha").equals(user.getSenha())) {
				    TagService ts = new TagService();
				    InscricaoService is = new InscricaoService();
				    
					ArrayList<Tag> tags = new ArrayList<Tag>();
					tags = ts.carregarTagUsuario(user);
					
					ArrayList<Tag> listaTagsTotais = new ArrayList<Tag>();
					listaTagsTotais = ts.carregar();
					
					System.out.println("Login: " + listaTagsTotais.toString());
					
					ArrayList<Inscricao> inscricoes = new ArrayList<Inscricao>();
                    inscricoes = is.listar(user);
					
					sessao.setAttribute("tipo_entidade", "usuario");
                    sessao.setAttribute("sessao_user", user);
					sessao.setAttribute("listaTags", tags);
                    sessao.setAttribute("listaTagsTotais", listaTagsTotais);
					sessao.setAttribute("inscricoes", inscricoes);
					
					response.sendRedirect("/horadoevento/home/member/index.jsp");
				} else {
					response.sendRedirect("./login.jsp");
				}		
				
				break;
			}
			case "empresa": {
				EmpresaService es = new EmpresaService();
				EventoService evs = new EventoService();
				Empresa empresa = new Empresa();
		
				try {
					empresa = es.carregar(request.getParameter("username"), savePath);
				} catch (Exception e){
					response.sendRedirect("./login.jsp");
				}
				
				if (request.getParameter("senha").equals(empresa.getSenha())) {
                    ArrayList<Evento> tresProximosEventos = evs.carregarTresProximosEventos(empresa.getCnpj());
                    sessao.setAttribute("tresProximosEventos", tresProximosEventos);
                 
                    ArrayList<Evento> listaEventosPassados = evs.carregarEventosPassados(empresa.getCnpj());
                    sessao.setAttribute("listaEventosPassados", listaEventosPassados);

                    //ArrayList<Evento> listaEventosFuturos = evs.carregarEventosFuturos(empresa.getCnpj());
                    //sessao.setAttribute("listaEventosFuturos", listaEventosFuturos);
                    
                    ArrayList<Evento> listaEventos = evs.carregar(empresa.getCnpj());
                    sessao.setAttribute("listaEventos", listaEventos);                    
                    
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