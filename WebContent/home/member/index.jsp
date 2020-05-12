<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession, model.Usuario" %>
<%
	HttpSession sessao = request.getSession();
	Usuario user = (Usuario) sessao.getAttribute("sessao_user");
%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <title>Hora do Evento</title>
        <link rel="shortcut icon" href="/horadoevento/assets/icons/HDE_transparent.png" />
		<link rel="stylesheet" href="/horadoevento/components/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="../../generalStyles.css">
        <link rel="stylesheet" href="../home.css">
    </head>
    
    <body>
    	<jsp:include page="/components/navbar/full.jsp" flush="true" />
		
		<div class="bodyCover">
			
			<h2>Saudações, <%= user.getNome() %></h2>
			
			<h4>Missões mais populares</h4>
	
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
		
		
		<button class="helperDialog">
			<img src="../../assets/icons/dialog.svg">
			<p>Precisa de ajuda?</p>
		</button>
		
		<footer class="fullFooter">
			<div>
				<p>Acompanhe suas empresas favoritas</p>
			</div>
			<div id="companies">
				<button id="btnCompany"> <img src=""> </button>
				<button id="btnCompany"> <img src=""> </button>
				<button id="btnCompany"> <img src=""> </button>
				<button id="btnAddCompany"> <!-- ESSE BOTÃO COM ESSE TAMANHO DE FONTE, BUGA OS OUTROS -->
					+
				</button>
			</div>
			<div id="helper">
				<img src="../../assets/icons/helperCabeca.svg">
			</div>
		</footer>
		
		<script type="text/javascript" src="/horadoevento/components/theme-switcher/theme-switcher.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>