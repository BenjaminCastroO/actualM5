<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenidos - Lista de Pagos</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/81a2ed02b0.js" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
	<jsp:include page="./header.jsp"></jsp:include>

	<div class="container ">
		<h2>Lista de Pagos</h2>
		<a href="${pageContext.request.contextPath}/pago?op=create"><button class="btn btn-dark">Crear pago</button></a>	
	</div>
	<div class = "col pt-4"></div>
	<table class="table pt-4">
		<thead class="table-dark pt-4">
			<tr>
				<th>Id Pago</th>
				<th>Id Cliente</th>
				<th>Monto</th>
				<th>Fecha Pago</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pago" items="${listaPagos}">
				<tr>
					<td><c:out value="${pago.getId()}"/></td>
					<td><c:out value="${pago.getClienteId()}"/></td>
					<td><c:out value="${pago.getMonto()}"></c:out></td>
					<td><c:out value="${pago.getFechaPago()}"></c:out></td>
					<td>
						<a href="${pageContext.request.contextPath}/pago?id=${pago.getId()}&op=read"><i class="fa-solid fa-eye"></i></a>
						<a href="${pageContext.request.contextPath}/pago?id=${pago.getId()}&op=edit"><i class="fa-solid fa-pen-to-square"></i></a>
						<a href="${pageContext.request.contextPath}/pago?id=${pago.getId()}&op=delete"><i class="fa-solid fa-trash"></i></a>
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