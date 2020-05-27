<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
    	<title>Evento: ${evento.titulo} </title>
        <c:import url="../components/links.html"/>
        <link rel="stylesheet" href="../perfil/perfil.css">
    </head>
    
    <body>
    	<c:import url="../components/navbar/full.jsp"/>
    	
    	<div class="container">
    		<div class="row">
    			<div class="col-lg-12 col-md-8 align-self-start evento-wrapper">
    			<c:out value="${evento.id}"/>
    			<span>Título</span>
    				<h3>${evento.titulo}</h3>
    			<span>Palestrante</span>	
    				<small>${evento.palestrante}</small> <br>
    			<span>Descrição</span>	
    				<p>${evento.descricao}</p>
    				<!-- continuar exibição -->
    			</div>
    		</div>
    	<div class="row">
    		<div class="col-12 align-self-end">
    			<h5>Tags relacionadas</h5>
    			<c:forEach var="tags" items=""></c:forEach><%! //TODO tem que ver ! %>
    		</div>
    	</div>
		<c:import url="../components/footer/"/>

		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
     	
 	</body>
</html>