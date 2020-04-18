//variável de controle de estado:
localStorage.setItem('pessoa', 'pf')

//acao de clique no botao da empresa:
function alteraPessoa(tipo) {
    localStorage.setItem('pessoa', tipo)
    console.log(localStorage.getItem('pessoa'))
}