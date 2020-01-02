<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" 
		integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    
    <title>Inserisci</title>
  </head>


 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
 
<body>

 
<form:form modelAttribute="utente" action="/configMVC/modifica" method="post">
<div class="form-group">
    <form:label path="username">username</form:label>
    <form:input type="text" class="form-control" id="username" path="username" value="${user.username}"/>
   </div>

  <div class="form-group">
    <form:label path="password">Password</form:label>
    <form:input type="password" class="form-control" id="password" path="password" value="${user.password}" />
  </div>
  <div class="form-group">
    <form:label path="qty">Quantita'</form:label>
    <form:input type="text" class="form-control" id="qty" path="qty" value="${user.qty}"/>
  </div>
  
   <div class="form-group">
    
    <form:input type="hidden"   path="id" value="${user.id}"/>
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>


</form:form>



 
</body>
</html>