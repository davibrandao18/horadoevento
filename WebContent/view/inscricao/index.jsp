<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
    <title>Inscri��es</title>
    <c:import url="../../components/links.html" />
    <link rel="stylesheet" href="../view/view.css">
</head>

<body>
    <c:import url="../../components/navbar/full.jsp" />
    <c:import url="../../components/modal/inscricaoView.jsp" />
    <c:import url="../../components/modal/inscricaoDelete.jsp" />

    <div class="bodyCover">
        <c:if test='${sessao_user == null}'>
            <h1>Voce nao esta logado</h1>
            <a href="/horadoevento/inicio/">Voltar ao inicio</a>
        </c:if>
        <c:if test='${sessao_user != null}'>
            <div class="row">
                <div class="col-12 align-self-center">
                    <h3 style="text-align: center;">${sessao_user.nome}, aqui
                        estao suas inscricoes:</h3>
                </div>
                <div class="col-8">
                    <div class="table-responsive col-md-12">
                        <table class="table table-striped">
                            <thead>
                                <th>Empresa</th>
                                <th>Evento</th>
                                <th>Data Hora</th>
                                <th>Localizacao</th>
                                <th class="actions">Acoes</th>
                            </thead>
                            <tbody>
                                <c:if test="${not empty inscricoes}">
                                    <c:forEach var="inscricao" items="${inscricoes}">
                                        <tr>
                                            <td>${inscricao.evento.empresa.nome}</td>
                                            <td>${inscricao.evento.titulo}</td>
                                            <td>${inscricao.evento.dataHora}</td>
                                            <td>${inscricao.evento.localizacao}</td>
                                            <td class="actions">
                                                <form action="/horadoevento/Evento.do" method="post">
                                                    <input type="hidden" name="id" value="${inscricao.evento.id}">
                                                    <button type="submit" class="btn btn-primary btn-xs" name="acao"
                                                        value="visualizar">
                                                        Ver evento
                                                    </button>
                                                </form>
                                                <form action="/horadoevento/controller.do" method="post">
                                                    <input type="hidden" name="id" value="${inscricao.id}">
                                                    <button type="submit" class="btn btn-danger btn-xs" name="command"
                                                        value="CancelarInscricao">
                                                        Cancelar
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

    <script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $("#modalInscricaoView").on('show.bs.modal', function (event) {
            let array = [document.querySelector('label[]')]

            var button = $(event.relatedTarget); //botao que disparou a modal
            var recipient = button.data('inscricao');
            $("#id_i").val(recipient);
        });
    </script>

</body>

</html>
