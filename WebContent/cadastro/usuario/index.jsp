<%@ page language="java" contentType="text/html; charset=iso-8859-1"%> 

<!DOCTYPE html>	
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">	
        <title>Hora do cadastro</title>
        <link rel="shortcut icon" href="../../assets/icons/HDE_transparent.png" />
        <link rel="stylesheet" href="../../generalStyles.css">
        <link rel="stylesheet" href="../cadastro.css">		
    </head>

    <body style="padding: 0 150px 0 150px; display: block;">
    	<jsp:include page="/components/navbar/simple-navbar.html" flush="false" />
        
        <a href="/horadoevento/inicio/" class="btnBack"> <img src="../../assets/icons/arrowBefore.svg"> </a>
        
		<% 
			boolean v = (request.getAttribute("novo_login")== null)? true : false; 
			String color = (v)?"black" : "red";
		%>
		
		<p style="border : solid 1px <%=color%>">
			Olá eu sou goku ! Preencha tudo certo que vai dar bom ! Cpf lala, Username lala, bejos
		</p>
		
        <form action="/horadoevento/cadastro/Cadastro.do" method="post" style="display: grid;">
            <input type='hidden' value='usuario' name='entidade'>

            <label>Nome:</label>	
            <input name="nome" type="text" required>
            
            <label>CPF:</label>
            <input name="cpf"  type="text" required>	
            
            <label>Apelido:</label>
            <input name="username" type="text" required>	
            
            <label>E-mail:</label>
            <input name="email" type="email" required>
            
            <label>Senha:</label>
            <input name="senha" placeholder="senha" type="password" required>	
            
            <label>Linkedin:</label>
            <input name="linkedin" placeholder="ex: https://linkedin.com/in/username" type="text">
            <div>	
                <button type="submit" class="redButton">Continue ></button>	<%! //TODO icon seta %>
            </div>	
        </form>
    </body>	
</html>