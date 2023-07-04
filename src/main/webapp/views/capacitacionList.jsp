<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenidos - Lista de Capacitaciones</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/81a2ed02b0.js" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
	<jsp:include page="./header.jsp"></jsp:include>

	<div class="container ">
		<h2>Lista de Capacitaciones</h2>
		<a href="${pageContext.request.contextPath}/capacitacion?op=create"><button class="btn btn-dark">Crear capacitación</button></a>	
	</div>
	<div class = "col pt-4"></div>
	<table class="table pt-4">
		<thead class="table-dark pt-4">
			<tr>
				<th>Id Capacitacion</th>
				<th>Nombre</th>
				<th>Detalle</th>
				<th>Fecha</th>
				<th>Hora</th>
				<th>Lugar</th>
				<th>Duración</th>
				<th>Cantidad</th>
				<th>Id Cliente</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="capacitacion" items="${listaCapacitaciones}">
				<tr>
					<td><c:out value="${capacitacion.getId()}"/></td>
					<td><c:out value="${capacitacion.getNombre()}"/></td>
					<td><c:out value="${capacitacion.getDetalle()}"/></td>
					<td><c:out value="${capacitacion.getFecha()}"/></td>
					<td><c:out value="${capacitacion.getHora()}"/></td>
					<td><c:out value="${capacitacion.getLugar()}"/></td>
					<td><c:out value="${capacitacion.getDuracion()}"/></td>
					<td><c:out value="${capacitacion.getCantidad()}"/></td>
					<td><c:out value="${capacitacion.getClienteId()}"></c:out></td>
					<td>
						<a href="${pageContext.request.contextPath}/capacitacion?id=${capacitacion.getId()}&op=readOne"><i class="fa-solid fa-eye"></i></a>
						<a href="${pageContext.request.contextPath}/capacitacion?id=${capacitacion.getId()}&op=edit"><i class="fa-solid fa-pen-to-square"></i></a>
						<a href="${pageContext.request.contextPath}/capacitacion?id=${capacitacion.getId()}&op=delete"><i class="fa-solid fa-trash"></i></a>
					</td>				
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<jsp:include page="./footer.jsp"></jsp:include>
	</div>
</body>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</html>