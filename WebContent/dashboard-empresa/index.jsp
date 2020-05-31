<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
    	<title>Dashboard</title>
        <c:import url="../components/links.html"/>
        <link rel="stylesheet" href="./dashboard.css">
    </head>
    
    <body>
    	<c:import url="../components/navbar/full.jsp"/>
		
		<div class="bodyCover">
	    	<c:if test='${sessao_user == null}'>
				<h1>Você não está logado</h1>
				<a href="/horadoevento/inicio/">Voltar ao início</a>
			</c:if>
			
			<c:if test='${sessao_user != null}'>
				dashboard<br/>
	    		dashboard<br/>
	    		dashboard<br/>
			</c:if>
		</div>
		
		<c:import url="../components/footer/"/>
        
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>