<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="modal fade" id="modalInscricao" tabindex="-1" role="dialog" aria-labelledby="inscricaoLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="inscricaoLabel">Inscricao</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/horadoevento/controller.do" method="post">
                <input type="hidden" name="idEvento" value="${evento.id}">
                <div class="modal-body">
                    <p class="text-dark">Voce tem certeza que deseja inscrever-se em: ${evento.titulo}</p>
                    <input type="text" placeholder="cpf" name="cpf" required>
                    <input type="password" class="password-field" placeholder="senha" name="senha" required>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Nao</button>
                    <button type="submit" class="btn btn-primary" name="command" value="CriarInscricao">Sim</button>
                </div>
            </form>
        </div>
    </div>
</div>
