<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ page import="model.Usuario" %>
<% Usuario user = (Usuario) request.getAttribute("usuario"); %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
    	<title>Perfil de <%=user.getUserName()%></title>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <link rel="shortcut icon" href="/horadoevento/assets/icons/HDE_transparent.png" />
        <link rel="stylesheet" href="/horadoevento/generalStyles.css">
        <link rel="stylesheet" href="../../perfil.css">
    </head>
    
    <body>
    	<jsp:include page="../../../components/navbar/full-navbar.jsp" flush="true" />
    	
        
     	<%!//TODO foto /!\%>
     	<h5><%=user.getNome()%></h5>
     	<small><%=user.getUserName()%></small>
     	<a href="<%=user.getLinkedin()%>">LINKEDIN</a><%!//TODO icon linkedin /!\%>
     	
     	<%!//TODO tags de interesse%>
     	<%!//TODO últimos eventos%>
     	<%!//TODO certificados%>
     	
 	</body>
</html>