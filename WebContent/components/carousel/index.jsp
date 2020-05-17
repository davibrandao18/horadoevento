<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h5 class="text-center pb-2 pt-4">Missões mais populares</h5>

<div class="row justify-content-center mb-4">
	<div class="col-12 col-md-10">
		<div id="carouselExampleInterval" class="carousel slide w-100" data-ride="carousel">
		  	<div class="carousel-inner">
		    	<div class="carousel-item active primary-card-hde carousel-hde" data-interval="10000">
		      		<h4>The Last Of Us</h4>
					<p>Descrição [...]</p>
					<p>[data] | [hora]</p>
		    	</div>
			    <div class="carousel-item secondary-card-hde carousel-hde" data-interval="2000">
			      	<h4>Smash Bros</h4>
					<p>Descrição [...]</p>
					<p>[data] | [hora]</p>
			    </div>
			    <div class="carousel-item tertiary-card-hde carousel-hde">
			      	<h4>Tomb Raider</h4>
					<p>Descrição [...]</p>
					<p>[data] | [hora]</p>
			    </div>
		  	</div>
		  	<a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-slide="prev">
		    	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    	<span class="sr-only">Previous</span>
		  	</a>
		  	<a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-slide="next">
		    	<span class="carousel-control-next-icon" aria-hidden="true"></span>
		    	<span class="sr-only">Next</span>
		  	</a>
		</div>
	</div>
</div>