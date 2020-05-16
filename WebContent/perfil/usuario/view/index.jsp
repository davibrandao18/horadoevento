<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
    	<title>Perfil de ${usuario.getUserName()} </title>
        <c:import url="../../../components/links.html"/>
        <link rel="stylesheet" href="../../perfil.css">
    </head>
    
    <body>
    	<c:import url="../../../components/navbar/full.jsp"/>
    	
    	<div class="container">
    		<div class="row">
    			<div class="col-12 col-md-6">
    				<%!//TODO foto /!\%>
    			</div>
    			<div class="col-12 col-md-6">
    			<c:out value="${param.usuario.nome}"/>
    				<h3>${param.usuario.nome}</h3>
    				<small>${param.usuario.getUserName()}</small>
	     			<a href="${param.usuario.getLinkedin()}">LINKEDIN</a><%!//TODO icon linkedin /!\%>
    			</div>
    		</div>
    	</div>
    	
    	<div class="row">
    		<div class="col-12">
    			<h5>Tags de interesse</h5>
    			<%! //TODO exibição botões tags %>
    			<%! //TODO pesquisa join com eventos %>
    		</div>
    	</div>
    	
    	<div class="row">
    		<div class="col-12">
    			<h5>Principais empresas</h5>
    			<%! //TODO exibição botões link empresa %>
    			<%! //TODO %>
    		</div>
    	</div>

		<c:import url="../../../components/footer/footer.html"/>

		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
     	
 	</body>
</html>