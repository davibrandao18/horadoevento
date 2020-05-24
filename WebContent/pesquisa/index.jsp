<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Pesquisa</title>
        <c:import url="../components/links.html"/>
        <link rel="stylesheet" href="./pesquisa.css">
    </head>
    
    <body>
    	<c:import url="../components/navbar/full.jsp"/>

		<div class="bodyCover">
		
			<h4>Usuários:</h4>
			<c:if test="${not empty listaUsuario}">
				<c:forEach var="usuario" items="${listaUsuario}">
					<button>
						<p>${usuario.nome}</p>
						<p style="color: blue;">${usuario.username}</p>
					</button>
				</c:forEach>
			</c:if>
			<c:if test="${empty listaUsuario}">
				<p>Nenhum usuário encontrado</p>
			</c:if>

			<h4>Empresas:</h4>
			<c:if test="${not empty listaEmpresa}">		
				<c:forEach var="empresa" items="${listaEmpresa}">
					<button>
						<p>${empresa.nome};</p>
						<p style="color: blue;">${empresa.userName}</p>
					</button>
				</c:forEach>
			</c:if>
			<c:if test="${empty listaEmpresa}">
				<p>Nenhuma empresa encontrada</p>
			</c:if>
			
			<h4>Eventos:</h4>
			<c:if test="${not empty listaEvento}">
				<c:forEach var="evento" items="${listaEvento}">
					<button>
						<p>${evento.titulo};</p>
						<p style="color: blue;">${evento.empresa.nome}</p>
					</button>
				</c:forEach>
			</c:if>
			<c:if test="${empty listaEvento}">
				<p>Nenhum evento encontrado</p>
			</c:if>
		</div>
		
    	<c:import url="../components/footer/" />
		
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>