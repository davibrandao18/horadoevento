// função que define o tema recebido por parâmetro
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
    if (localStorage.getItem('theme') === 'theme-dark') {
        setTheme('theme-dark');
        document.getElementById('slider').checked = false;
    } else {
        setTheme('theme-light');
      document.getElementById('slider').checked = true;
    }
})();