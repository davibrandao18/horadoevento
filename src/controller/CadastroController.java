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
				//TODO es.criarFoto();
				break;
			}
			case "evento": {
				EmpresaService es = new EmpresaService();
				EventoService evs = new EventoService();
				Evento evento = new Evento();
				
				evento.setTitulo(request.getParameter("titulo"));
				evento.setDescricao(request.getParameter("descricao"));
				
				// Comecei a tratar a #data
				String pDt = request.getParameter("data-hora");
				Date date = null;
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
				try {
				date = (Date)formatter.parse(pDt);
				
				} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
				// ./data
				evento.setDataHora(date);
				
				evento.setLocalizacao(request.getParameter("localizacao"));
				evento.setDuracao(Integer.parseInt(request.getParameter("duracao")));
				evento.setQuantidadeVagas(Integer.parseInt(request.getParameter("qtd-vagas")));
				evento.setPalestrante(request.getParameter("palestrante"));
				
				// TODO arraylist
				String[] checkedIds = request.getParameterValues("checkbox");
				TagService ts = new TagService();
				ArrayList<Tag> tags = new ArrayList<Tag>();
				for(int i = 0 ; i < checkedIds.length ; i++) {
					tags.add(ts.carregar(Integer.parseInt(checkedIds[i])));
				}
				evento.setColecaoTags(tags);
				
				Empresa empresa = es.carregar(request.getParameter("empresa"));
				evento.setEmpresa(empresa);
				
				evento.setId(evs.criar(evento));
				
				if (evento.getId() == -1) {
					// tela evento com os dados errados para correcao
					request.getRequestDispatcher("/horadoevento/perfil/empresa/").forward(request, response);
				} else {
					// tela cadastrado com sucesso !
					evs.inserirTag(tags, evento);
					request.setAttribute("eventoId", evento.getId());
					request.setAttribute("acao", "visualizar");
					request.getRequestDispatcher("../Evento.do").forward(request, response);
				}
				
				break;
			}
		}
	}
}
