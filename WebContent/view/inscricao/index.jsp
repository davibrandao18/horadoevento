<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Inscrições</title>
<c:import url="../../components/links.html" />
<link rel="stylesheet" href="../view/view.css">
</head>

<body>
	<c:import url="../../components/navbar/full.jsp" />
	<c:import url="../../components/modal/inscricaoView.jsp" />
	<c:import url="../../components/modal/inscricaoDelete.jsp" />

	<div class="bodyCover">
		<c:if test='${sessao_user == null}'>
			<h1>Você não está logado</h1>
			<a href="/horadoevento/inicio/">Voltar ao início</a>
		</c:if>
		<c:if test='${sessao_user != null}'>
			<div class="row">
				<div class="col-12 align-self-center">
					<h3 style="text-align: center;">${sessao_user.nome}, aqui
						estão suas inscrições:</h3>
				</div>
				<div class="col-6">
					<div class="table-responsive col-md-12">
						<table class="table table-striped">
							<thead>
								<th>ID</th>
								<th>Evento</th>
								<th class="actions">Ações</th>
							</thead>
							<tbody>
								<c:if test="${not empty inscricoes}">
									<c:forEach var="inscricao" items="${inscricoes}">
										<tr>
											<td><label data-inscricao="getId">${inscricao.id}</label></td>
											<td><label data-inscricao="getTitulo">${inscricao.evento.titulo}</label></td>
											<td class="actions">
                                                <form action="/horadoevento/controller.do" method="post">
                                                    <input
                                                        type="hidden" name="id" value="${inscricao.id}">
                                                    <button
                                                        type="submit"
	                                                    class="btn btn-primary btn-xs"
	                                                    name="command"
                                                        value="VisualizarInscricao">
                                                        Visualizar
                                                    </button>
                                                </form>
                                                <form action="/horadoevento/controller.do" method="post">
                                                    <input
                                                        type="hidden" name="id" value="${inscricao.id}">
                                                    <button
                                                        type="submit"
                                                        class="btn btn-primary btn-xs"
                                                        name="command"
                                                        value="CancelarInscricao">
                                                        Excluir
                                                    </button>
                                                </form>
											</td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>

					</div>
				</div>
			</div>
		</c:if>
	</div>

	<c:import url="../../components/footer/" />

	<script type="text/javascript"
		src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript"
		src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$("#modalInscricaoView").on('show.bs.modal', function(event) {
			let array = [document.querySelector('label[]')]
			
			var button = $(event.relatedTarget); //botao que disparou a modal
			var recipient = button.data('inscricao');
			$("#id_i").val(recipient);
		});
	</script>

</body>
</html>