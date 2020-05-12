// método de alternância entre formulários na tela de login
$('input[name="entidade"]').change(function () {
	if ($('input[name="entidade"]:checked').val() === "usuario") {
		$('#formCadastroUsuario').show();
		$('#formCadastroEmpresa').hide();
	} else {
		$('#formCadastroEmpresa').show();
		$('#formCadastroUsuario').hide();
    }
});