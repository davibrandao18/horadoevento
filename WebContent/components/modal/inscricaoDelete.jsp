<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="modal fade" id="deletemodal" tabindex="-1" role="dialog" aria-labelledby="eventoLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="eventoLabel">Inscrição</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/horadoevento/Controller.do" method="post">
                <input type="hidden" name="command" value="CancelarInscricao">
                <input type="hidden" name="id_i">
                <div class="modal-body"> <%//TODO continuar modal de deletar, fazer testes %>
                    Você tem certeza que deseja cancelar essa inscrição?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
                    <button type="submit" class="btn btn-primary" name="acao" value="excluir">Sim</button>
                </div>
            </form>
        </div>
    </div>
</div>