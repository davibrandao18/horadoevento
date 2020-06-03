package command;

import model.Usuario;
import service.InscricaoService;
import service.UsuarioService;

public class CancelarInscricao {
    UsuarioService us = new UsuarioService();
    InscricaoService is = new InscricaoService();
    String cpf = request.getParameter("cpf");

    try {
        Usuario user = us.carregar(request.getParameter("username"));
        
        if (request.getParameter("senha").equals(user.getSenha()) && cpf.equals(user.getCpf())) {
            is.excluir(cpf);
            us.excluirTags(user);
            us.excluir(user.getUserName(), cpf);
            response.sendRedirect("/horadoevento/inicio/");
        }
        else request.getRequestDispatcher("erro/credenciais/").forward(request, response);;
        
    } catch (Exception e) {
        response.sendRedirect("/horadoevento/erro/not_found/");
    }
}
