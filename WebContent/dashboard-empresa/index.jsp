<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession, model.Empresa" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
    	<title>Dashboard</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <link rel="shortcut icon" href="/horadoevento/assets/icons/HDE_transparent.png" />
        <link rel="stylesheet" href="../generalStyles.css">
        <link rel="stylesheet" href="./member.css">
    </head>
    
    <body>
    	<%
    		HttpSession sessao = request.getSession();
    		Empresa empresa = (Empresa) sessao.getAttribute("sessao_user");
    	%>
    	
    	<div class="bodyContent">
			<jsp:include page="../components/navbar/full-navbar.jsp" flush="true" />
		    	
    		<h1>Saudações, <%= empresa.getNome() %></h1>
		</div>
	</body>
</html>