<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Evento: ${evento.titulo}</title>
<c:import url="../../components/links.html" />
<link rel="stylesheet" href="../view/view.css" />
</head>

<body>
	<c:import url="../../components/modal/inscricao.jsp" />
	<c:import url="../../components/navbar/full.jsp" />

	<div class="bodyCover">
		<c:if test='${sessao_user == null}'>
			<h1>Você não está logado</h1>
			<a href="/horadoevento/inicio/">Voltar ao início</a>
		</c:if>
		<c:if test='${sessao_user != null}'>
			<div class="bodyContent">
				<div class="container">
					<div class="row">
						<div class="col-12 col-md-6 evento-container">
							Evento ID #${evento.id}
							<h3>${evento.titulo}</h3>
							<small>Palestrante: ${evento.palestrante}</small>
							<p>Descrição: ${evento.descricao}</p>
							<p>Data Hora:${evento.dataHora}</p>
							<p>Localização: ${evento.localizacao}</p>
							<p>Duração em minutos: ${evento.duracao}mim</p>
							<p>Qtd Vagas: ${evento.quantidadeVagas}</p>
							<p>Nome Empresa: ${evento.empresa.nome}</p>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-12">
						<h5>Tags relacionadas</h5>
						<c:if test="${not empty evento.colecaoTags}">
							<div class="col-12 col-md-4">
								<c:forEach var="tag" items="${evento.colecaoTags}">
									<c:if test="${tag.checado == 1}">
									   <button class="btn btn-primary"> ${tag.nome}</button> <%! //TODO list filter by tag %>
									</c:if>
								</c:forEach>
							</div>
						</c:if>
					</div>
				</div>

				<c:if test='${tipo_entidade == "usuario"}'>
					<button type="button" data-toggle="modal"
						data-target="#modalInscricao">Inscrever-se</button>
				</c:if>

				<c:if test='${tipo_entidade == "empresa"}'>
					<button type="button" data-toggle="modal"
						data-target="#modalDeletar">Deletar evento</button>
					<form action="/Evento.do" method="post">
						<input type="hidden" name="id" value="${evento.id}" />
						<button type="submit" name="acao" value="editar">Editar</button>
					</form>
				</c:if>

			</div>
		</c:if>
	</div>

	<c:import url="../../components/footer/" />

	<script type="text/javascript"
		src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript"
		src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>