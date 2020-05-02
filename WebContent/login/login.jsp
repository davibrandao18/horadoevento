<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <title>Hora do LOGIN</title>
        <link rel="shortcut icon" href="/horadoevento/assets/icons/HDE_transparent.png" />
        <link rel="stylesheet" href="/horadoevento/generalStyles.css">
        <link rel="stylesheet" href="./login.css">
    </head>
    
    <body>
        <div class="cover">
            <input type="button" value="Voltar" onClick="history.go(-1)">
            <div>
                <img src="https://static3.tcdn.com.br/img/img_prod/460977/boneco_bb8_12_cm_star_wars_despertar_da_forca_ep_7_the_force_awekens_hasbro_31877_1_20180406124654.jpg" alt="iconeTeste">

                <form action="/Login.do" method="post">
                    <input name="username" placeholder="nome de usuário" type="text">
                    <input name="senha" placeholder="senha" type="password">
                    <div>
                        <button type="submit">Login</button>
                    </div>
                </form>
            </div>
        </div>
        
    </body>
</html>