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
            <c:import url="../components/marquee/homepage.jsp"/>
	    	<c:if test='${sessao_user == null}'>
				<h1>Você não está logado</h1>
				<a href="/horadoevento/inicio/">Voltar ao início</a>
			</c:if>
			
			<c:if test='${sessao_user != null}'>
				<div class="container">
				    <div class="row">Seus proximos 3 eventos:</div>
				    <div class="row">
					    <c:forEach var="tpe" items="${tresProximosEventos}">
		                    <form action="/horadoevento/perfil/Perfil.do" method="get">
		                        <input type="hidden" value="${tpe.id}" name="id"/>
		                        <button class="card-result-evento"  type="submit" value="evento" name="entidade">
		                            <img src="../assets/icons/calendario-resultados.svg" style="height: 50px; position: absolute; left: 30px;"/> <br>
		                            <p>${tpe.titulo}</p>
		                            <p style="color: red;"><b>Palestrante: </b>${tpe.palestrante}</p>
		                        </button>
		                    </form>
		                </c:forEach>
				    </div>
				    
                    <div class="row">Eventos passados:</div>
                    <div class="row">
                        <c:forEach var="lep" items="${listaEventosPassados}">
		                    <form action="/horadoevento/perfil/Perfil.do" method="get">
		                        <input type="hidden" value="${lep.id}" name="id"/>
		                        <button class="card-result-evento"  type="submit" value="evento" name="entidade">
		                            <img src="../assets/icons/calendario-resultados.svg" style="height: 50px; position: absolute; left: 30px;"/> <br>
		                            <p>${lep.titulo}</p>
		                            <p style="color: blue;"><b>Palestrante: </b>${lep.palestrante}</p>
		                        </button>
		                    </form>
		                </c:forEach>
                    </div>
                    
                    <div class="row">Eventos futuros:</div>
                    <div class="row">
                        <c:forEach var="lef" items="${listaEventosFuturos}">
		                    <form action="/horadoevento/perfil/Perfil.do" method="get">
		                        <input type="hidden" value="${lef.id}" name="id"/>
		                        <button class="card-result-evento"  type="submit" value="evento" name="entidade">
		                            <img src="../assets/icons/calendario-resultados.svg" style="height: 50px; position: absolute; left: 30px;"/> <br>
		                            <p>${lef.titulo}</p>
		                            <p style="color: green;"><b>Palestrante: </b>${lef.palestrante}</p>
		                        </button>
		                    </form>
		                </c:forEach>
                    </div>
				</div>
			</c:if>
		</div>
		
		<c:import url="../components/footer/"/>
        
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>