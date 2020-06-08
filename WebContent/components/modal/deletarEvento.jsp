<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--  Modal  -->
<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="modalLabel">Deletar evento</h4>
            </div>
            <div class="modal-body">Deseja realmente deletar este evento?</div>
            <div class="modal-footer">
                <form action="Controller.do" method="post">
                    <input type="hidden" name="id" id="id_excluir" />
                    <button type="submit" class="btn btn-primary" name="acao" value="excluir">Sim</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        N&atilde;o</button>
                </form>
            </div>
        </div>
    </div>
</div>
