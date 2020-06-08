<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<nav class="navbar navbar-dark bg-hde pt-3">
    <div class="col text-center">
        <button class="btn-search-page" onclick="handleSearchResult('usuario')">
            <img draggable="false" src="/horadoevento/assets/icons/user.svg" />
        </button>
        <button class="btn-search-page" onclick="handleSearchResult('empresa')">
            <img draggable="false" src="/horadoevento/assets/icons/empresas.svg" />
        </button>
        <button class="btn-search-page" onclick="handleSearchResult('evento')">
            <img draggable="false" src="/horadoevento/assets/icons/calendario-resultados.svg" />
        </button>
    </div>
</nav>
