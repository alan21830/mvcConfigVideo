<jsp:include page="header.jsp"></jsp:include>

 
<form:form modelAttribute="utente" action="/configMVC/modifica" method="post">
<div class="form-group">
    <form:label path="username">USERNAME</form:label>
    <form:input type="text" class="form-control" id="username" path="username" value="${user.username}"/>
   </div>

  <div class="form-group">
    <form:label path="password">MESSAGGIO</form:label>
    <form:textarea class="form-control" id="password" path="password" value="${user.password}" />
  </div>
  <div class="form-group">
    <form:label path="qty">ETA'</form:label>
    <form:input type="text" class="form-control" id="qty" path="qty" value="${user.qty}"/>
  </div>
  
   <div class="form-group">
    
    <form:input type="hidden"   path="id" value="${user.id}"/>
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>


</form:form>


  <jsp:include page="footer.jsp"></jsp:include>