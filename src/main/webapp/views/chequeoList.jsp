<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenidos - Lista de Chequeos</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/81a2ed02b0.js" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
	<jsp:include page="./header.jsp"></jsp:include>

	<div class="container ">
		<h2>Lista de Chequeos</h2>
		<a href="${pageContext.request.contextPath}/chequeo?op=create"><button class="btn btn-dark">Crear chequeo</button></a>	
	</div>
	<div class = "col pt-4"></div>
	<table class="table pt-4">
		<thead class="table-dark pt-4">
			<tr>
				<th>Id Chequeo</th>
				<th>Id Visita</th>
				<th>Detalle</th>
				<th>Estado</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="chequeo" items="${listaChequeos}">
				<tr>
					<td><c:out value="${chequeo.getId()}"/></td>
					<td><c:out value="${chequeo.getVisitaId()}"/></td>
					<td><c:out value="${chequeo.getDetalle()}"></c:out></td>
					<td><c:out value="${chequeo.getEstado()}"></c:out></td>
					<td>
						<a href="${pageContext.request.contextPath}/chequeo?id=${chequeo.getId()}&op=read"><i class="fa-solid fa-eye"></i></a>
						<a href="${pageContext.request.contextPath}/chequeo?id=${chequeo.getId()}&op=edit"><i class="fa-solid fa-pen-to-square"></i></a>
						<a href="${pageContext.request.contextPath}/chequeo?id=${chequeo.getId()}&op=delete"><i class="fa-solid fa-trash"></i></a>
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