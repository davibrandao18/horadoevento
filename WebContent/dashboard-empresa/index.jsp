<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
    	<title>Dashboard</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <link rel="shortcut icon" href="/horadoevento/assets/icons/HDE_transparent.png">
        
        <!-- chartjs -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.min.js" integrity="sha256-TQq84xX6vkwR0Qs1qH5ADkP+MvH0W+9E7TdHJsoIQiM=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.css" integrity="sha256-aa0xaJgmK/X74WM224KMQeNQC2xYKwlAt08oZqjeF0E=" crossorigin="anonymous" />
        
        
        <link rel="stylesheet" href="../generalStyles.css">
        <link rel="stylesheet" href="./member.css">
        <link rel="stylesheet" href="../components/chartjs/chartjs.min.css">
    </head>
    
    <body>
    	<div class="bodyContent">
			<c:import url="../../components/navbar/full.jsp"/>
		    	
    		<h1>Saudações, ${sessao_user.nome}</h1>
    		
    		<canvas id="primeiroGrafico"></canvas>
    		
    		<script>
	    		let primeiroGrafico = document.getElementById('primeiroGrafico').getContext('2d');
	    		
	    		let chart = new Chart(primeiroGrafico, {
	    		    type: 'line',
	    		                        
	    		    data: {
	    		        labels: ['2000', '2001', '2002', '2003', '2004', '2005'],
	    		                    
	    		        datasets: [
	    		            {
	    		                label: 'Crecimento Populacional',
	    		                data: [173448346, 175885229, 178276128, 180619108, 182911487, 185150806]
	    		            }
	    		        ]
	    		    }
	    		}
	    	</script>
		</div>
	</body>
</html>