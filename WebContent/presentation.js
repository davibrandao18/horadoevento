//variável de controle de estado:
localStorage.setItem('pessoa', 'pf')

//acao de clique no botao da empresa:
function alteraPessoa() {
		let btnHelper = document.getElementById('btnHelper');
		let txtHelper = document.getElementById('textoHelper');
		let txtPrincipal = document.getElementById('textoPrincipal');
		console.log(txtHelper.value);
		
		txtHelper.innerHTML="teste";
		console.log(txtHelper.value);
	}