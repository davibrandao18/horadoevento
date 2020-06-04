<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
    	<title>Evento: ${evento.titulo} </title>
        <c:import url="../../components/links.html"/>
        <link rel="stylesheet" href="../view/view.css"/>
    </head>
    
    <body class="bodyCover">
    	<c:import url="../../components/modal/inscricao.jsp"/>
    	<c:import url="../../components/navbar/full.jsp"/>
    	
    	<div>
    		<c:if test='${sessao_user == null}'>
				<h1>Você não está logado</h1>
				<a href="/horadoevento/inicio/">Voltar ao início</a>
			</c:if>
			<c:if test='${sessao_user != null}'>
		    	<div class="bodyContent">
		    		<div class="container">
			    		<div class="row">
			    		<div class="col-12 col-md-6" style="position: relative; left: -200px;">
			    			<div class="evento-container">
			    			<c:out value="${evento.id}"/>
			    			  <div style="margin-left:20px;">
			    				<h3>${evento.titulo}</h3>
			    				<small>
			    				Palestrante: <br>
			    				${evento.palestrante}
			    				</small>
			    				<p style="margin-top: 40px;">${evento.descricao}</p>
			    				<small style="margin-top: 100px;">${evento.localizacao}</small>
			    			  </div>
			    			</div>
			    		</div>
			    		</div>
			    	</div>
			    	
			    	<div class="row">
			    		<div class="col-12">
			    			<h5>Tags relacionadas</h5>
			    			<c:forEach var="tags" items=""></c:forEach><%! //TODO tem que ver ! %>
			    		</div>
			    	</div>
			    	
			    	<button type="button" data-toggle="modal" data-target="#modalInscricao" class="inscrever-botao">Inscrever-se</button>
			    	
			    </div>
			</c:if>
		</div>
    	
    	<div style="position: absolute; bottom: 0; width: 100%">
		<c:import url="../../components/footer/"/>
    	</div>

	<script type="text/javascript"
		src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript"
		src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>