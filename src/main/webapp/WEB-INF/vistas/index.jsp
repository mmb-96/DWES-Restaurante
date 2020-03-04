<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login - Pedidos Restaurante</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<form:form action="categoria" modelAttribute="restaurante">  
        Correo: <form:input type="email" path="correo" />         
        <br><br>  
        Clave: <form:input type="password" path="clave" />  
        <br><br>  
        <input type="submit" value="Submit" />      
    </form:form>
    <br>
    <p>${ msg }</p>
</body>
</html>