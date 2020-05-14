<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
    	<title>Perfil de ${empresa.getNome()} </title>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <link rel="shortcut icon" href="/horadoevento/assets/icons/HDE_transparent.png" />
        <link rel="stylesheet" href="/horadoevento/generalStyles.css">
        <link rel="stylesheet" href="../../perfil.css">
        <link rel="stylesheet" href="/horadoevento/components/bootstrap/css/bootstrap.min.css">
    </head>
    
    <body>
    	<c:import url="../../components/navbar/full.jsp"/>
    	
        
     	<%!//TODO foto /!\%>
     	<h5> ${empresa.getNome()} </h5>
     	<small> ${empresa.getUserName()} </small>
     	<a href="${empresa.getLinkedin()}">LINKEDIN</a><%!//TODO icon linkedin /!\%>
     	
     	<%!//TODO tags de interesse%>
     	<%!//TODO últimos eventos%>
     	<%!//TODO certificados%>
     	
     	<c:import url="../../components/footer/footer.html"/>
     	
     	<script type="text/javascript" src="/horadoevento/components/theme-switcher/theme-switcher.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
     	
 	</body>
</html>