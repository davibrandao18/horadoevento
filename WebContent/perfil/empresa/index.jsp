<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
    	<title>Perfil</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <link rel="shortcut icon" href="/horadoevento/assets/icons/HDE_transparent.png" />
        <link rel="stylesheet" href="/horadoevento/generalStyles.css">
        <link rel="stylesheet" href="../perfil.css">
        <link rel="stylesheet" href="/horadoevento/components/bootstrap/css/bootstrap.min.css">
    </head>
    
    <body>
   		<c:import url="../../components/navbar/full.jsp"/>
   		<c:set var="path" value="${sessao_user.getFoto().getAbsolutePath()}"/>
   		
   		
   		<div class="bodyCover">
   			<div class="row pt-4">
   				<div class="col-6" style="text-align:end;">
   					<img class="img-perfil-hde" src="/horadoevento/ImageResponse.do?file=${fn:replace(path, '\\', '/')}">
   				</div>
   				<div class="col-6 justify-content-start">
	               <form action="/horadoevento/perfil/UploadArquivo.do" method="post" enctype="multipart/form-data">
						<div class="botaoFoto">
							<input type="file" name="arquivo" size="50" id="itemBotao" class="fileField mt-4"/> <br />
							<input type="submit" value="Atualizar foto" class="mt-4" />
						</div>
				   </form>
   				</div>
   			</div>
   			<div class="row">
   				<div class="col">
   					
   				</div>
   			</div>
   		</div>
   		
        <div class="cover">
            <div>
            	<form action="../Logout.do" method="get">
            		<button type="submit">Sair</button>
            	</form> <br>
                <form action="../Atualizar.do" method="post">
                	<!-- /!\ tem que deixar o cara carragar a foto que ele quer -->
                	<%!//TODO foto /!\%>
                	<label>CNPJ:</label>
                	<input name="cpf" value="${sessao_user.getCnpj()}" type="text" readonly disabled> <br>
                	<label>UserName:</label>
                    <input name="username" value="${sessao_user.getUserName()}" type="text" readonly disabled> <br> <!-- /!\ como pegar  o atributo-->
                    <label>Nome:</label>
                    <input name="nome" value="${sessao_user.getNome()}" type="text"> <br>
                    <label>Cidade:</label>
                    <input name="cidade" value="${sessao_user.getCidade()}" type="text"> <br>
                    <label>Estado:</label>
                    <input name="estado" value="${sessao_user.getEstado()}" type="text"> <br>
                    <label>Pais:</label>
                    <input name="pais" value="${sessao_user.getPais()}" type="text"> <br>
                    <label>E-mail:</label>
                    <input name="email" value="${sessao_user.getEmail()}" type="text"> <br>
                    <label>Senha:</label>
                    <input name="senha" value="${sessao_user.getSenha()}" type="password"> <br>
                    <label>Linkedin:</label>
                    <input name="linkedin" value="${sessao_user.getLinkedin()}" type="text"> <br>
                    <input type='hidden' value='empresa' name='entidade'>
                    
                    <button type="submit">Atualizar Dados</button>
                </form>
                
               	<form action="../../evento/novo/index.jsp" method="post">
            		<button type="submit">Novo evento</button>
            	</form>
                <div>
                	<button type="button" onclick="history.go(-1)">Cancelar</button>
                </div>
            </div>
        </div>
        
        <c:import url="../../components/footer/"/>
        
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>