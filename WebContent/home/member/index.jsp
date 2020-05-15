<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="javax.servlet.http.HttpSession, model.Usuario" %>
<%
	HttpSession sessao = request.getSession();
	Usuario user = (Usuario) sessao.getAttribute("sessao_user");
%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Hora do Evento</title>
        <c:import url="../../components/links.html"/>
        <link rel="stylesheet" href="../home.css">
    </head>
    
    <body>
    	<c:import url="../../components/navbar/full.jsp"/>
		
		<div class="bodyCover">
			
			<h2>Saudações, <%= user.getNome() %></h2>
			
			<h4>Missões mais populares</h4>
			
    		<c:import url="../../components/carousel/carousel.jsp"/>
    		
			<div class="carousel">
				<h1>CURSO TAL</h1>
				<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptas libero ipsam aspernatur(...)</p>
				<h2>ONDE E QUANDO IR:</h2>
				<p>[data] | [hora] <br><br> [endereço]</p>
			</div>
	
			<h4>Missões que combinam com você</h4>
	
			<div class="cardGroup primary-cards">
				<button>
					NOME BEM GRANDE <br> <small>[data] | [hora]</small>
				</button>
				<button>
					NOME BEM GRANDE <br> <small>[data] | [hora]</small>
				</button>
				<button>
					NOME BEM GRANDE <br> <small>[data] | [hora]</small>
				</button>
				<button>
					NOME BEM GRANDE <br> <small>[data] | [hora]</small>
				</button>
			</div>
	
			<h4>Categorias sugeridas</h4>
	
			<div class="cardGroup secondary-cards">
				<button> NOME BEM GRANDE </button>
				<button> NOME BEM GRANDE </button>
				<button> NOME BEM GRANDE </button>
				<button> NOME BEM GRANDE </button>
			</div>
		</div>
		
		
    	<c:import url="../../components/footer/footer.html"/>
		
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>