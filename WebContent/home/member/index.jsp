<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <title>Hora do Evento</title>
    <c:import url="../../components/links.html" />
    <link rel="stylesheet" href="../home.css">
</head>

<body>
    <c:import url="../../components/navbar/full.jsp" />

    <div class="bodyCover">
        <c:if test='${sessao_user == null}'>
            <h1>Você não está logado</h1>
            <a href="/horadoevento/inicio/">Voltar ao início</a>
        </c:if>

        <c:if test='${sessao_user != null}'>
            <c:import url="../../components/marquee/homepage.jsp" />
            <c:import url="../../components/carousel/" />

            <div class="container">
                <h5 class="text-center">Missões que combinam com você</h5>

                <div class="row">
                    <div class="col-6 col-md-3 mt-2">
                        <button class="card-hde primary-card yellow-card">
                            EVENTO W <br> <br> <small>[data] | [hora]</small>
                        </button>
                    </div>
                    <div class="col-6 col-md-3 mt-2">
                        <button class="card-hde primary-card yellow-card">
                            EVENTO X <br> <br> <small>[data] | [hora]</small>
                        </button>
                    </div>
                    <div class="col-6 col-md-3 mt-2">
                        <button class="card-hde primary-card yellow-card">
                            EVENTO Y <br> <br> <small>[data] | [hora]</small>
                        </button>
                    </div>
                    <div class="col-6 col-md-3 mt-2">
                        <button class="card-hde primary-card yellow-card">
                            EVENTO Z <br> <br> <small>[data] | [hora]</small>
                        </button>
                    </div>
                </div>

                <h5 class="text-center mt-4">Categorias</h5>

                <div class="row pb-4 justify-content-center">
                    <c:forEach var="tag" items="listaTagsTotais">
                        <div class="col-10 col-md-3 mt-2">
	                        <div class="row pb-4 justify-content-center">
	                            <div class="col-10 col-md-3 mt-2">
	                                <form action="/horadoevento/pesquisa/Pesquisa.do" method="get">
	                                    <input
	                                        type="hidden"
	                                        name="idTag"
	                                        value="${tag.id}">
	                                    <button
	                                        type="submit"
	                                        class="card-hde secondary-card text-center pink-card"
	                                        name="criterio"
	                                        value="tag">
	                                        ${tagt.nome }
	                                    </button>
	                                </form>
	                            </div>
	                        </div>
	                    </div>
                    </c:forEach>
                </div>
            </div>
        </c:if>
    </div>

    <c:import url="../../components/footer/" />

    <script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
