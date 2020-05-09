<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 

<!DOCTYPE html>	
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">	
        <title>Hora do cadastro</title>
        <link rel="shortcut icon" href="../../assets/icons/HDE_transparent.png" />
        <link rel="stylesheet" href="../../generalStyles.css">
        <link rel="stylesheet" href="../cadastro.css">		
    </head>

	<body>
        <jsp:include page="/components/navbar/simple-navbar.html" flush="false" />
        
        <a href="/" class="btnBack"> <img src="../../assets/icons/arrowBefore.svg"> </a>
        
        <span class="disclaimer" id="centerText">Todos os campos são de preenchimento obrigatório</span>
        
        <form action="Cadastro.do" method="post" class="form">
            <label class="labels">CNPJ:</label>
            <input name="cnpj"  type="text" class="inputs">	
            
            <label class="labels">APELIDO:</label>
            <input name="username" type="text" class="inputs">	
            
            <label class="labels">NOME:</label>	
            <input name="nome" type="text" class="inputs">
            
            <label class="labels">CIDADE:</label>
            <input name="cidade" type="text" class="inputs">
            
            <label class="labels">ESTADO:</label>
            <input name="estado" type="text" class="inputs">
            
            <label class="labels">PAÍS:</label>
            <input name="pais" type="text" class="inputs">

            <label class="labels">EMAIL:</label>
            <input name="email" type="email" class="inputs">
            
            <label class="labels">SENHA:</label>
            <input name="senha" placeholder=" Senha" type="password" class="inputs">	
            
            <label class="labels">LINKEDIN:</label>
            <input name="linkedin" placeholder=" Coloque aqui o link para sua página do LinkedIn" class="inputs" id="linkedinInput">
            
            
            <label class="labels">FOTO:</label>
            <div class="botaoFoto">
                <label class="botaoLabel" id="itemBotao">Selecione o arquivo</label>
                <input name="foto" type="file" id="itemBotao" class="fileField">
            </div>
            
            <div>	
                <button type="submit" class="redButton">Continue ></button>	
            </div>	
        </form>
    </body>
</html>