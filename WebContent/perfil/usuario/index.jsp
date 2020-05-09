<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession, model.Usuario" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
    	<title>Perfil</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <link rel="shortcut icon" href="/horadoevento/assets/icons/HDE_transparent.png" />
        <link rel="stylesheet" href="/horadoevento/generalStyles.css">
        <link rel="stylesheet" href="../perfil.css">
    </head>
    
    <body>
    	<jsp:include page="../../components/navbar/full-navbar.jsp" flush="true" />
    	<%	
    		HttpSession sessao = request.getSession();
    		Usuario user = (Usuario) sessao.getAttribute("sessao_user");
   		%>
   		
        <div class="cover">
            <div>
            	<form action="../Logout.do" method="get">
            		<button type="submit">Sair</button>
            	</form> <br>
                <form action="../Atualizar.do" method="post">
                	<!-- /!\ tem que deixar o cara carragar a foto que ele quer -->
                	<%!//TODO foto /!\%>
                	<label>CPF:</label>
                	<input name="cpf" value="<%= user.getCpf()%>" type="text" readonly disabled> <br>
                	<label>UserName:</label>
                    <input name="username" value="<%= user.getUserName()%>" type="text" readonly disabled> <br> <!-- /!\ como pegar  o atributo-->
                    <label>Nome:</label>
                    <input name="nome" value="<%= user.getNome()%>" type="text"> <br>
                    <label>E-mail:</label>
                    <input name="email" value="<%= user.getEmail()%>" type="text"> <br>
                    <label>Senha:</label>
                    <input name="senha" value="<%= user.getSenha()%>" type="password"> <br>
                    <label>Linkedin:</label>
                    <input name="linkedin" value="<%= user.getLinkedin()%>" type="text"> <br>
                    <input type='hidden' value='usuario' name='entidade'>
                    <div>
                    	<button type="button" onclick="history.go(-1)">Cancelar</button>
                        <button type="submit">Atualizar</button>
                    </div>
                </form>
            </div>
        </div>
        
    </body>
</html>