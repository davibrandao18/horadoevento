package controller;

import java.io.File;
//import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Empresa;
import model.Evento;
import model.Tag;
import model.Usuario;
import service.EmpresaService;
import service.EventoService;
import service.TagService;
import service.UsuarioService;

/**
 * Servlet implementation class Cadastro
 */
@WebServlet("/cadastro/Cadastro.do")
public class CadastroController extends HttpServlet {
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
		switch (request.getParameter("entidade")) {
			case "usuario": {
				UsuarioService us = new UsuarioService();
				Usuario usuario = new Usuario();
				usuario.setNome(request.getParameter("nome"));
				usuario.setCpf(request.getParameter("cpf"));
				usuario.setUserName(request.getParameter("username"));
				usuario.setEmail(request.getParameter("email"));
				usuario.setSenha(request.getParameter("senha"));
				usuario.setLinkedin(request.getParameter("linkedin"));
				String appPath = request.getServletContext().getRealPath("");
				String foto = appPath+File.separator+"assets/logo/default250.png";
				File fotoF = new File(foto);
				usuario.setFoto(fotoF);
				
				System.out.println(fotoF.exists());
				
				if (us.criar(usuario) == false) {
					request.setAttribute("novo_login", false);
					request.getRequestDispatcher("/horadoevento/cadastro/").forward(request, response);
				} else {
					response.sendRedirect("/horadoevento/login/");
				}
				//TODO us.criarFoto();
				break;
			}
			case "empresa": {
				EmpresaService es = new EmpresaService();
				Empresa empresa = new Empresa();
				empresa.setCnpj(request.getParameter("cnpj"));
				empresa.setUserName(request.getParameter("username"));
				empresa.setNome(request.getParameter("nome"));
				empresa.setCidade(request.getParameter("cidade"));
				empresa.setEstado(request.getParameter("estado"));
				empresa.setPais(request.getParameter("pais"));
				empresa.setSenha(request.getParameter("senha"));
				empresa.setEmail(request.getParameter("email"));
				empresa.setLinkedin(request.getParameter("linkedin"));
				
				if (es.criar(empresa) == false) {
					request.setAttribute("novo_login", false);
					request.getRequestDispatcher("/cadastro/").forward(request, response);
				} else {
					response.sendRedirect("/horadoevento/login/");
				}
				break;
			}
		}
	}
	
	public Date converteData(String data) {
        Date date = null;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        
        try {
            date = (Date)formatter.parse(data);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        return date;
    }
	
	public ArrayList<Tag> handleTags(Evento evento, String[] checkbox) {
        String[] checkedIds = checkbox;
        TagService ts = new TagService();
        ArrayList<Tag> tags = new ArrayList<Tag>();
        
        for(int i = 0 ; i < checkedIds.length ; i++)
            tags.add(ts.carregar(Integer.parseInt(checkedIds[i])));
        
        evento.setColecaoTags(tags);
        
        return tags;
    }
}
