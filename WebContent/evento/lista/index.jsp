<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Eventos</title>
        <c:import url="../../components/links.html"/>
        <link rel="stylesheet" href="../view/view.css">
    </head>
    
    <body>
        <c:import url="../../components/navbar/full.jsp"/>
        
        <div class="bodyContent">
            <c:if test='${sessao_user == null}'>
                <h1>Você não está logado</h1>
                <a href="/horadoevento/inicio/">Voltar ao início</a>
            </c:if>
            <c:if test='${sessao_user != null}'>
            <div class="row">
                <div class="col-12 align-self-center">
                    <h3 style="text-align: center;">${sessao_user.nome}, aqui estão
                        seus Eventos:</h3>
                </div>
                <div class="col-10">
                    <div class="table-responsive col-md-12">
                        <table class="table table-striped">
                            <thead>
                                <th>Evento</th>
                                <th>Data</th>
                                <th class="actions">Ações</th>
                            </thead>
                            <tbody>
                                <c:if test="${not empty listaEventos}">
                                    <c:forEach var="evento" items="${listaEventos}">
                                        <tr>
                                            <td>${evento.titulo}</td>
                                            <td>${evento.dataHora}</td>
                                            <td class="actions">
	                                            <form action="/horadoevento/Evento.do" method="post">
	                                                <input type="hidden" name="id" value="${evento.id}"/>
													<button type="submit"
														class="btn btn-secondary btn-xs text-dark"
														name="action" value="visualizar">
														Visualizar
													</button>
													
													<button id="${evento.id}" type="submit"
														class="btn btn-warning btn-xs" value="${inscricao.id}"
														name="action" value="editar">
														Editar
													</button>
                                                
													<button id="${evento.id}" type="button"
														class="btn btn-danger btn-xs text-dark"
														data-toggle="modal" data-target="#delete-modal"
														data-evento="${evento.id}">Excluir
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
        
        <c:import url="../../components/footer/"/>

        <script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
        <script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
        
    </body>
</html>