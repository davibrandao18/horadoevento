<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Perfil de ${usuario.userName} </title>
    <c:import url="../../components/links.html" />
    <link rel="stylesheet" href="../view/view.css">
</head>

<body class="bodyCover">
    <c:import url="../../components/navbar/full.jsp" />

    <div class="bodyContent">

        <div class="container container-dados">
            <div class="row">
                <div class="col-lg-6 col-md-3">
                    <img draggable="false" class="foto-fix" src="/horadoevento/assets/icons/helperCabeca.svg" />
                </div>
                <div class="col-lg-6 col-md-3 text-fix">
                    <div class="row">
                        <h3>${usuario.getNome()}</h3>
                    </div>
                    <div class="row">
                        <small>${usuario.email}</small>
                        <a href="${usuario.getLinkedin()}">LINKEDIN</a><%!//TODO icon linkedin /!\%>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div style="position: absolute; bottom: 0; width: 100%">
        <c:import url="../../components/footer/" />
    </div>

    <script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>
