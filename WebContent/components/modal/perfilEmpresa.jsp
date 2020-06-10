<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="modal fade" id="modalExcluirEmpresa" tabindex="-1" role="dialog" aria-labelledby="excluirEmpresaLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="excluirEmpresaLabel">Excluir perfil</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/horadoevento/Remover.do" method="post">
                <div class="modal-body">
                    <input type="hidden" name="username" value="${sessao_user.userName}">
                    Voce tem certeza que deseja apagar o seu perfil? Esta acao nao podera ser desfeita.
                    <input type="text" placeholder="cnpj" name="cnpj">
                    <input type="password" placeholder="senha" name="senha">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Nao</button>
                    <button type="submit" name="entidade" value="empresa" class="btn btn-primary">Sim</button>
                </div>
            </form>
        </div>
    </div>
</div>
