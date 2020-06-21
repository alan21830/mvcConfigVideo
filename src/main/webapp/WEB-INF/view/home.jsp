<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
 <head>
<!-- Required meta tags -->
<style type="text/css">
</style>
<title>covid 19 realtime </title>
<meta name="google-site-verification" content="WJ77t9ffeOPEXeavZ2bQfCtAGAKw3OdJh7MS8rSilUg" />
<meta name="description" content="covid italia casi oggi covid  covid19realtime ">
<link rel="author" href="https://www.facebook.com/search/top/?q=Alessandro%20La%20Selva">

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
	
 <link rel="stylesheet"
  href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> 
</head>

<body>

<%-- 
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo01"
			aria-controls="navbarTogglerDemo01" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">

			<a class="navbar-brand" href="#"> </a>
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link" href="./">
						<span class="oi oi-home" title="home" aria-hidden="true"></span> <span
						class="sr-only">(current)</span>
				</a></li>


			</ul>

			<!-- Search Box 
    			 
    					<form:form class="form-inline my-2 my-lg-0" id="search" role="search" method="GET" action=" ">
		      				<input type="text" onClick="this.select();"  class="form-control mr-sm-2" name="filter"  placeholder="Cerca  ">
		      				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cerca</button>
		    			</form:form>
    			 
    			
    			 -->

		</div>
	</nav>
	
	--%>
	<div  style="background-image:url('top.jpg');background-repeat: no-repeat;  background-size: 100% 100%;" class="p-3 mb-2 bg-danger text-white text-center">
		<h1 class="text-danger">COVID-19 Country</h4>
		<p>
			<a href="#" class="text-white bg-dark">Thanks Api from https://github.com/novelcovid/api </a> </p>
<p><a href="#" class="text-white bg-dark">Email: a0000@live.it</a></p>
		</p>
		<div>
			<h3><a href="#" class="text-white bg-dark">
				Totale casi : ${totale}</a>
				</h3>
				<h3><a href="#" class="text-white bg-dark">
					Totale decessi : ${decessi }</a>
					</h3><a href="#" class="text-white bg-dark">
					<h3>Totale casi oggi : ${casiOggi}</a></h3>
		</div>
	</div>
<style>
.tableFixHead          { overflow-y: auto; height: 50%; }
.tableFixHead thead th { position: sticky; top: 0; }

/* Just common table stuff. Really. */
table  { border-collapse: collapse; width: 100%;  >
th, td { padding: 8px 16px; }
th     { background:#eee; }
</style>
<div class ="tableFixHead">
    <table class="table table-striped ">

		<thead >
			 
			<th>PAESE</th>
			<th>CASI</th>
			<th>CASI OGGI</th>
			<th>MORTI</th>
			<th>MORTI OGGI</th>
			<th>RICOVERI</th>
			<th>ATTIVI</th>
			<th>CRITICI OGGI</th>
		</thead>
		<tbody >
			<c:forEach items="${listacovid}" var="user">
			 <c:choose>
				<c:when test="${user.country.equals('Italy')}">
         			<tr class="table-danger">
         			
         			<td class="text-danger"><a href="http://www.salute.gov.it/portale/home.html">${user.country}</a></td>
					<td>${user.cases}</td>
					<td class="text-success">${user.todayCases}
					<td>${user.deaths}</td>
					<td>${user.todayDeaths}</td>
					<td>${user.recovered}</td>
					<td>${user.active}</td>
					<td>${user.critical}</td>
         			
         			
         			
				</c:when>
				<c:otherwise>
			   		<tr>
			   		 <td class="text-danger">${user.country}</td>
					<td>${user.cases}</td>
					<td class="text-success">${user.todayCases}
					<td>${user.deaths}</td>
					<td>${user.todayDeaths}</td>
					<td>${user.recovered}</td>
					<td>${user.active}</td>
					<td>${user.critical}</td>
				</c:otherwise>
		 </c:choose>
		           


					<!-- 	<td><a href="modifica/${user.id} ">modifica</a> </td>
		<td><a href="elimina?id=${user.id} ">elimina</a> </td>
		-->
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<!-- <a href ="inserisci"><button type="button" class="btn btn-outline-primary">Inserisci un messaggio</button></a> -->

	<div class="chart-container"
		style="position: relative; height: 100%; width:100%">
		<canvas id="myChartDate"></canvas>
	</div>
	 
<!--  	<div class="chart-container"
		style="position: relative; height: 100%; width: 100%;">
		<canvas id="myChart" width="90%" height="100%"></canvas>
	</div>
-->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.6/Chart.bundle.min.js"></script>
	<script>
var ctx = document.getElementById('myChartDate').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: [${dataLine}],
        datasets: [{
            label: 'Incremento casi in Italia giorno per giorno',
            data: [${labelLine}],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
</script>
 
<hr>
<br>
<div class ="tableFixHead">
<table class="table table-striped table-dark ">

		<thead >
			 
			<th>GIORNO</th>
			<th>INCREMENTO CASI</th>
			 
		</thead>
		<tbody >
			<c:forEach items="${listStoricocasis}" var="l">
			<tr>
			<td class="text-danger">${l.data}</td>
			<td>${l.casiOggi}</td>
			<tr>
			</c:forEach>
			
			</tbody>
			
</table>
			</div>
			
	 

<div class="jumbotron jumbotron-billboard">
	<div class="img"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2>Inserisci nuovi casi giornalieri</h2>
				
			</div>
		</div>
	</div>
</div>
<section class="container">
	<div class="portlet light bordered">
		 <div class="portlet-title">
		 	 
             
		 </div>
		<div class="portlet-body form">
				<form:form   modelAttribute="storicocasi"  method="post"  action="inserisci">
				
				<div class="form-body">
				
					<div class="form-group">
						<form:label path="casiOggi">Numeri casi</form:label>
						<form:input  type="text" id="ncasi"  class="form-control" placeholder="Numero incremento casi" path="casiOggi" />
						 
						
					</div>
				  
				<div class="form-body">
				
					<div class="form-group">
					 
						 <form:label path="data">Data</form:label>
						<form:input type="date" id="ndate"  class="form-control"  path="data" />
						 
						
					</div>
 
					
				</div>
			 
				
				<hr class="line-form">
				
				<div class="form-actions">
					<input type="submit" id="btnAdd" class="btn btn-primary form-buttons" value ="inserisci" />
					 
						 
					
				</div>
			
				</form:form>
			</div>
	</div>
</section>
			
			
			

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"
		integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4"
		crossorigin="anonymous"></script>


 
</body>
</html>
