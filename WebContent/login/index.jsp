<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<%!//TODO recuperação de senha com base no CPF, email e username %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <title>Hora do login</title>
        <link rel="shortcut icon" href="/horadoevento/assets/icons/HDE_transparent.png" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="/horadoevento/components/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/horadoevento/generalStyles.css">
        <link rel="stylesheet" href="./login.css">
    </head>
    
    <body>
    	<jsp:include page="/components/navbar/slim.html" flush="false" />
    	
    	<%!//TODO condição para exibir 'alert' %>
    	
    	<div class="container p-4">
			<form action="./Login.do" method="post">
	    		<div class="row justify-content-center">
	    			<div class="col-6 text-right">
	    				<div class="form-group form-check">
				  			<input class="form-check-input" type="radio" name="entidade" id="usuario" value="usuario" checked>
				  			<label class="form-check-label" for="usuario"> Usuário </label>
					  	</div>
					 </div>
					 <div class="col-6">
					  	<div class="form-group form-check">	
					  		<input class="form-check-input" type="radio" name="entidade" id="empresa" value="empresa">
					  		<label class="form-check-label" for="empresa"> Empresa </label>
						</div>
	    			</div>
	    		</div>
	    		<div class="row justify-content-center">
	    			<div class="col-6">
	    				<div class="form-group">
							<label for="username">Username</label>
			    			<input type="text" class="form-control bginput-hde" name="username" id="username">
						</div>
	    			</div>
	    		</div>
	  			<div class="row justify-content-center">
	    			<div class="col-6">
	    				<div class="form-group">
							<label for="senha">Password</label>
			    			<input type="password" class="form-control bginput-hde" name="senha" id="senha">
						</div>
	    			</div>
	    		</div>
	    		<div class="row justify-content-center">
	    			<div class="col-6">
	    				<nav class="navbar">
				  			<a type="button" class="btn btn-light border-dark" href="/horadoevento/inicio/">
								<i class="fa fa-chevron-left"></i> Voltar
							</a>
					  		<button type="submit" class="btn btn-light border-dark">
								Entrar <i class="fa fa-chevron-right"></i>
							</button>
						</nav>
	    			</div>
	    		</div>
				
	    	</form>
    	</div>
    	
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>