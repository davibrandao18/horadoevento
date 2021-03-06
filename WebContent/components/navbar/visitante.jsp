<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="pos-f-t">
    <nav class="navbar navbar-dark theme-navbar">
        <div class="display-none-mobile col-md-4 d-flex justify-content-start" style="align-items: center;">
            <svg id="Component_2_1" data-name="Component 2 â€“ 1" xmlns="http://www.w3.org/2000/svg"
                xmlns:xlink="http://www.w3.org/1999/xlink" width="328" height="36" viewBox="0 0 328 36">
                <text id="HORA_DO_EVENTO" data-name="HORA DO EVENTO" transform="translate(0 31)" fill="#0d0d0d"
                    font-size="20" font-family="PressStart2P, 'Press Start 2P'" letter-spacing="0.011em">
                    <tspan x="0" y="0">HORA DO EVENTO</tspan>
                </text>
                <g id="Bitmap" transform="translate(292)">
                    <image id="Bitmap-2" data-name="Bitmap" width="36" height="36"
                        xlink:href="data:image/png;base64,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" />
                </g>
            </svg>
        </div>
        <div class="col-10 col-md-5 d-flex justify-relative-mobile">
            <form class="form-inline bg-light rounded p-0" action="/horadoevento/perfil/Perfil.do">
                <button class="btn btn-outline-light" type="submit" style="width:40px;">
                    <img src="/horadoevento/assets/icons/search.svg">
                </button>
                <input type='hidden' value='usuario' name='entidade'> <!-- CAMPO FIXO TEMPORARIAMENTE SÓ PARA TESTES -->
                <input class="form-control bg-light border-light" type="search" aria-label="Search" name="username"
                    type="text" />
            </form>
        </div>
        <div class="col-2 col-md-3 d-flex justify-content-end" style="align-items: center;">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menuOpcoes"
                aria-controls="menuOpcoes" aria-expanded="false" aria-label="Alterna navegação"
                style="border: none!important;">
                <span><img src="/horadoevento/assets/icons/user.svg"></span>
            </button>
        </div>
    </nav>
</div>


<div class="collapse " id="menuOpcoes">
    <div class="collapseNavMenu p-4 d-flex justify-content-end">
        <ul style="list-style: none;">
            <li class="text-right"><a href="/horadoevento/login/" style="text-decoration: none;">Login</a></li>
                <li class="text-right">
                    <i class="fa fa-sun-o" aria-hidden="true"></i>
                    <label id="switch" class="switch">
                        <input type="checkbox" onchange="toggleTheme()" id="slider">
                        <span class="slider round"></span>
                    </label>
                    <i class="fa fa-moon-o" aria-hidden="true"></i>
                </li>
                <li class="text-right"><a href="/horadoevento/cadastro/" style="text-decoration: none;">Cadastre-se</a>
                </li>
        </ul>
    </div>
</div>


<script>
    //função que define o tema recebido por parâmetro
    function setTheme(tema) {
        localStorage.setItem('theme', tema);
        document.documentElement.className = tema;
    }

    // função que alterna entre tema light e dark
    function toggleTheme() {
        if (localStorage.getItem('theme') === 'theme-dark') {
            setTheme('theme-light');
        } else {
            setTheme('theme-dark');
        }
    }

    // Função que define um tema de acordo com o estado inicial
    (function () {
        if (localStorage.getItem('theme') === 'theme-light') {
            setTheme('theme-light');
            document.getElementById('slider').checked = false;
        } else {
            setTheme('theme-dark');
            document.getElementById('slider').checked = true;
        }
    })();
</script>
