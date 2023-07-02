<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenidos - Lista de Administrativos</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/81a2ed02b0.js" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
	<jsp:include page="./header.jsp"></jsp:include>

	<div class="container ">
		<h2>Lista de Administrativos</h2>
	</div>
	<div class = "col pt-4"></div>
	<table class="table pt-4">
		<thead class="table-dark pt-4">
			<tr>
				<th>Id Administrativo</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Correo</th>
				<th>Area</th>
				<th>Id Usuario</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="administrativo" items="${listaAdministrativos}">
				<tr>
					<td><c:out value="${administrativo.getId()}"/></td>
					<td><c:out value="${administrativo.getNombre()}"/></td>
					<td><c:out value="${administrativo.getApellido()}"/></td>
					<td><c:out value="${administrativo.getCorreo()}"/></td>
					<td><c:out value="${administrativo.getArea()}"/></td>
					<td><c:out value="${administrativo.getUsuarioId()}"/></td>
			
					<td>
						<a href="${pageContext.request.contextPath}/usuario?id=${usuario.getId()}&op=read"><i class="fa-solid fa-eye"></i></a>
						<a href="${pageContext.request.contextPath}/usuario?id=${usuario.getId()}&op=edit"><i class="fa-solid fa-pen-to-square"></i></a>
						<a href="${pageContext.request.contextPath}/usuario?id=${usuario.getId()}&op=delete"><i class="fa-solid fa-trash"></i></a>
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