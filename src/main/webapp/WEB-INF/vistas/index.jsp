<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login - Pedidos Restaurante</title>
</head>
<body>
<form:form action="submitForm" modelAttribute="restaurante">  
        Correo: <form:input path="corroe" />         
        <br><br>  
        Clave: <form:input path="clave" />  
        <br><br>  
        <input type="submit" value="Submit" />      
    </form:form>
    <p>${ msg }</p>
</body>
</html>