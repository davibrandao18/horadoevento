<%@ page language="java" contentType="text/html; charset=iso-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <title>Hora do LOGIN</title>
        <link rel="shortcut icon" href="/horadoevento/assets/icons/HDE_transparent.png" />
        <link rel="stylesheet" href="/horadoevento/generalStyles.css">
        <link rel="stylesheet" href="./login.css">
    </head>
    
    <body>
        <div class="cover">
            <input type="button" value="Voltar" href="/begin/">
            <div>

                <form action="Login.do" method="post">
                    <p>Selecione o seu perfil:</p>
                    <input type="radio" id="empresa" name="entidade" value="empresa">
                    <label for="empresa">Empresa</label><br>
                    <input type="radio" id="usuario" name="entidade" value="usuario">
                    <label for="usuario">Usu�rio</label><br>

                    <input name="username" placeholder="username" type="text">
                    <input name="senha" placeholder="senha" type="password">
                    <div>
                        <button type="submit">Login</button>
                    </div>
                </form>
            </div>
        </div>
        
    </body>
</html>