<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Pesquisa</title>
        <c:import url="../components/links.html"/>
        <link rel="stylesheet" href="./pesquisa.css">
    </head>
    
    <body class="bodyCover">
    	<c:import url="../components/navbar/full.jsp"/>

		
    	<div>
		
			<h4>Usuários:</h4>
			<c:if test="${not empty listaUsuario}">
				<c:forEach var="usuario" items="${listaUsuario}">
					<form action="/horadoevento/perfil/Perfil.do" method="get">
						<input type="hidden" value="${usuario.userName}" name="username"/>
						<button class="card-result-user" type="submit" value="usuario" name="entidade">
						  <div class="row">
							<img src="../assets/icons/user.svg" class="col-lg-2" style="height: 50px; margin-top: 20px;"/>
								<p class="col-lg-8">${usuario.nome}</p>
								<p style="color: black;" class="col-lg-8">${usuario.userName}</p>
						  </div>
						</button>
					</form>
				</c:forEach>
			</c:if>
			<c:if test="${empty listaUsuario}">
				<p>Nenhum usuário encontrado</p>
			</c:if>

			<h4>Empresas:</h4>
			<c:if test="${not empty listaEmpresa}">		
				<c:forEach var="empresa" items="${listaEmpresa}">
					<form action="/horadoevento/perfil/Perfil.do" method="get">
						<input type="hidden" value="${empresa.userName}" name="username"/>
						<button class="card-result-empresa" type="submit" value="empresa" name="entidade">
						  <div class="row">
							<img src="../assets/icons/empresas.svg" class="col-lg-2"style="height: 50px; margin-top: 20px;"/>
								<p class="col-lg-8">${empresa.nome}</p>
								<p style="color: black;" class="col-lg-12">${empresa.userName}</p>
						  </div>
						</button>
					</form>
				</c:forEach>
			</c:if>
			<c:if test="${empty listaEmpresa}">
				<p>Nenhuma empresa encontrada</p>
			</c:if>
			
			<h4>Eventos:</h4>
			<c:if test="${not empty listaEvento}">
				<c:forEach var="evento" items="${listaEvento}">
					<form action="/horadoevento/perfil/Perfil.do" method="get">
						<input type="hidden" value="${evento.id}" name="id"/>
						<button class="card-result-evento"  type="submit" value="evento" name="entidade">
						  <div class="row">
							<img src="../assets/icons/calendario-resultados.svg" class="col-lg-2"style="height: 50px;"/> <br>
							<p class="col-lg-8">${evento.titulo}</p>
						  </div>
							<p>${evento.empresa.nome}</p>
						</button>
					</form>
				</c:forEach>
			</c:if>
			<c:if test="${empty listaEvento}">
				<p>Nenhum evento encontrado</p>
			</c:if>
		</div>
		<div style="position: absolute; bottom: 0; width: 100%;">
    	<c:import url="../components/footer/" />
		</div>
		
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>