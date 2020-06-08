<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
    <title>Evento: ${evento.titulo} </title>
    <c:import url="../../components/links.html" />
    <link rel="stylesheet" href="../view/view.css" />
</head>

<body class="bodyCover">
    <c:import url="../../components/modal/inscricao.jsp" />
    <c:import url="../../components/navbar/full.jsp" />

    <div>
        <c:if test='${sessao_user == null}'>
            <h1>Voc� n�o est� logado</h1>
            <a href="/horadoevento/inicio/">Voltar ao in�cio</a>
        </c:if>
        <c:if test='${sessao_user != null}'>
            <div class="bodyContent">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-md-6" style="position: relative; left: -200px;">
                            <div class="evento-container">
                                <c:out value="${evento.id}" />
                                <div style="margin-left:20px;">
                                    <h3>${evento.titulo}</h3>
                                    <small>
                                        Palestrante: <br>
                                        ${evento.palestrante}
                                    </small>
                                    <p style="margin-top: 40px;">${evento.descricao}</p>
                                    <small style="margin-top: 100px;">${evento.localizacao}</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12">
                        <h5>Tags relacionadas</h5>

                        <c:if test="${not empty evento.colecaoTags}">
                            <div id="list" class="row">
                                <div class="table-responsive col-md-12">
                                    <table class="table table-striped">
                                        <tbody>
                                            <c:forEach var="tag" items="${evento.colecaoTags}">
                                                <tr>
                                                    <c:if test="${tag.checado == 1}">
                                                        <td>${tag.nome}</td>
                                                    </c:if>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <button type="submit" value="editar" name="acao">Deletar
                                Evento</button>
                        </c:if>
                    </div>
                </div>

                <c:if test="${inscricoes.size() == 0 }">
                    <button type="button" data-toggle="modal" data-target="#modalInscricao"
                        class="inscrever-botao">Inscrever-se</button>
                </c:if>

                <c:if test='${tipo_entidade.equals("usuario")}'>
                    <c:forEach var="inscricao" items="${inscricoes}" varStatus="counter">
                        <c:if test="${inscricao.evento.id == evento.id}">
                            <form action="/horadoevento/controller.do" method="post">
                                <input type="hidden" name="id" value="${inscricao.id}">
                                <button type="submit" class="btn btn-danger btn-xs" name="command"
                                    value="CancelarInscricao">
                                    Cancelar Inscri��o
                                </button>
                            </form>
                        </c:if>
                        <c:if test="${counter.count == inscricoes.size() }">
                            <c:if test="${inscricao.evento.id != evento.id}">
                                <button type="button" data-toggle="modal" data-target="#modalInscricao"
                                    class="inscrever-botao">Inscrever-se</button>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </c:if>

                <c:if test='${tipo_entidade.equals("empresa")}'>
                    <c:forEach var="eventoEmpresa" items="${listaEventos}" varStatus="counter">
                        <c:if test="${eventoEmpresa.id == evento.id}">
                            <form action="/horadoevento/Evento.do" method="post">
                                <input type="hidden" name="id" value="${evento.id}">
                                <button type="submit" class="btn btn-danger btn-xs" name="acao" value="editar">
                                    Editar evento
                                </button>
                            </form>
                        </c:if>
                    </c:forEach>
                </c:if>


            </div>
        </c:if>
    </div>

    <div style="position: absolute; bottom: 0; width: 100%">
        <c:import url="../../components/footer/" />
    </div>

    <script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
