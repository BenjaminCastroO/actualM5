<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenidos - Lista de Visitas</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/81a2ed02b0.js" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
	<jsp:include page="./header.jsp"></jsp:include>

	<div class="container ">
		<h2>Lista de Visitas</h2>
		<a href="${pageContext.request.contextPath}/visita?op=create"><button class="btn btn-dark">Crear visita</button></a>	
	</div>
	<div class = "col pt-4"></div>
	<table class="table pt-4">
		<thead class="table-dark pt-4">
			<tr>
				<th>Id Visita</th>
				<th>Id Cliente</th>
				<th>Fecha</th>
				<th>Hora</th>
				<th>Lugar</th>
				<th>Realizado</th>
				<th>Detalle</th>
				<th>Id Profesional</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="visita" items="${listaVisitas}">
				<tr>
					<td><c:out value="${visita.getId()}"/></td>
					<td><c:out value="${visita.getClienteId()}"/></td>
					<td><c:out value="${visita.getFecha()}"></c:out></td>
					<td><c:out value="${visita.getHora()}"></c:out></td>
					<td><c:out value="${visita.getLugar()}"></c:out></td>
					<td><c:out value="${visita.isRealizado()}"></c:out></td>
					<td><c:out value="${visita.getDetalle()}"></c:out></td>
					<td><c:out value="${visita.getProfesionalId()}"></c:out></td>
					<td>
						<a href="${pageContext.request.contextPath}/visita?id=${visita.getId()}&op=read"><i class="fa-solid fa-eye"></i></a>
						<a href="${pageContext.request.contextPath}/visita?id=${visita.getId()}&op=edit"><i class="fa-solid fa-pen-to-square"></i></a>
						<a href="${pageContext.request.contextPath}/visita?id=${visita.getId()}&op=delete"><i class="fa-solid fa-trash"></i></a>
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