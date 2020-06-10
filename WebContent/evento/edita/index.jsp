<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Editar evento ${evento.id}</title>
    <c:import url="../../components/links.html" />

</head>

<body>
    <c:import url="../../components/modal/deletarEvento.jsp" />
    <c:import url="../../components/navbar/full.jsp" />

    <div class="bodyCover">
    
    <c:if test="${sessao_user == null}">
        <c:import url="../../components/naoLogadoMensagem/"/>
    </c:if>
    
        <div class="row pt-4">
            <div class="col-md-6 justify-content-center" style="text-align:end;">
                <form action="/horadoevento/Evento.do" method="post">
                    <input type="hidden" name="id" value="${evento.id}" />
                    
                    <label for="titulo">Titulo:</label>
                    <input name="titulo" value="${evento.titulo}" type="text" class="form-control bginput-hde"> <br>

                    <label for="data-hora">Data e Hora</label>
                    <input type="datetime-local" value="${evento.dataHora}" class="form-control bginput-hde"
                        name="data-hora" id="data-hora" required maxlength="100">

                    <label for="localizacao">Localizacao:</label>
                    <input name="localizacao" value="${evento.localizacao}" type="text" class="form-control bginput-hde"> <br>

                    <label for="descricao">Descricao:</label>
                    <textarea name="descricao" class="form-control bginput-hde">${evento.descricao}</textarea> <br>

                    <label for="duracao">Duracao em minutos:</label>
                    <input name="duracao" value="${evento.duracao}" type="number" class="form-control bginput-hde"> <br>

                    <label for="qtd-vagas">Quantidade de vagas:</label>
                    <input name="qtd-vagas" value="${evento.quantidadeVagas}" type="number" class="form-control bginput-hde"> <br>

                    <label for="palestrante">Palestrante:</label>
                    <input name="palestrante" value="${evento.palestrante}" type="text" class="form-control bginput-hde"> <br>

                    <h5>Tags relacionadas</h5>

					<div class="row">
						<c:if test="${not empty evento.colecaoTags}">
							<div class="col-12 d-flex justify-content-center">
								<c:forEach var="tag" items="${evento.colecaoTags}">
									<c:if test="${tag.checado == 1}">
										<div class="form-check ml-2 mr-2">
											<input class="form-check-input" name="checkbox"
												type="checkbox" value="${tag.id}" id="defaultCheck${tag.id}"
												checked> <label class="form-check-label text-dark"
												for="defaultCheck${tag.id}">${tag.nome}</label>
										</div>
									</c:if>
									
									<c:if test="${tag.checado != 1}">
										<div class="form-check ml-2 mr-2">
											<input class="form-check-input" name="checkbox"
												type="checkbox" value="${tag.id}" id="defaultCheck${tag.id}">
											<label class="form-check-label text-dark"
												for="defaultCheck${tag.id}">${tag.nome}</label>
										</div>
									</c:if>
								</c:forEach>
							</div>
						</c:if>
					</div>

					<div class="row">
						<div class="col-4">
							<button type="submit" class="btnUpdate" name="acao" value="editar">Salvar</button>
						</div>
						<div class="col-4">
							<button type="button" onclick="history.go(-1)" class="btnCancel">Cancelar</button>
						</div>
					</div>

				</form>
            </div>
        </div>
        <button type="button" data-toggle="modal" data-target="#modalExcluir">Deletar Evento</button>
    </div>

    <c:import url="../../components/footer/" />

    <script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>
