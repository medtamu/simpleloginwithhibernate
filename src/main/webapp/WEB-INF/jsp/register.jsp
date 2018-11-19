<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
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
body {
background-image : linear-gradient(yellow, white);
height : 800px;
}
</style>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></script>
  
<title>RegisterPatient</title>
</head>
<body>
<form:form class="form-horizontal" action="registering" modelAttribute="patient">
  <div class="form-group">
 <br/>
    <label class="control-label col-sm-2" for="uname" path="username">
    Username : </label>
    
    
  
   
    
    <div class="col-sm-4">
      <form:input type="text" class="form-control" id="uname" path="username" placeholder="Enter username"/>
    </div>
    
     
    <form:errors path="username" class="error" for="uname"/>
  </div>
 
  
   <div class="form-group">
    <form:label class="control-label col-sm-2" for="firstname" path="firstname">First name:</form:label>
    
    <div class="col-sm-4"> 
      <form:input type="text" class="form-control" id="firstname" path="firstname" placeholder="Enter firstname"/>
    </div>
  
  </div>
  
  
   <div class="form-group">
    <form:label class="control-label col-sm-2" for="lastname" path="phone">Last name:</form:label>
    
    <div class="col-sm-4"> 
      <form:input type="text" class="form-control" id="lastname" path="lastname" placeholder="Enter last name"/>
    </div>
  
  </div>
  
  <div class="form-group">
    <form:label class="control-label col-sm-2" for="pwd" path="password">Password:</form:label>
    
    <div class="col-sm-4"> 
      <form:input type="password" class="form-control" id="pwd" path="password" placeholder="Enter password"/>
    </div>
  <form:errors path="password" class ="error" for ="dob" />
  </div>
  
   <div class="form-group">
    <form:label class="control-label col-sm-2" for="dob" path="dob">Dob:</form:label>
    
    <div class="col-sm-4"> 
      <form:input type="date" class="form-control" id="dob" path="dob" placeholder="Enter dob"/>
    </div>
   <form:errors path="dob" class="error" for="dob"/>
  </div>
  
  <div class="form-group">
    <form:label class="control-label col-sm-2" for="ssn" path="ssn">SSN:</form:label>
    
    <div class="col-sm-4"> 
      <form:input type="text" class="form-control" id="ssn" path="ssn" placeholder="SSN"/>
    </div>
  
  </div>
  
 <div class="form-group">
    <form:label class="control-label col-sm-2" for="phone" path="phone">Phone:</form:label>
    
    <div class="col-sm-4"> 
      <form:input type="number" class="form-control" id="phone" path="phone" placeholder="Enter phone"/>
    </div>
  
  </div>

 <div class="form-group">
    <form:label class="control-label col-sm-2" for="email" path="email">Email:</form:label>
    
    <div class="col-sm-4"> 
      <form:input type="text" class="form-control" id="email" path="email" placeholder="Enter email"/>
    </div>
 
  <span data-for="email"> <form:errors path="email" class="error"  /> </span>
  </div>


 <div class="form-group">
    <form:label class="control-label col-sm-2" for="address" path="address">Address:</form:label>
    
    <div class="col-sm-4"> 
      <form:input type="text" class="form-control" id="address" path="address" placeholder="Enter address"/>
    </div>
  
  </div>

 <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <form:button type="submit" class="btn btn-primary" >Submit</form:button>
    </div>
  </div>
 
</form:form>

</body>
</html>