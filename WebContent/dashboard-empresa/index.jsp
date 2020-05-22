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
		<c:import url="../components/alert/boasvindas/"/>
		
    	<div class="bodyCover">
    		dashboard<br/>
    		dashboard<br/>
    		dashboard<br/>
		</div>
		
		<c:import url="../components/footer/"/>
        
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>