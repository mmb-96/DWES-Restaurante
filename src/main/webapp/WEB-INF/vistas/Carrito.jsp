<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="org.iesjacaranda.dwes.restaurante.dto.RestaurenteDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito - Pedidos Restaurante</title>
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
					<th>Unidades</th>
					<th>Eliminar</th>
					<th></th>
					<th>Nueva Cantidad</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="car" items="${ calito }">
					<form action="delModProducto" method="post">
						<tr>
							<td><input type="text" name="id" value="${ car.codProd.codPro }" hidden="hidden"><input type="text" name="nombre" value="${ car.codProd.nombre }" readonly="readonly" hidden="hidden">${ car.codProd.nombre }</td>
							<td><input type="text" name="descripcion" value="${ car.codProd.descripcion }" readonly="readonly" hidden="hidden">${ car.codProd.descripcion }</td>
							<td><input type="text" name="peso" value="${ car.codProd.peso }" readonly="readonly" hidden="hidden">${ car.codProd.peso }</td>
							<td><input type="text" name="stock" value="${ car.codProd.stock }" readonly="readonly" hidden="hidden">${ car.codProd.stock }</td>
							<td><input type="text" name="unidadCar" value="${ car.unidades }" readonly="readonly" hidden="hidden">${ car.unidades }</td>
							<td><input type="number" name="unidad" min="1" max="${ car.unidades }"></td>
							<td><button class="btn btn-primary" name="accion" value="eliminar" type="submit">Eliminar</button></td>
							<td><input type="number" name="unidadNew" min="1" max="${ car.codProd.stock }"></td>
							<td><button class="btn btn-primary" name="accion" value="modificar" type="submit">Modificar</button></td>
							
						</tr>
					</form>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>
	<br>
	<a href="realiPedido">Realizar pedido</a>
</body>
</html>