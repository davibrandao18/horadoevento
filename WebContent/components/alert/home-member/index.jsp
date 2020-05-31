<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:if test="${sessao_mensagem == null}">
	<marquee>Saudações, ${sessao_user.nome}, mantenha sempre seu perfil atualizado! 🤬</marquee>
</c:if>

<c:if test="${sessao_mensagem != null}">
	<marquee><c:out value ='${sessao_alert}'/></marquee>
</c:if>