<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <title>Perfil de ${sessao_user.userName}</title>
    <c:import url="../../components/links.html" />
    <link rel="stylesheet" href="../perfil.css">
</head>

<body class="bodyCover">
    <c:import url="../../components/navbar/full.jsp" />
    <c:set var="path" value="${sessao_user.foto.getAbsolutePath()}" />

    <div>
        <c:if test='${sessao_user == null}'>
            <c:import url="../../components/naoLogadoMensagem/"/>
        </c:if>
        <c:if test='${sessao_user != null}'>
            <div class="row pt-4">
                <div class="col-6" style="text-align:end;">
                    <c:if test="${sessao_user.getFoto() != null}">
                        <img class="img-perfil-hde"
                            src="/horadoevento/ImageResponse.do?file=${fn:replace(path, '\\', '/')}">
                    </c:if>
                    <c:if test="${sessao_user.getFoto() == null}">
                        <img class="foto-fix" src="/horadoevento/assets/icons/helperCabeca.svg" />
                    </c:if>
                </div>
                <div class="col-6 justify-content-start">
                    <form action="/horadoevento/perfil/UploadArquivo.do" method="post" enctype="multipart/form-data"
                        style="display: flex;">
                        <input type='hidden' value='empresa' name='entidade'>
                        <div class="divInputFile">
                            <input type="file" size="50" id="file" name="arquivo" class="inputFile" />
                            <label for="file" class="labelFile">
                                <img width="30px" src="/horadoevento/assets/logo/upload.svg" />
                            </label>
                        </div>
                        <input type="submit" value="Enviar" class="btnSendPhoto" />
                    </form>
                </div>
            </div>

            <div class="cover">
                <form action="../Atualizar.do" method="post">
                    <div class="row">
                        <div class="col-6 tudo-esquerda">
                            <h5 class="text-esquerda">Nome:</h5>
                            <input name="nome" value="${sessao_user.nome}" type="text" class="items-esquerda"> <br>
                            <h5 class="text-esquerda">UserName:</h5>
                            <input name="username" value="${sessao_user.userName}" type="text" readonly disabled
                                class="username-wrapper"> <br>
                            <h5 class="text-esquerda">Senha:</h5>
                            <input name="senha" value="${sessao_user.senha}" type="password" class="items-esquerda">
                            <br>
                            <h5 class="text-esquerda">CNPJ:</h5>
                            <input name="cpf" value="${sessao_user.cnpj}" type="text" readonly disabled
                                class="username-wrapper"> <br>
                        </div>
                        <div class="col-6 tudo-direita">
                            <h5 class="text-direita">E-mail:</h5>
                            <input name="email" value="${sessao_user.email}" type="text" class="items-direita"> <br>
                            <h5 class="text-direita">Linkedin:</h5>
                            <input name="linkedin" value="${sessao_user.linkedin}" type="text" class="items-direita">
                            <br>
                            <input type='hidden' value='empresa' name='entidade'>
                            <input type='hidden' value='${sessao_user.pais }' name='pais'>
                            <h5 class="text-direita">Cidade:</h5>
                            <input name="cidade" value="${sessao_user.cidade}" type="text" class="items-direita"> <br>
                            <h5 class="text-direita">Estado:</h5>
                            <input name="estado" value="${sessao_user.estado}" type="text" class="items-direita"> <br>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-3" style="text-align: end; position: relative; left: 110px; width: 200px;">
                            <button type="submit" class="btnUpdate">Atualizar dados</button>
                        </div>
                        <div class="col-3" style="text-align: start; position: relative; left: 190px;">
                            <button type="button" onclick="history.go(-1)"naruto  class="btnCancel">Cancelar</button>
                        </div>
                        <div class="col-3">
                            <button type="button" style="text-align: center;" class="btnDelete" data-toggle="modal"
                                data-target="#modalExcluirEmpresa">Excluir perfil</button>
                        </div>
                    </div>
                </form>
                <form action="IniciarCadastroEvento.do" method="post">
                    <button type="submit" class="btnNewEvento">Novo evento</button>
                </form>
        </c:if>
    </div>
         <div style="position: absolute; bottom: 0; width: 100%;">
                 <c:import url="../../components/footer/" />
        </div>
    <c:import url="../../components/modal/perfilEmpresa.jsp" />

    <script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
