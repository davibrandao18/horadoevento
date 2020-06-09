<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <title>Perfil ${sessao_user.userName}</title>
    <c:import url="../../components/links.html" />
    <link rel="stylesheet" href="../perfil.css">
</head>

<body class="bodyCover">
    <c:import url="../../components/navbar/full.jsp" />
    <c:import url="../../components/modal/perfil.jsp" />
    <c:set var="path" value="${sessao_user.getFoto().getAbsolutePath()}" />

    <div>
        <c:if test='${sessao_user == null}'>
<<<<<<< HEAD
            <h1>Voce nao esta logado</h1>
            <a href="/horadoevento/inicio/">Voltar ao inicio</a>
=======
            <c:import url="../../components/naoLogadoMensagem/" />
>>>>>>> branch 'master' of https://github.com/davibrandao18/horadoevento.git
        </c:if>

        <c:if test='${sessao_user != null}'>
            <div class="row pt-4">
                <div class="col-6" style="text-align: end;">
                    <c:if test="${sessao_user.getFoto() != null}">
                        <img class="img-perfil-hde"
                            src="/horadoevento/ImageResponse.do?file=${fn:replace(path, '\\', '/')}">
                    </c:if>
                    <c:if test="${sessao_user.getFoto() == null}">
                        <img class="foto-fix" src="/horadoevento/assets/icons/helperCabeca.svg" />
                    </c:if>
                </div>
                <div class="col-6 justify-content-start" style="align-self: center;">
                    <form action="/horadoevento/perfil/UploadArquivo.do" method="post" enctype="multipart/form-data"
                        style="display: flex;">
                        <input type='hidden' value='usuario' name='entidade'>
                        <div class="divInputFile">
                            <input type="file" size="50" id="file" name="arquivo" class="inputFile" />
                            <label for="file" class="labelFile"><img width="30px"
                                    src="/horadoevento/assets/logo/upload.svg" /></label>
                        </div>
                        <input type="submit" value="Enviar" class="btnSendPhoto" />
                    </form>
                </div>
            </div>
            <form action="../Atualizar.do" method="post">
                <div class="row">
                    <div class="col-12 col-md-6 justify">
                        <div class="col-12">
                            <h5>Nome:</h5>
                            <input name="nome" value="${sessao_user.nome}" type="text">
                        </div>
                        <div class="col-12 col-md-6">
                            <h5>UserName:</h5>
                            <input name="username" value="${sessao_user.userName}" type="text" readonly disabled>
                        </div>
                        <div class="col-12 col-md-6">
                            <h5>Senha:</h5>
                            <input name="senha" value="${sessao_user.senha}" type="password">
                        </div>
                    </div>

                    <div class="col-12 col-md-6">
                        <div class="col-12">
                            <h5>CPF:</h5>
                            <input name="cpf" value="${sessao_user.cpf}" type="text" readonly disabled>
                        </div>
                        <div class="col-12 col-md-6">
                            <h5>E-mail:</h5>
                            <input name="email" value="${sessao_user.email}" type="text">
                        </div>
                        <div class="col-12 col-md-6">
                            <h5>Linkedin:</h5>
                            <input name="linkedin" value="${sessao_user.linkedin}" type="text">
                            <input type='hidden' value='usuario' name='entidade'>
                        </div>

                    </div>
                </div>

                <h5 style="text-align: center;">Tags relacionadas:</h5>
                <div class="row">
                    <c:if test="${not empty listaTags}">
                        <div class="col-12 d-flex justify-content-center">
                            <c:forEach var="tag" items="${listaTags}">
                                <c:if test="${tag.checado == 1}">
                                    <div class="form-check ml-2 mr-2">
                                        <input class="form-check-input" name="checkbox" type="checkbox"
                                            value="${tag.id}" id="defaultCheck${tag.id}" checked>
                                        <label class="form-check-label text-dark"
                                            for="defaultCheck${tag.id}">${tag.nome}</label>
                                    </div>
                                </c:if>
                                <c:if test="${tag.checado != 1}">
                                    <div class="form-check ml-2 mr-2">
                                        <input class="form-check-input" name="checkbox" type="checkbox"
                                            value="${tag.id}" id="defaultCheck${tag.id}">
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
                        <button type="submit" class="btnUpdate">Salvar</button>
                    </div>
                    <div class="col-4">
                        <button type="button" onclick="history.go(-1)" class="btnCancel">Cancelar</button>
                    </div>
                </div>

                <button
                    type="button"
                    class="btnDelete"
                    data-toggle="modal"
                    data-target="#modalExcluirUsuario">
                        Excluir perfil
                </button>
            </form>
        </c:if>
    </div>

    <c:import url="../../components/footer/" />
    <c:import url="../../components/modal/perfil.jsp" />

    <script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
