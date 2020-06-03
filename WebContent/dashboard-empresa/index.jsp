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
				Eventos próximos:
				<c:forEach var="ef" items="${listaEventosFuturos}">
                    <form action="/horadoevento/perfil/Perfil.do" method="get">
                        <input type="hidden" value="${evento.id}" name="id"/>
                        <button class="card-result-evento"  type="submit" value="evento" name="entidade">
                            <img src="../assets/icons/calendario-resultados.svg" style="height: 50px; position: absolute; left: 30px;"/> <br>
                            <p>${ef.titulo}</p>
                            <p style="color: blue;"><b>Palestrante: </b>${ef.palestrante}</p>
                        </button>
                    </form>
                </c:forEach>
                
                Eventos com mais inscritos:
                <c:forEach var="ef" items="${listaEventosFuturos}">
                    <form action="/horadoevento/perfil/Perfil.do" method="get">
                        <input type="hidden" value="${evento.id}" name="id"/>
                        <button class="card-result-evento"  type="submit" value="evento" name="entidade">
                            <img src="../assets/icons/calendario-resultados.svg" style="height: 50px; position: absolute; left: 30px;"/> <br>
                            <p>${ef.titulo}</p>
                            <p style="color: blue;"><b>Palestrante: </b>${ef.palestrante}</p>
                        </button>
                    </form>
                </c:forEach>
                
                Eventos Passados:
                <c:forEach var="evento" items="${listaEvento}">
                    <form action="/horadoevento/perfil/Perfil.do" method="get">
                        <input type="hidden" value="${evento.id}" name="id"/>
                        <button class="card-result-evento"  type="submit" value="evento" name="entidade">
                            <img src="../assets/icons/calendario-resultados.svg" style="height: 50px; position: absolute; left: 30px;"/> <br>
                            <p>${evento.titulo}</p>
                            <p style="color: blue;">${evento.empresa.nome}</p>
                        </button>
                    </form>
                </c:forEach>
			</c:if>
		</div>
		
		<c:import url="../components/footer/"/>
        
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>