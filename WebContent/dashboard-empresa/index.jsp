<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
    	<title>Dashboard</title>
        <c:import url="../components/links.html"/>
        <link rel="stylesheet" href="./dashboard.css">
    </head>
    
    <body class="bodyCover">
    	<c:import url="../components/navbar/full.jsp"/>
		
		<div>
            <c:import url="../components/marquee/homepage.jsp"/>
	    	<c:if test='${sessao_user == null}'>
				<h1>Você não está logado</h1>
				<a href="/horadoevento/inicio/">Voltar ao início</a>
			</c:if>
			
			<c:if test='${sessao_user != null}'>
				<div class="container" style="position: relative; left: -350px !important;">
				    <div class="row">Seus proximos 3 eventos:</div>
				    <div class="row">
					    <c:forEach var="tpe" items="${tresProximosEventos}">
		                    <form action="/horadoevento/perfil/Perfil.do" method="post">
		                        <input type="hidden" value="${tpe.id}" name="id"/>
		                        <button class="card-result-evento"  type="submit" value="evento" name="entidade">
		                            <div class="row">
                                        <img src="../assets/icons/calendario-resultados.svg" class="col-lg-2"style="height: 50px;"/> <br>
                                        <p class="col-lg-8">${tpe.titulo}</p>
                                  </div>
                                       <p>Palestrante: <br> ${tpe.palestrante}</p>
		                        </button>
		                    </form>
		                </c:forEach>
				    </div>
				    
                    <div class="row" style="margin-top: 40px;">Eventos passados:</div>
                    <div class="row">
                        <c:forEach var="lep" items="${listaEventosPassados}">
		                    <form action="/horadoevento/perfil/Perfil.do" method="post">
		                        <input type="hidden" value="${lep.id}" name="id"/>
		                        <button class="card-result-evento"  type="submit" value="evento" name="entidade">
		                           <div class="row">
                                        <img src="../assets/icons/calendario-resultados.svg" class="col-lg-2"style="height: 50px;"/> <br>
                                        <p class="col-lg-8">${lep.titulo}</p>
                                  </div>
                                       <p>Palestrante: <br> ${lep.palestrante}</p>
		                        </button>
		                    </form>
		                </c:forEach>
                    </div>
                    
                    <div class="row" style="margin-top: 40px;">Eventos futuros:</div>
                    <div class="row">
                        <c:forEach var="lef" items="${listaEventosFuturos}">
		                    <form action="/horadoevento/perfil/Perfil.do" method="post">
		                        <input type="hidden" value="${lef.id}" name="id"/>
		                        <button class="card-result-evento"  type="submit" value="evento" name="entidade">
		                          <div class="row">
			                            <img src="../assets/icons/calendario-resultados.svg" class="col-lg-2"style="height: 60px;"/> <br>
			                            <p class="col-lg-8">${lef.titulo}</p>
		                          </div>
			                           <p style="color: green;">Palestrante: <br> ${lef.palestrante}</p>
		                        </button>
		                    </form>
		                </c:forEach>
                    </div>
				</div>
			</c:if>
		</div>
		
		<div style="position: absolute; bottom: 0; width: 100%;">
            <c:import url="../components/footer/" />
        </div>
        
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>