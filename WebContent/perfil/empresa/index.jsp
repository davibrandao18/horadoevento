<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
    	<title>Perfil ${sessao_user.userName}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <link rel="shortcut icon" href="/horadoevento/assets/icons/HDE_transparent.png" />
        <link rel="stylesheet" href="/horadoevento/generalStyles.css">
        <link rel="stylesheet" href="../perfil.css">
        <link rel="stylesheet" href="/horadoevento/components/bootstrap/css/bootstrap.min.css">
    </head>
    
    <body>
   		<c:import url="../../components/navbar/full.jsp"/>
   		<c:set var="path" value="${sessao_user.foto.getAbsolutePath()}"/>
   		
   		<div class="bodyCover">
   			<div class="row pt-4">
   				<div class="col-6" style="text-align:end;">
   					<c:if test="${sessao_user.getFoto() != null}">
   						<img class="img-perfil-hde" src="/horadoevento/ImageResponse.do?file=${fn:replace(path, '\\', '/')}">
   					</c:if>
   					<c:if test="${sessao_user.getFoto() == null}">
   						<img class="img-perfil-hde" src="/horadoevento/assets/icons/user-01.png"/>
   					</c:if>
   				</div>
   				<div class="col-6 justify-content-start">
	               <form action="/horadoevento/perfil/UploadArquivo.do" method="post" enctype="multipart/form-data">
						<div class="botaoFoto">
							<input type="hidden" name="entidade" value="empresa"/>
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
   		
	        <div class="cover">
	                <form action="../Atualizar.do" method="post">
	                    <div class="row">
	                    	<div class="col-6 tudo-esquerda">
	                    		<h5 class="text-esquerda">Nome:</h5>
	                    		<input name="nome" value="${sessao_user.nome}" type="text" class="items-esquerda"> <br>
	                			<h5 class="text-esquerda">UserName:</h5>
	                    		<input name="username" value="${sessao_user.userName}" type="text" readonly disabled class="items-esquerda"> <br>
	                			<h5 class="text-esquerda">Senha:</h5>
	                    		<input name="senha" value="${sessao_user.senha}" type="password" class="items-esquerda"> <br>
	                    		<h5 class="text-direita">CNPJ:</h5>
			                	<input name="cpf" value="${sessao_user.cnpj}" type="text" readonly disabled class="items-direita"> <br>
			                    <h5 class="text-direita">E-mail:</h5>
			                    <input name="email" value="${sessao_user.email}" type="text" class="items-direita"> <br>
	                    	</div>
	                    	<div class="col-6 tudo-direita">
			                    <h5 class="text-direita">Linkedin:</h5>
			                    <input name="linkedin" value="${sessao_user.linkedin}" type="text" class="items-direita"> <br>
			                    <input type='hidden' value='empresa' name='entidade'>
			                	<h5 class="text-direita">Cidade:</h5>
			                	<input name="cpf" value="${sessao_user.cidade}" type="text" readonly disabled class="items-direita"> <br>
			                    <h5 class="text-direita">E-mail:</h5>
			                    <input name="email" value="${sessao_user.estado}" type="text" class="items-direita"> <br>
			                    <h5 class="text-direita">Pais:</h5>
			                    <input name="email" value="${sessao_user.pais}" type="text" class="items-direita"> <br>
			                    <h5 class="text-direita">Linkedin:</h5>
			                    <input name="linkedin" value="${sessao_user.linkedin}" type="text" class="items-direita"> <br>
			                    <input type='hidden' value='empresa' name='entidade'>
		                    </div>
		                 </div>
	                    <button type="submit">Atualizar Dados</button>
	                </form>
	                
	               	<form action="IniciarCadastroEvento.do" method="post">
	            		<button type="submit">Novo evento</button>
	            	</form>
	                <div>
	                	<button type="button" onclick="history.go(-1)">Cancelar</button>
	                </div>
	            </div>
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalExcluirUsuario">
					Excluir perfil
				</button>
	        </div>
        
        <c:import url="../../components/footer/"/>
        <c:import url="../../components/modal/perfil.jsp"/>
        
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>