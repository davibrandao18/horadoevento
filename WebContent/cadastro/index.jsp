<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<% 
	boolean v = (request.getAttribute("novo_login")== null)? true : false; 
	
	String color = (v)?"black" : "red";
	
	String radioUser = (request.getAttribute("radioUser")== null)? "checked" : "";
	String radioEmpr = (request.getAttribute("radioUser")== null)? "" : "checked"; 
	//TODO dados inserios anteriormente
%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <title>Hora do cadastro</title>
        <link rel="shortcut icon" href="/horadoevento/assets/icons/HDE_transparent.png" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="/horadoevento/components/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/horadoevento/generalStyles.css">
        <link rel="stylesheet" href="./cadastro.css">
    </head>
    
    <body>
    	<jsp:include page="/components/navbar/slim.html" flush="false" />
    	
    	<%!//TODO condição para exibir 'alert' %>
    	
    	<div class="container pt-4">

	        <div class="form-group form-check">
	  			<input class="form-check-input" type="radio" name="entidade" id="usuario" value="usuario" <%=radioUser%>>
	  			<label class="form-check-label" for="usuario"> Usuário </label>
		  	</div>	
		  	<div class="form-group form-check">	
		  		<input class="form-check-input" type="radio" name="entidade" id="empresa" value="empresa" <%=radioEmpr%>>
		  		<label class="form-check-label" for="empresa"> Empresa </label>
			</div>
	        
	        <form action="Cadastro.do" method="post" id="formCadastroUsuario">
            	<input type='hidden' value='usuario' name='entidade'>
					
				<div class="row">
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="username">Nome de usuário*</label>
	    					<input type="text" class="form-control bginput-hde" name="username" id="username" required>
						</div>
					</div>
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="nome">Nome*</label>
	    					<input type="text" class="form-control bginput-hde" name="nome" id="nome" required>
						</div>
					</div>
				</div>
					
				<div class="row">
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="email">E-mail*</label>
			    			<input type="text" class="form-control bginput-hde" name="email" id="email" required>
						</div>
					</div>
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="senha">Senha*</label>
			    			<input type="password" class="form-control bginput-hde" name="senha" id="senha" required>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="cpf">CPF*</label>
	    					<input type="text" class="form-control bginput-hde" name="cpf" id="cpf" required>
	    				</div>
					</div>
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="linkedin">Linkedin</label>
    						<input type="text" class="form-control bginput-hde" name="linkedin" id="linkedin">
    					</div>
					</div>
				</div>

				<nav class="navbar">
		  			<a type="button" class="btn btn-light border-dark" href="/horadoevento/inicio/">
						<i class="fa fa-chevron-left"></i> Voltar
					</a>
			  		<button type="submit" class="btn border-dark redButton">
						Enviar <i class="fa fa-chevron-right"></i>
					</button>
				</nav>
	        </form>
    	
    		<form action="Cadastro.do" method="post" id="formCadastroEmpresa">
            	<input type='hidden' value='empresa' name='entidade'>
					
				<div class="row">
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="username">Nome de usuário*</label>
	    					<input type="text" class="form-control bginput-hde" name="username" id="username" required>
						</div>
					</div>
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="nome">Empresa*</label>
	    					<input type="text" class="form-control bginput-hde" name="nome" id="nome" required>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-12 col-md-4">
						<div class="form-group">
							<label for="cidade">Cidade*</label>
	    					<input type="text" class="form-control bginput-hde" name="cidade" id="cidade" required>
						</div>
					</div>
					<div class="col-12 col-md-4">
						<div class="form-group">
							<label for="estado">Estado*</label>
	    					<input type="text" class="form-control bginput-hde" name="estado" id="estado" required>
						</div>
					</div>
					<div class="col-12 col-md-4">
						<div class="form-group">
							<label for="pais">País*</label>
	    					<input type="text" class="form-control bginput-hde" name="pais" id="pais" required>
						</div>
					</div>
				</div>
					
				<div class="row">
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="email">E-mail*</label>
			    			<input type="text" class="form-control bginput-hde" name="email" id="email" required>
						</div>
					</div>
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="senha">Senha*</label>
			    			<input type="password" class="form-control bginput-hde" name="senha" id="senha" required>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="cnpj">CNPJ*</label>
	    					<input type="text" class="form-control bginput-hde" name="cnpj" id="cnpj" required>
	    				</div>
					</div>
					<div class="col-12 col-md-6">
						<div class="form-group">
							<label for="linkedin">Linkedin</label>
    						<input type="text" class="form-control bginput-hde" name="linkedin" id="linkedin">
    					</div>
					</div>
				</div>

				<nav class="navbar">
		  			<a type="button" class="btn btn-light border-dark" href="/horadoevento/inicio/">
						<i class="fa fa-chevron-left"></i> Voltar
					</a>
			  		<button type="submit" class="btn border-dark redButton">
						Enviar <i class="fa fa-chevron-right"></i>
					</button>
				</nav>
	        </form>
    	</div>
    	
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="/horadoevento/components/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/horadoevento/cadastro/cadastro.js"></script>
    </body>
</html>