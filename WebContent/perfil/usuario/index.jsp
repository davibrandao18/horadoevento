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
    	<c:import url="../../components/modal/perfil.jsp"/>
   		<c:set var="path" value="${sessao_user.getFoto().getAbsolutePath()}"/>

	<div class="bodyCover">
		<c:if test='${sessao_user == null}'>
			<h1>Você não está logado</h1>
			<a href="/horadoevento/inicio/">Voltar ao início</a>
		</c:if>
		<c:if test='${sessao_user != null}'>
			<div class="row pt-4">
				<div class="col-6" style="text-align: end;">
					<c:if test="${sessao_user.getFoto() != null}">
						<img class="img-perfil-hde"
							src="/horadoevento/ImageResponse.do?file=${fn:replace(path, '\\', '/')}">
					</c:if>
					<c:if test="${sessao_user.getFoto() == null}">
						<img class="img-perfil-hde"
							src="/horadoevento/assets/icons/user-01.png" />
					</c:if>
				</div>
				<div class="col-6 justify-content-start">
					<form action="/horadoevento/perfil/UploadArquivo.do" method="post"
						enctype="multipart/form-data">
						<input type='hidden' value='usuario' name='entidade'>
						<div class="botaoFoto">
							<input type="file" name="arquivo" size="50" id="itemBotao"
								class="fileField mt-4" /> <br /> <input type="submit"
								value="Atualizar foto" class="mt-4" />
						</div>
					</form>
				</div>
			</div>
		</c:if>

		<div class="cover">
			<form action="../Atualizar.do" method="post">
				<div class="row">
					<div class="col-6 tudo-esquerda">
						<h5 class="text-esquerda">Nome:</h5>
						<input name="nome" value="${sessao_user.nome}" type="text"
							class="items-esquerda"> <br>
						<h5 class="text-esquerda">UserName:</h5>
						<input name="username" value="${sessao_user.userName}" type="text"
							readonly disabled class="items-esquerda"> <br>
						<h5 class="text-esquerda">Senha:</h5>
						<input name="senha" value="${sessao_user.senha}" type="password"
							class="items-esquerda"> <br>
					</div>
					<div class="col-6 tudo-direita">
						<h5 class="text-direita">CPF:</h5>
						<input name="cpf" value="${sessao_user.cpf}" type="text" readonly
							disabled class="items-direita"> <br>
						<h5 class="text-direita">E-mail:</h5>
						<input name="email" value="${sessao_user.email}" type="text"
							class="items-direita"> <br>
						<h5 class="text-direita">Linkedin:</h5>
						<input name="linkedin" value="${sessao_user.linkedin}" type="text"
							class="items-direita"> <br> <input type='hidden'
							value='usuario' name='entidade'>
					</div>
				</div>

				<div class="row">
					<div class="col-12 align-self-center">
						<h5 style="text-align: center;">Tags relacionadas</h5>
					</div>
					<c:if test="${not empty listaTags}">
						<div class="col-12 col-md-4">
							<c:forEach var="tag" items="${listaTags}">
								<c:if test="${tag.checado == 1}">
									<div class="form-check">
										<input class="form-check-input" name="checkbox"
											type="checkbox" value="${tag.id}" id="defaultCheck1" checked>
										<label class="form-check-label" for="defaultCheck1">${tag.nome}</label>
									</div>
								</c:if>
								<c:if test="${tag.checado != 1}">
									<div class="form-check">
										<input class="form-check-input" name="checkbox"
											type="checkbox" value="${tag.id}" id="defaultCheck1">
										<label class="form-check-label" for="defaultCheck1">${tag.nome}</label>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</c:if>
				</div>

				<div class="row">
					<div class="col-4" style="text-align: end;">
						<button type="submit" class="botao-save">Salvar</button>
					</div>
					<div class="col-4" style="text-align: start;">
						<button type="button" onclick="history.go(-1)"
							class="botao-cancel">Cancelar</button>
					</div>
					<div class="col-4">
						<button type="button" style="text-align: center;"
							class="btn btn-primary botao-delete" data-toggle="modal"
							data-target="#modalExcluirUsuario">Excluir perfil</button>
					</div>
				</div>
			</form>
		</div>
		</div>
		<c:import url="../../components/footer/"/>
        <c:import url="../../components/modal/perfil.jsp"/>
        
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
        
    </body>
</html>