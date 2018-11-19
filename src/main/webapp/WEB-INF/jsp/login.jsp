<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>
.error {

margin: 10px 0px;
padding:12px;
 color: #D8000C;
    background-color: #FFD2D2;
}
</style>
<meta charset="UTF-8">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></script>
  <script type="text/javascript">
$(document).ready(function(){
	$('[data-toggle="popover"]').popover({
		placement : 'bottom',
        trigger: 'hover'
    });
});
</script>
<title>Patient Login</title>
</head>
<body>

<form:form class="form-horizontal" action="loginin" modelAttribute="patient">
  <div class="form-group">
 
    <label class="control-label col-sm-2" for="uname" path="username">
    Username :
    </label>
    <br/>
    
  
   
    <br/>
    <div class="col-sm-4">
      <form:input type="text" class="form-control" id="uname" path="username" placeholder="Enter username" data-toggle="popover" title="Username" data-content="Enter your username here"/>
    </div>
     <br/><br/>
     
    &nbsp; <form:errors path="username" class="error" for="uname"/>
     
     
    
 
  </div>
  </div>
  
  <div class="form-group">
    <form:label class="control-label col-sm-2" for="pwd" path="password">Password:</form:label>
    <br/>
    <br/>
    <div class="col-sm-4"> 
      <form:input type="password" class="form-control" id="pwd" path="password" placeholder="Enter password"/>
    </div>
   <br/> <br/> <form:errors path="password" for="pwd" />
  </div>
  
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <form:button type="submit" class="btn btn-primary">Log in</form:button>
    </div>
  </div>
 
</form:form>

</body>
</html>
