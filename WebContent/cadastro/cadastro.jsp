<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>	
<html lang="pt-br">
    <head>
    <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">	
        <title>Hora do CADASTRO</title>
        <link rel="shortcut icon" href="../assets/icons/HDE_transparent.png" />
        <link rel="stylesheet" href="../generalStyles.css">
        <link rel="stylesheet" href="./cadastro.css">	
    </head>	

    <body style="padding: 0 150px 0 150px; display: block;">
    	<jsp:include page="../components/navbar/simple-navbar.html" flush="false" />
        
        <a href="/horadoevento/begin/" class="btnBack"> <img src="../assets/icons/arrowBefore.svg"> </a>
        
        <form action="Cadastro.do" method="post" style="display: grid;">
            <label>Nome:</label>	
            <input name="nome" type="text">
            
            <label>CPF:</label>
            <input name="cpf"  type="text">	
            
            <label>Nome de usuário:</label>
            <input name="username" type="text">	
            
            <label>E-mail:</label>
            <input name="email" type="email">
            
            <label>Senha:</label>
            <input name="senha" placeholder="senha" type="password">	
            
            <label>Foto:</label>
            <input name="foto" type="file">
            <div>	
                <button type="submit" class="redButton">Continue ></button>	
            </div>	
        </form>
    </body>	
</html>