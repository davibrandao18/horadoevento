<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <title>Perfil ${empresa.getNome()} </title>
    <c:import url="../../components/links.html" />
    <link rel="stylesheet" href="../view/view.css" />
</head>

<body class="bodyCover">
    <c:import url="../../components/navbar/full.jsp" />
    <div class="bodyContent">
        <c:if test='${sessao_user == null}'>
            <c:import url=""/>
        </c:if>
        <c:if test='${sessao_user != null}'>
            <div class="container container-dados">
                <div class="row">
                    <div class="col-lg-6 col-md-3">
                        <img class="img-perfil-hde foto-fix" src="/horadoevento/assets/icons/empresas.svg" />
                    </div>
                    <div class="col-lg-6 col-md-3 text-fix">
                        <div class="row">
                            <h3>${empresa.getNome()}</h3>
                        </div>
                        <div class="row">
                            <small>${empresa.cidade}, </small>
                            <small>${empresa.estado}</small>
                            <a href="${empresa.getLinkedin()}">LINKEDIN</a><%!//TODO icon linkedin /!\%>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row eventos-row">
                <div class="col-12">
                    <h5>Proximos eventos</h5>
                    <div class="row">
                        <div class="col-6 col-md-3 mt-2">
                            <button class="card-hde primary-card yellow-card">
                                FUNDAMENTOS DO DESIGN THINKING <br> <br> <small>02/10/2020 | 13:00</small>
                            </button>
                        </div>
                        <div class="col-6 col-md-3 mt-2">
                            <button class="card-hde primary-card yellow-card">
                                METODO GARAGE NO DESENVOLVIMENTO DE SOFTWARES <br> <br> <small>20/07/2020 |
                                    10:45</small>
                            </button>
                        </div>
                        <div class="col-6 col-md-3 mt-2">
                            <button class="card-hde primary-card yellow-card">
                                PUNK GAMIFICATION <br> <br> <small>13/05/2021 | 15:00</small>
                            </button>
                        </div>
                        <div class="col-6 col-md-3 mt-2">
                            <button class="card-hde primary-card yellow-card">
                                TRANSFORMCAO AGILE <br> <br> <small>22/06/2020 | 20:30</small>
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row eventos-row">
                <div class="col-12">
                    <h5>Ultimos eventos</h5>
                    <div class="row">
                        <div class="col-6 col-md-3 mt-2">
                            <button class="card-hde primary-card pink-card">
                                WATSON HEALTH <br> <br> <small>02/10/2019 | 13:00</small>
                            </button>
                        </div>
                        <div class="col-6 col-md-3 mt-2">
                            <button class="card-hde primary-card pink-card">
                                AGILE LEADERSHIP <br> <br> <small>20/07/2019 | 10:45</small>
                            </button>
                        </div>
                        <div class="col-6 col-md-3 mt-2">
                            <button class="card-hde primary-card pink-card">
                                WATSON E A REVOLUCAO DA IA <br> <br> <small>13/05/2020 | 15:00</small>
                            </button>
                        </div>
                    </div>
                </div>
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
