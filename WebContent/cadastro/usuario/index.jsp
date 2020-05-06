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

        <form action="/horadoevento/cadastro/Cadastro.do" method="post" style="display: grid;">
            <input type='hidden' value='usuario' name='entidade'>

            <label>Nome:</label>	
            <input name="nome" type="text">
            
            <label>CPF:</label>
            <input name="cpf"  type="text">	
            
            <label>Apelido:</label>
            <input name="username" type="text">	
            
            <label>E-mail:</label>
            <input name="email" type="email">
            
            <label>Senha:</label>
            <input name="senha" placeholder="senha" type="password">	
            
            <label>Linkedin:</label>
            <input name="linkedin" placeholder="ex: https://linkedin.com/in/username" type="text">
            <div>	
                <button type="submit" class="redButton">Continue ></button>	
            </div>	
        </form>
    </body>	
</html>