<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenidos - Lista de Clientes</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/81a2ed02b0.js" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
	<jsp:include page="./header.jsp"></jsp:include>

	<div class="container ">
		<h2>Lista de Clientes</h2>
	</div>
	<div class = "col pt-4"></div>
	<table class="table pt-4">
		<thead class="table-dark pt-4">
			<tr>
				<th>Id Cliente</th>
				<th>Rut</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Correo</th>
				<th>Telefono</th>
				<th>Afp</th>
				<th>Sistema de salud</th>
				<th>Direccion</th>
				<th>Comuna</th>
				<th>Edad</th>
				<th>Id Usuario</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cliente" items="${listaClientes}">
				<tr>
					<td><c:out value="${cliente.getId()}"/></td>
					<td><c:out value="${cliente.getRut()}"/></td>
					<td><c:out value="${cliente.getNombre()}"/></td>
					<td><c:out value="${cliente.getApellido()}"/></td>
					<td><c:out value="${cliente.getCorreo()}"/></td>
					<td><c:out value="${cliente.getTelefono()}"/></td>
					<td><c:out value="${cliente.getAfp()}"/></td>
					<td><c:out value="${cliente.getSistemaSalud()}"/></td>
					<td><c:out value="${cliente.getDireccion()}"/></td>
					<td><c:out value="${cliente.getComuna()}"/></td>
					<td><c:out value="${cliente.getEdad()}"/></td>
					<td><c:out value="${cliente.getUsuarioId()}"/></td>
			
					<td>
						<a href="${pageContext.request.contextPath}/usuario?id=${cliente.getId()}&op=readOneCliente"><i class="fa-solid fa-eye"></i></a>
						<a href="${pageContext.request.contextPath}/usuario?id=${cliente.getId()}&op=editCliente"><i class="fa-solid fa-pen-to-square"></i></a>
						<a href="${pageContext.request.contextPath}/usuario?id=${cliente.getId()}&op=deleteCliente"><i class="fa-solid fa-trash"></i></a>
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