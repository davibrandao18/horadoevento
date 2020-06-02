<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
    	<title>Inscrição ${inscricao.id} </title>
        <c:import url="../../components/links.html"/>
        <link rel="stylesheet" href="../view/view.css">
    </head>
    
    <body>
    	<c:import url="../../components/navbar/full.jsp"/>
    	
    	<div class="bodyContent">
	    	<c:if test='${sessao_user == null}'>
				<h1>Você não está logado</h1>
				<a href="/horadoevento/inicio/">Voltar ao início</a>
			</c:if>
			<c:if test='${sessao_user != null}'>
		    	<div class="container">
		    		<div class="row">
		    			<div class="col-12 col-md-6">
		    				<h3>ID inscrição #${inscricao.id}</h3>
		    			</div>
		    			<div class="col-12 col-md-6">
		    				<p>Evento: ${evento.titulo}</p>
		    				<p>Data do evento: ${evento.dataHora}
			     			
		    			</div>
		    		</div>
		    	</div>
		    	
		    	<div class="row">
		    		<div class="col-12">
		    			
		    		</div>
		    	</div>
		    </c:if>
		</div>
		
		<c:import url="../../components/footer/"/>

		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
     	
 	</body>
</html>