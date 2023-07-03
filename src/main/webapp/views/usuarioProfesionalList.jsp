<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenidos - Lista de Profesionales</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/81a2ed02b0.js" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
	<jsp:include page="./header.jsp"></jsp:include>

	<div class="container ">
		<h2>Lista de Profesionales</h2>
	</div>
	<div class = "col pt-4"></div>
	<table class="table pt-4">
		<thead class="table-dark pt-4">
			<tr>
				<th>Id Profesional</th>
				<th>Run</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Correo</th>
				<th>Telefono</th>
				<th>Cargo</th>
				<th>Id Usuario</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="profesional" items="${listaProfesionales}">
				<tr>
					<td><c:out value="${profesional.getId()}"/></td>
					<td><c:out value="${profesional.getRun()}"/></td>
					<td><c:out value="${profesional.getNombre()}"/></td>
					<td><c:out value="${profesional.getApellido()}"/></td>
					<td><c:out value="${profesional.getCorreo()}"/></td>
					<td><c:out value="${profesional.getTelefono()}"/></td>
					<td><c:out value="${profesional.getCargo()}"/></td>
					<td><c:out value="${profesional.getUsuarioId()}"/></td>
			
					<td>
						<a href="${pageContext.request.contextPath}/usuario?id=${profesional.getId()}&op=readOneProfesional"><i class="fa-solid fa-eye"></i></a>
						<a href="${pageContext.request.contextPath}/usuario?id=${profesional.getId()}&op=editProfesional"><i class="fa-solid fa-pen-to-square"></i></a>
						<a href="${pageContext.request.contextPath}/usuario?id=${profesional.getId()}&op=deleteProfesional"><i class="fa-solid fa-trash"></i></a>
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