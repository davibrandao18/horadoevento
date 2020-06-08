<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Cadastre-se no Hora do Evento</title>
        <c:import url="../../components/links.html"/>
        <link rel="stylesheet" href="../home.css">
    </head>
    
    <body class="bodyCover">
    	<c:import url="../../components/navbar/visitante.jsp"/>
		
		<div>
			<c:import url="../../components/carousel/"/>
			
			<div class="container">
				<h5 class="text-center">Missões que combinam com você</h5>
				
				<div class="row">
					<div class="col-6 col-md-3 mt-2">
						<button class="card-hde primary-card yellow-card">
							EVENTO W <br> <br> <small>[data] | [hora]</small>
						</button>
					</div>
					<div class="col-6 col-md-3 mt-2">
						<button class="card-hde primary-card yellow-card">
							EVENTO X <br> <br> <small>[data] | [hora]</small>
						</button>
					</div>
					<div class="col-6 col-md-3 mt-2">
						<button class="card-hde primary-card yellow-card">
							EVENTO Y <br> <br> <small>[data] | [hora]</small>
						</button>
					</div>
					<div class="col-6 col-md-3 mt-2">
						<button class="card-hde primary-card yellow-card">
							EVENTO Z <br> <br> <small>[data] | [hora]</small>
						</button>
					</div>
				</div>
				
				
				<h5 class="text-center mt-4">Categorias</h5>
				
				<div class="row pb-4 justify-content-center">
					<div class="col-10 col-md-3 mt-2">
						<button class="card-hde secondary-card text-center pink-card">
							DESIGN
						</button>
					</div>
					<div class="col-10 col-md-3 mt-2">
						<button class="card-hde secondary-card text-center pink-card">
							GASTRONOMIA
						</button>
					</div>
					<div class="col-10 col-md-3 mt-2">
						<button class="card-hde secondary-card text-center pink-card">
							JOGOS
						</button>
					</div>
					<div class="col-10 col-md-3 mt-2">
						<button class="card-hde secondary-card text-center pink-card">
							TECNOLOGIA
						</button>
					</div>
				</div>
			</div>
			
			<div style="position: absolute; bottom: 0; width: 100%;">	
	    	<c:import url="../../components/footer-outro-sprite/" />
			</div>	
		</div>
		
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>