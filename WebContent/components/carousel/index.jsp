<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h5 class="text-center pb-2 pt-4">Suas proximas missões</h5>

<div class="row justify-content-center mb-4">
    <div class="col-12 col-md-10">
        <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <c:if test="${empty inscricoes}">
                    <div class="carousel-item active primary-card-hde carousel-hde" data-interval="10000">
                        <h4 class="text-center">Você ainda não se inscreveu em nenhum evento</h4>
                        <p>Embarque em novas aventuras, </p>
                    </div>
                </c:if>
                <c:if test="${not empty inscricoes[0]}">
                    <div class="carousel-item active primary-card-hde carousel-hde" data-interval="10000">
                        <h4>${inscricoes[0].evento.titulo}</h4>
                        <p>${inscricoes[0].evento.descricao}</p>
                        <p>${inscricoes[0].evento.dataHora}</p>
                    </div>
                </c:if>
                <c:if test="${not empty inscricoes[1]}">
                    <div class="carousel-item secondary-card-hde carousel-hde" data-interval="2000">
                        <h4>${inscricoes[1].evento.titulo}</h4>
                        <p>${inscricoes[1].evento.descricao}</p>
                        <p>${inscricoes[1].evento.dataHora}</p>
                    </div>
                </c:if>
                <c:if test="${not empty inscricoes[2]}">
                    <div class="carousel-item tertiary-card-hde carousel-hde">
                        <h4>${inscricoes[2].evento.titulo}</h4>
                        <p>${inscricoes[2].evento.descricao}</p>
                        <p>${inscricoes[2].evento.dataHora}</p>
                    </div>
                </c:if>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
</div>
