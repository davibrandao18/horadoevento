<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
		<c:import url="/components/links.html"/>
		
	</head>
<body class="bodyCover">
	<c:import url="/components/navbar/full.jsp"/>
	
	<form action="../../cadastro/Cadastro.do" method="post" id="formCadastroUsuario">
            	<input type='hidden' value='evento' name='entidade'>
            	<input type='hidden' value='${sessao_user.userName}' name='empresa'>
					
				<div class="row">
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="titulo">Titulo*</label>
	    					<input type="text" class="form-control bginput-hde" name="titulo" id="titulo" required>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="descricao">Descrição*</label>
	    					<textarea class="form-control bginput-hde" name="descricao" id="descricao" required>
	    					</textarea>
						</div>
					</div>
				</div>
					
				<div class="row">
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="data-hora">Data e Hora*</label>
			    			<input type="datetime-local" class="form-control bginput-hde" name="data-hora" id="data-hora" required maxlength="100">
						</div>
					</div>
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="localizacao">Localização*</label>
			    			<input type="text" class="form-control bginput-hde" name="localizacao" id="localizacao" required>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="duracao">Duração em minutos*</label>
	    					<input type="number" class="form-control bginput-hde" name="duracao" id="duracao" required>
	    				</div>
					</div>
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="qtd-vagas">Quantidade de Vagas</label>
    						<input type="text" class="form-control bginput-hde" name="qtd-vagas" id="qtd-vagas">
    					</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-12 col-md-4">
						<div class="form-group">
							<label for="palestrante">Palestrante*</label>
	    					<input type="text" class="form-control bginput-hde" name="palestrante" id="palestrante" required>
	    				</div>
					</div>
					<div class="col-12 col-md-4">
					<c:forEach var="tag" items="${lista}">
						<div class="form-check">
						<c:if test="${tag.checado == 1}">
							<input class="form-check-input" name="checkbox" type="checkbox" value="${tag.id}" id="defaultCheck1" checked>
						  <label class="form-check-label" for="defaultCheck1">
						    ${tag.nome}
						  </label>
						</c:if>
						<c:if test="${ tag.checado != 1}">
							<input class="form-check-input" name="checkbox" type="checkbox" value="${tag.id}" id="defaultCheck1">
						  <label class="form-check-label" for="defaultCheck1">
						    ${tag.nome}
						  </label>
						</c:if>
						</div>
					</c:forEach>
					</div>
				</div>

				<nav class="navbar">
		  			<a type="button" class="btn btn-light border-dark" href="/horadoevento/dashboard-empresa/">
						<i class="fa fa-chevron-left"></i> Voltar
					</a>
			  		<button type="submit" class="btn border-dark redButton">
						Enviar <i class="fa fa-chevron-right"></i>
					</button>
				</nav>
	        </form>
	        
	    <script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/horadoevento/cadastro/cadastro.js"></script>
	
</body>

</html>