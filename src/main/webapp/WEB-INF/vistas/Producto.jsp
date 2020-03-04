<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="org.iesjacaranda.dwes.restaurante.dto.RestaurenteDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos - Pedidos Restaurante</title>
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
	<h2>${categoria.nombre }</h2>

	<h2>${categoria.descripcion }</h2>

	  <div class="container text-center">
		<table>
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Peso</th>
					<th>Stock</th>
					<th>Comprar</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="prod" items="${ productos }">
					<form action="addProdCar" method="post">
						<input type="text" name="idCat" value="${categoria.codCat }" hidden="hidden">
						<input type="text" name="nombreNombreCat" value="${categoria.nombre }" readonly="readonly" hidden="hidden">
						<input type="text" name="descripcionCat" value="${categoria.descripcion }" readonly="readonly" hidden="hidden">
						<tr>
							<td><input type="text" name="id" value="${prod.codPro }" hidden="hidden"><input type="text" name="nombre" value="${prod.nombre }" readonly="readonly" hidden="hidden">${prod.nombre }</td>
							<td><input type="text" name="descripcion" value="${prod.descripcion }" readonly="readonly" hidden="hidden">${prod.descripcion }</td>
							<td><input type="text" name="peso" value="${prod.peso }" readonly="readonly" hidden="hidden">${prod.peso }</td>
							<td><input type="text" name="stock" value="${prod.stock }" readonly="readonly" hidden="hidden">${prod.stock }</td>
							<td><input type="number" name="unidad" min="1" max="${ prod.stock }"> 
							</td>
							<td><button class="btn btn-primary" type="submit" name="comprar">Comprar</button></td>
						</tr>
					</form>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>