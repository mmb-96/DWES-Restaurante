<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="org.iesjacaranda.dwes.restaurante.dto.RestaurenteDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Your reservation is confirmed successfully. Please, re-check the details.</p>   
	 <br>
	 <ul>
		 <c:forEach items="${ categoria }" var="cat">
			<a href="obtenerProducto?id=${ cat.codCat }&nombre=${ cat.nombre }&descripcion=${cat.descripcion}"><li>${ cat.nombre }</li></a>
		 </c:forEach>
	  </ul>
	  <br>  
	
	 <% RestaurenteDTO usuarioActual = (RestaurenteDTO) session.getAttribute("usuarioActual");%>
			
            Welcome <%= usuarioActual.getCorroe()%>
</body>
</html>