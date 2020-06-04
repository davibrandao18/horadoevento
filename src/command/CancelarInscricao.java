package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.InscricaoService;

public class CancelarInscricao {
    public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        InscricaoService is = new InscricaoService();
        
        try {
            is.excluir(request.getParameter("id_i"));
            String mensagem = "Inscrição cancelada";
            
            request.getSession().setAttribute("sessao_mensagem", mensagem);
            response.sendRedirect("/horadoevento/home/member/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
