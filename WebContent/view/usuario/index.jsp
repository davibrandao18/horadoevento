<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
    	<title>Perfil de ${usuario.userName} </title>
        <c:import url="../../components/links.html"/>
        <link rel="stylesheet" href="../view/view.css">
    </head>
    
    <body>
    	<c:import url="../../components/navbar/full.jsp"/>
    	
    	<div class="bodyContent">
	    	
	    	<div class="container">
	    		<div class="row">
	    			<div class="col-12 col-md-6">
	    				<%!//TODO foto /!\%>
	    			</div>
	    			<div class="col-12 col-md-6">
	    			<c:out value="${usuario.nome}"/>
	    				<h3>${usuario.nome}</h3>
	    				<small>${usuario.userName}</small>
		     			<a href="${usuario.linkedin}">LINKEDIN</a><%!//TODO icon linkedin /!\%>
	    			</div>
	    		</div>
	    	</div>
	    	
	    	<div class="row">
	    		<div class="col-12">
	    			<h5>Tags de interesse</h5>
	    			<c:forEach var="tags" items="${lista}"></c:forEach><%! //TODO tem que ver ! %>
	    			<%! //TODO pesquisa join com eventos %>
	    		</div>
	    	</div>
		</div>
		
		<c:import url="../../components/footer/"/>

		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
     	
 	</body>
</html>