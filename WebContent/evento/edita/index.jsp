<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Editar evento ${evento.id}</title>
		<c:import url="../../components/links.html"/>
		
	</head>
<body>
	<c:import url="../../components/navbar/full.jsp"/>
	
	<div class="bodyCover">
		<div class="row pt-4">
			<div class="col-md-6 justify-content-center" style="text-align:end;">
				<form action="../Atualizar.do" method="post">
				
					<label for="titulo">Titulo:</label>
					<input name="titulo" value="${evento.titulo}" type="text"> <br>
					
					<label for="data-hora">Data e Hora</label>
			    	<input type="datetime-local" value="${evnto.dataHora}" class="form-control bginput-hde" name="data-hora" id="data-hora" required maxlength="100">
					
					<label for="localizacao">Localiza��o:</label>
					<input name="localizacao" value="${evento.localizacao}" type="text"> <br>
					
					<label for="descricao">Descri��o:</label>
				    <textarea name="descricao">${evento.descricao}</textarea> <br>
				    
				    <label for="duracao">Dura��o em minutos:</label>
				    <input name="duracao" value="${evento.duracao}" type="number"> <br>
				    
				    <label for="qtd-vaga">Quantidade de vagas:</label>
				    <input name="qtd-vaga" value="${evento.quantidadeVagas}" type="number"> <br>
				    
				    <label for="palestrante">Palestrante:</label>
					<input name="palestrante" value="${evento.palestrante}" type="text"> <br>
					
					<h5>Tags relacionadas</h5>
					
					<c:if test="${not empty lista}">
			            <div id="list" class="row">
							<div class="table-responsive col-md-12">
			                	<table class="table table-striped">
			                        <tbody>
				        				<c:forEach var="tag" items="${lista}">
				                            <tr>
				                            	<td>${tag.nome}</td>
				                            </tr>
				                        </c:forEach>
			                        </tbody>
			                    </table>
		                  	</div>
		              	</div>
					</c:if>
					
				</form>
			</div>
		</div>
	</div>
	
	<c:import url="../../../components/footer/"/>
	
	<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
	
</body>

</html>