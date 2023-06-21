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

	<div class="container">
		<h2>Lista de Capacitaciones</h2>	
	</div>
	<table class="table">
		<thead class="table-dark">
			<tr>
				<th>Id Capacitacion</th>
				<th>RUT</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${capacitacion}">
				<tr>
					<td><c:out value="${capacitacion.getId()}"/></td>
					<td><c:out value="${capacitacion.getRut()}"></c:out></td>
					<td>
						<a href="${pageContext.request.contextPath}/students?a=read&id=${capacitacion.getId()}"><i class="fa-solid fa-book-open"></i></a>
						<a href="${pageContext.request.contextPath}/students?a=edit&id=${capacitacion.getId()}"><i class="fa-solid fa-pen-to-square"></i></a>
						<a href="${pageContext.request.contextPath}/students?a=delete&id=${capacitacion.getId()}"><i class="fa-solid fa-trash-can"></i></a>
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