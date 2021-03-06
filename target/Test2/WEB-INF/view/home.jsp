<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


<title>Indice</title>
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
	<div class="p-3 mb-2 bg-danger text-white text-center">
		<h4>COVID-19 Country</h4>
		<p>
			<a href="#" class="text-white bg-dark"> <p>Api from: https://github.com/javieraviles/covidAPI 
<p>Email: a0000@live.it</p> </a>
		</p>
		<div>
			<h5>
				Totale casi : ${totale}
				</h4>
				<h5>
					Totale decessi : ${decessi }
					</h3>
					<h5>Totale casi oggi : ${casiOggi}</h5>
		</div>
	</div>
    <table class="table table-striped">

		<thead>
			 
			<th>PAESE</th>
			<th>CASI</th>
			<th>CASI OGGI</th>
			<th>MORTI</th>
			<th>MORTI OGGI</th>
			<th>RICOVERI</th>
			<th>ATTIVI</th>
			<th>CRITICI OGGI</th>
		</thead>
		<tbody>
			<c:forEach items="${listacovid}" var="user">
			 <c:choose>
				<c:when test="${user.country.equals('Italy')}">
         			<tr class="table-danger">
				</c:when>
				<c:otherwise>
			   		<tr>
				</c:otherwise>
		 </c:choose>
		            <td class="text-danger">${user.country}</td>
					<td>${user.cases}</td>
					<td class="text-success">${user.todayCases}
					<td>${user.deaths}</td>
					<td>${user.todayDeaths}</td>
					<td>${user.recovered}</td>
					<td>${user.active}</td>
					<td>${user.critical}</td>


					<!-- 	<td><a href="modifica/${user.id} ">modifica</a> </td>
		<td><a href="elimina?id=${user.id} ">elimina</a> </td>
		-->

				</tr>
			</c:forEach>
		</tbody>
	</table>
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
            label: 'Casi in Italia ',
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
 <%-- 
	<script>
var ctx = document.getElementById('myChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'pie',
    data: {
    	labels: [${label}],
        datasets: [{
            
            data: [${data}],
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
--%>



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
