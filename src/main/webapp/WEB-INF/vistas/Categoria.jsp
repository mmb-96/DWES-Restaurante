<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="org.iesjacaranda.dwes.restaurante.dto.RestaurenteDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categoria - Pedidos Restaurante</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<% RestaurenteDTO usuarioActual = (RestaurenteDTO) session.getAttribute("usuarioActual");%>
	<%= usuarioActual.getCorreo()%>

	<br>
	<br>
	<a href="categorias">Home</a>
	<a href="verCarrito">Ver carrito</a>
	<a href="cerrarSesion">Cerrar Sesión</a>
	<br>
	<br>
	 <ul>
		 <c:forEach items="${ categoria }" var="cat">
			<a href="obtenerProducto?id=${ cat.codCat }&nombre=${ cat.nombre }&descripcion=${cat.descripcion}"><li>${ cat.nombre }</li></a>
		 </c:forEach>
	  </ul>
	  <br>
</body>
</html>