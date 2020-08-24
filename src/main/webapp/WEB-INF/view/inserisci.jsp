<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <html lang="en">
   <%@ taglib prefix="c"  uri ="http://java.sun.com/jsp/jstl/core"%>
  <head>
    <!-- Required meta tags -->
    
<meta name="google-site-verification" content="WJ77t9ffeOPEXeavZ2bQfCtAGAKw3OdJh7MS8rSilUg" />
   <meta name="description" content="single roma ">
         
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" 
		integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    

    <title>Indice</title>
  </head>
 
  <body>
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
    	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
  		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
  		
  			 <a class="navbar-brand" href="#">Single Roma</a>
  			     <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      				<li class="nav-item active">
        				<a class="nav-link" href="./">
        					<span class="oi oi-home" title="home" aria-hidden="true"></span>
        					Home 
        					<span class="sr-only">(current)</span>
        				</a>
      				</li>
      			 
      				 
    			</ul>
    			
    			<!-- Search Box -->
    			 
    					<form:form class="form-inline my-2 my-lg-0" id="search" role="search" method="GET" action="/alphashop/articoli/search">
		      				<input type="text" onClick="this.select();"  class="form-control mr-sm-2" name="filter" value="${filter}" placeholder="Cerca Articoli">
		      				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cerca</button>
		    			</form:form>
    			 
    			
    			 
    		 
  		</div>
    </nav> 
     <div class="p-3 mb-2 bg-danger text-white">
		<h4>Single Message e'</h4>
		<p><a href="#" class="text-white bg-dark">Un Sito per scambio di messaggi</a></p>
		</div>

 
<form:form modelAttribute="utente" action="inserisciUtente" method="post">
<div class="form-group">
    <form:label path="username">USERNAME</form:label>
    <form:input type="text" class="form-control" id="username" path="username" />
   </div>

  <div class="form-group">
    <form:label path="password">MESSAGGIO</form:label>
    <form:textarea class="form-control" id="password" path="password" />
  </div>
  <div class="form-group">
    <form:label path="qty">ETA'</form:label>
    <form:input type="text" class="form-control" id="qty" path="qty"/>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>


</form:form>


<footer class="footer text-xs-center">
	<p class="text-muted">
		<small>&copy; 2019 by A.L.S. Inc.</small>
	</p>
	<p class="text-muted">
		<a href="#"><small>Termini &amp; Condizioni</small> </a>
	</p>
	 
</footer>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
  </body>
</html>