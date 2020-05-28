<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
    	<title>Evento: ${evento.titulo} </title>
        <c:import url="../../components/links.html"/>
    </head>
    
    <body>
    	<c:import url="../../components/modal/inscricao.jsp"/>
    	<c:import url="../../components/navbar/full.jsp"/>
    	
    	<div class="bodyContent">
    		<div class="container">
	    		<div class="row">
	    			<div class="col-12 col-md-6">
	    			<c:out value="${evento.id}"/>
	    				<h3>${evento.titulo}</h3>
	    				<small>${evento.palestrante}</small>
	    				<p>${evento.descricao}</p>
	    				<!-- continuar exibi��o -->
	    			</div>
	    		</div>
	    	</div>
	    	
	    	<div class="row">
	    		<div class="col-12">
	    			<h5>Tags relacionadas</h5>
	    			<c:forEach var="tags" items=""></c:forEach><%! //TODO tem que ver ! %>
	    		</div>
	    	</div>
	    	
	    	<button type="button" data-toggle="modal" data-target="#modalInscricao"></button>
	    	
    	</div>
    	
		<c:import url="../../components/footer/"/>

		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
 	</body>
</html>