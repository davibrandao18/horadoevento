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
    	
    	<div class="container-fluid p-4">
			<form action="./Login.do" method="post">
	    		<div class="row justify-content-center">
	    			<div class="col-6 text-right">
	    				<div class="form-group form-check">
				  			<input class="form-check-input" type="radio" name="entidade" id="usuario" value="usuario" checked>
				  			<label class="label-radio" for="usuario"> Usuário </label>
					  	</div>
					 </div>
					 <div class="col-6">
					  	<div class="form-group form-check">	
					  		<input class="form-check-input" type="radio" name="entidade" id="empresa" value="empresa">
					  		<label class="label-radio" for="empresa"> Empresa </label>
						</div>
	    			</div>
	    		</div>
	    		<div class="row justify-content-center">
	    			<div class="col-12 col-sm-10 col-md-6">
						<label for="username">Username</label>
	    			</div>
	    		</div>
	    		<div class="row justify-content-center">
	    			<div class="col-12 col-sm-10 col-md-6">
			    		<input type="text" class="user-field" name="username" id="username" required>
	    			</div>
	    		</div>
	  			<div class="row justify-content-center mt-3">
	    			<div class="col-12 col-sm-10 col-md-6">
						<label for="senha">Password</label>
	    			</div>
	    		</div>
	  			<div class="row justify-content-center">
	    			<div class="col-12 col-sm-10 col-md-6">
		    			<input type="password" class="password-field" name="senha" id="senha" required>
	    			</div>
	    		</div>
	    		<div class="row justify-content-center pt-3">
	    			<div class="col-12 col-sm-10 col-md-6">
	    				<div class="row">
	    					<div class="col-6">
	    						<a type="button" class="btn btn-light border-dark" href="/horadoevento/inicio/">
									<i class="fa fa-chevron-left"></i> Voltar
								</a>	
	    					</div>
	    					<div class="col-6" style="text-align: end;">
	    						<button type="submit" class="btn btn-light border-dark">
									Entrar <i class="fa fa-chevron-right"></i>
								</button>	
	    					</div>
	    				</div>
	    			</div>
	    		</div>
	    	</form>
    	</div>
    	
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>