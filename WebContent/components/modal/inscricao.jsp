<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="modal fade" id="modalInscricao" tabindex="-1" role="dialog" aria-labelledby="inscricaoLabel" aria-hidden="true">
  	<div class="modal-dialog" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
       			<h5 class="modal-title" id="inscricaoLabel">Inscrição</h5>
        		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          			<span aria-hidden="true">&times;</span>
       			</button>
      		</div>
      		<form action="controller.do" method="post">
      			<div class="modal-body">
			      	Você tem certeza que deseja inscrever-se em: ${evento.titulo}
			      	<input type="text" placeholder="cpf" name="cpf">
			      	<input type="text" placeholder="senha" name="senha">
      			</div>
      			<div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
			        <button type="submit" class="btn btn-primary" name="command" value="CriarInscricao">Sim</button>
      			</div>
      	    </form>
    	</div>
	</div>
</div>
    
    