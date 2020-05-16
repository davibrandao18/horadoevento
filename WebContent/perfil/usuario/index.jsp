<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
    	<title>Perfil ${sessao_user.userName}</title>
        <c:import url="../../components/links.html"/>
        <link rel="stylesheet" href="../perfil.css">
    </head>
    
    <body>
    	<c:import url="../../components/navbar/full.jsp"/>
   		
        <div class="cover">
            <div>
            	<form action="../Logout.do" method="get">
            		<button type="submit">Sair</button>
            	</form> <br>
                <form action="../Atualizar.do" method="post">
   
                	<%!//TODO foto /!\%>
                	<label>CPF:</label>
                	<input name="cpf" value="${sessao_user.cpf}" type="text" readonly disabled> <br>
                	<label>UserName:</label>
                    <input name="username" value="${sessao_user.userName}" type="text" readonly disabled> <br>
                    <label>Nome:</label>
                    <input name="nome" value="${sessao_user.nome}" type="text"> <br>
                    <label>E-mail:</label>
                    <input name="email" value="${sessao_user.email}" type="text"> <br>
                    <label>Senha:</label>
                    <input name="senha" value="${sessao_user.senha}" type="password"> <br>
                    <label>Linkedin:</label>
                    <input name="linkedin" value="${sessao_user.linkedin}" type="text"> <br>
                    <input type='hidden' value='usuario' name='entidade'>

                    <button type="submit">Atualizar Dados</button>
               </form>
               <c:if test="${sessao_user.getFoto().exists()}">
               		ta tudo certo.
               </c:if>
               <img src="/horadoevento/ImageResponse.do?file=${sessao_user.getFoto().getAbsolutePath()}">
               <form action="/horadoevento/perfil/UploadArquivo.do" method="post" enctype="multipart/form-data">
					<div class="botaoFoto">
						<input type="file" name="arquivo" size="50" id="itemBotao" class="fileField" /> <br />
						<input type="submit" value="Atualizar foto" />
					</div>
			   </form>
               
                <button type="button" onclick="history.go(-1)">Cancelar</button>
            
            </div>
        </div>
        
        <c:import url="../../components/footer/footer.html"/>
        
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
        
    </body>
</html>