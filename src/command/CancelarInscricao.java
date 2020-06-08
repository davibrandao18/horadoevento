package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Inscricao;
import model.Usuario;

import service.InscricaoService;

public class CancelarInscricao implements Command {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InscricaoService is = new InscricaoService();

        HttpSession sessao = request.getSession();
        Usuario user = (Usuario) sessao.getAttribute("sessao_user");

        String StringId = request.getParameter("id");
        int id = -1;

        try {
            id = Integer.parseInt(StringId);
        } catch (Exception e) {
            response.sendRedirect("/horadoevento/erro/not_found/");
        }

        if (id > 0)
            is.excluir(id);
        sessao.removeAttribute("inscricoes");

        ArrayList<Inscricao> inscricoes = new ArrayList<Inscricao>();
        inscricoes = is.listar(user);

        sessao.setAttribute("inscricoes", inscricoes);

        String mensagem = "Inscri��o cancelada";

        request.getSession().setAttribute("sessao_mensagem", mensagem);
        response.sendRedirect("/horadoevento/view/inscricao/");
    }
}
