<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenidos - Lista de Accidentes</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/81a2ed02b0.js" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
	<jsp:include page="./header.jsp"></jsp:include>

	<div class="container ">
		<h2>Lista de Accidentes</h2>
		<a href="${pageContext.request.contextPath}/accidente?op=create"><button class="btn btn-dark">Crear accidente</button></a>	
	</div>
	<div class = "col pt-4"></div>
	<table class="table pt-4">
		<thead class="table-dark pt-4">
			<tr>
				<th>Id Accidente</th>
				<th>Id Cliente</th>
				<th>Fecha Accidente</th>
				<th>Detalle</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="accidente" items="${listaAccidentes}">
				<tr>
					<td><c:out value="${accidente.getId()}"/></td>
					<td><c:out value="${accidente.getClienteId()}"/></td>
					<td><c:out value="${accidente.getFechaAccidente()}"></c:out></td>
					<td><c:out value="${accidente.getDetalle()}"></c:out></td>
					<td>
						<a href="${pageContext.request.contextPath}/accidente?id=${accidente.getId()}&op=read"><i class="fa-solid fa-eye"></i></a>
						<a href="${pageContext.request.contextPath}/accidente?id=${accidente.getId()}&op=edit"><i class="fa-solid fa-pen-to-square"></i></a>
						<a href="${pageContext.request.contextPath}/accidente?id=${accidente.getId()}&op=delete"><i class="fa-solid fa-trash"></i></a>
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