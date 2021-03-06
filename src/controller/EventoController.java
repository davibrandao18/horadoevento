package controller;

import java.io.IOException;
import java.sql.SQLException;
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
import service.EmpresaService;
import service.EventoService;
import service.TagService;

/**
 * Servlet implementation class EventoController
 */
@WebServlet("/Evento.do")
public class EventoController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Evento evento = new Evento();
        EventoService evs = new EventoService();
        EmpresaService es = null;
        Empresa empresa = null;
        ArrayList<Tag> tags = null;
        Date date = null;
        
        String acao = request.getParameter("acao");
        System.out.println("Acao: "+acao);
        
        switch (acao) {
        case "criar":
            empresa = es.carregar(request.getParameter("empresa"));
            date = converteData(request.getParameter("data-hora"));
            
            evento.setTitulo(request.getParameter("titulo"));
            evento.setDescricao(request.getParameter("descricao"));
            evento.setDataHora(date);
            evento.setLocalizacao(request.getParameter("localizacao"));
            evento.setDuracao(Integer.parseInt(request.getParameter("duracao")));
            evento.setQuantidadeVagas(Integer.parseInt(request.getParameter("qtd-vagas")));
            evento.setPalestrante(request.getParameter("palestrante"));
            evento.setEmpresa(empresa);
            evento.setId(evs.criar(evento));
            
            tags = handleTags(evento, request.getParameterValues("checkbox"));
            
            if (evento.getId() == -1) {
                // tela evento com os dados errados para correcao
                request.getRequestDispatcher("/horadoevento/perfil/empresa/").forward(request, response);
            } else {
                // tela cadastrado com sucesso !
                evs.inserirTag(tags, evento);
                session = request.getSession();
                int id = evento.getId();
                session.setAttribute("id", id);
                session.setAttribute("acao", "visualizar");
                request.getRequestDispatcher("../Evento.do").forward(request, response);
            }
            break;
        
        case "visualizar":
            evento = evs.carregar(Integer.parseInt(request.getParameter("id")));

            if (evento == null) {
                request.getRequestDispatcher("../perfil/empresa/").forward(request, response);
            } else {
                TagService ts = new TagService();
                evento.setColecaoTags(ts.carregarTagEvento(evento));
                
                request.setAttribute("evento", evento);
                request.getRequestDispatcher("/view/evento/").forward(request, response);
            }
            break;

        case "excluir":
            String mensagem = "evento " + evento.getTitulo() + " removido com sucesso";
            evs.excluir(Integer.parseInt(request.getParameter("id")));

            session.setAttribute("sessao_mensagem", mensagem);
            response.sendRedirect("/horadoevento/dashboard-empresa/");
            break;
       case "Pre-editar": 
           evento = evs.carregar(Integer.parseInt(request.getParameter("id")));
           TagService ts = new TagService();
           evento.setColecaoTags(ts.carregarTagEvento(evento));
           
           request.setAttribute("evento", evento);
           request.getRequestDispatcher("/evento/edita/").forward(request, response);
           break;
       

        case "editar":
            es = new EmpresaService();
            date = converteData(request.getParameter("data-hora"));
            empresa = es.carregar(request.getParameter("empresa"));
            evento.setId(Integer.parseInt(request.getParameter("id")));
            evento.setTitulo(request.getParameter("titulo"));
            evento.setDescricao(request.getParameter("descricao"));
            evento.setDataHora(date);
            evento.setLocalizacao(request.getParameter("localizacao"));
            System.out.println("Servlet : "+request.getParameter("duracao"));
            evento.setDuracao(Integer.parseInt(request.getParameter("duracao")));
            evento.setQuantidadeVagas(Integer.parseInt(request.getParameter("qtd-vagas")));
            evento.setPalestrante(request.getParameter("palestrante"));
            evento.setEmpresa(empresa);

            tags = handleTags(evento, request.getParameterValues("checkbox"));

            if (evento.getId() == -1) {
                request.getRequestDispatcher("/horadoevento/dashboard-empresa/").forward(request, response);

            } else {
                evs.inserirTag(tags, evento);
                try {
                    evs.atualizar(evento);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                session.setAttribute("id", evento.getId());
                request.getRequestDispatcher("/evento/edita/").forward(request, response);
            }
            break;
        }
    }

    public Date converteData(String data) {
        Date date = null;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");

        try {
            date = (Date) formatter.parse(data);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return date;
    }

    public ArrayList<Tag> handleTags(Evento evento, String[] checkbox) {
        String[] checkedIds = checkbox;
        TagService ts = new TagService();
        ArrayList<Tag> tags = new ArrayList<Tag>();

        for (int i = 0; i < checkedIds.length; i++)
            tags.add(ts.carregar(Integer.parseInt(checkedIds[i])));

        evento.setColecaoTags(tags);

        return tags;
    }

}
