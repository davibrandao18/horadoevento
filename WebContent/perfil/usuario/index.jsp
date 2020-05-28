<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
    	<title>Perfil ${sessao_user.userName}</title>
        <c:import url="../../components/links.html"/>
        <link rel="stylesheet" href="../perfil.css">
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
            			<input type='hidden' value='usuario' name='entidade'>
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
   		
   		
        <div class="cover">
            <div>
                <form action="../Atualizar.do" method="post">
                    <div class="row"> 
                    	<div class="col-6 tudo-esquerda">
                    		<h5 class="text-esquerda">Nome:</h5>
                    		<input name="nome" value="${sessao_user.nome}" type="text" class="items-esquerda"> <br>
                			<h5 class="text-esquerda">UserName:</h5>
                    		<input name="username" value="${sessao_user.userName}" type="text" readonly disabled class="items-esquerda"> <br>
                			<h5 class="text-esquerda">Senha:</h5>
                    		<input name="senha" value="${sessao_user.senha}" type="password" class="items-esquerda"> <br>
                    	</div>   	
	                	<div class="col-6 tudo-direita">
		                	<h5 class="text-direita">CPF:</h5>
		                	<input name="cpf" value="${sessao_user.cpf}" type="text" readonly disabled class="items-direita"> <br>
		                    <h5 class="text-direita">E-mail:</h5>
		                    <input name="email" value="${sessao_user.email}" type="text" class="items-direita"> <br>
		                    <h5 class="text-direita">Linkedin:</h5>
		                    <input name="linkedin" value="${sessao_user.linkedin}" type="text" class="items-direita"> <br>
		                    <input type='hidden' value='usuario' name='entidade'>
		                    <button type="submit" class="botao-save">Salvar</button>
               				<button type="button" onclick="history.go(-1)" class="botao-cancel">Cancelar</button>
	                    </div>
                    </div>
               </form>
               
               <div class="row">
               </div>
               <h5>Tags relacionadas</h5>
               <c:if test="${not empty lista}">
					<div id="list" class="row">
						<div class="table-responsive col-md-12">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Nome</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="tags" items="${lista}">
										<tr>
											<td>${tag.nome}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:if>
               
               	<button type="button" class="btn btn-primary botao-delete" data-toggle="modal" data-target="#modalExcluirUsuario">
					Excluir perfil
				</button>
			</div>
        </div>
        
        </div>
        
        
        <c:import url="../../components/footer/"/>
        <c:import url="../../components/modal/perfil.jsp"/>
        
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
        
    </body>
</html>