<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession, model.Empresa" %>
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
    		Empresa empresa = (Empresa) sessao.getAttribute("sessao_user");
   		%>
   		
        <div class="cover">
            <div>
            	<form action="../Logout.do" method="get">
            		<button type="submit">Sair</button>
            	</form> <br>
                <form action="../Atualizar.do" method="post">
                	<!-- /!\ tem que deixar o cara carragar a foto que ele quer -->
                	<%!//TODO foto /!\%>
                	<label>CNPJ:</label>
                	<input name="cpf" value="<%= empresa.getCnpj()%>" type="text" readonly disabled> <br>
                	<label>UserName:</label>
                    <input name="username" value="<%= empresa.getUserName()%>" type="text" readonly disabled> <br> <!-- /!\ como pegar  o atributo-->
                    <label>Nome:</label>
                    <input name="nome" value="<%= empresa.getNome()%>" type="text"> <br>
                    <label>Cidade:</label>
                    <input name="cidade" value="<%= empresa.getCidade()%>" type="text"> <br>
                    <label>Estado:</label>
                    <input name="estado" value="<%= empresa.getEstado()%>" type="text"> <br>
                    <label>Pais:</label>
                    <input name="pais" value="<%= empresa.getPais()%>" type="text"> <br>
                    <label>E-mail:</label>
                    <input name="email" value="<%= empresa.getEmail()%>" type="text"> <br>
                    <label>Senha:</label>
                    <input name="senha" value="<%= empresa.getSenha()%>" type="password"> <br>
                    <label>Linkedin:</label>
                    <input name="linkedin" value="<%= empresa.getLinkedin()%>" type="text"> <br>
                    <input type='hidden' value='empresa' name='entidade'>
                    <div>
                    	<button type="button" onclick="history.go(-1)">Cancelar</button>
                        <button type="submit">Atualizar</button>
                    </div>
                </form>
            </div>
        </div>
        
    </body>
</html>