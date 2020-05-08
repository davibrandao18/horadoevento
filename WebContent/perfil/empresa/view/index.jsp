<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ page import="model.Empresa" %>
<% Empresa empresa = (Empresa) request.getAttribute("empresa"); %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
    	<title>Perfil de <%=empresa.getUserName()%></title>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <link rel="shortcut icon" href="/horadoevento/assets/icons/HDE_transparent.png" />
        <link rel="stylesheet" href="/horadoevento/generalStyles.css">
    </head>
    
    <body>
    	<jsp:include page="../../../components/navbar/full-navbar.jsp" flush="true" />
    	
        
     	<%!//TODO foto /!\%>
     	<h5><%=empresa.getNome()%></h5>
     	<small><%=empresa.getUserName()%></small>
     	<a href="<%=empresa.getLinkedin()%>">LINKEDIN</a><%!//TODO icon linkedin /!\%>
     	
     	<%!//TODO tags de interesse%>
     	<%!//TODO últimos eventos%>
     	<%!//TODO certificados%>
     	
 	</body>
</html>