<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenidos - Usuarios</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<jsp:include page="./header.jsp"></jsp:include>

	<div class="col pt-4">
		<form class="form " action="usuario" method="GET">
			<button class="btn btn-primary" id="btnMostrar" name="btnMostrar" type="submit" value="1">Mostrar usuarios</button>
		</form>	
	</div>

	<div class="container">
		<h2>Crear Usuarios</h2>	
	</div>
	<div class="container">
		<form class="form" action="usuario" method="POST">
			<div class="row">
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="rut">Nombre:</label>
						<input class="form-control" type="text"  id="nombre" name="nombre">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="dia">Tipo:</label>
						<input class="form-control" type="text"  id="tipo" name="tipo">	
				</div>
			</div>		
			
			<div class="row pt-4">
				<div class="col">
					<a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Volver</a>
				</div>
				<div class="col">
						<button type="submit" class="btn btn-primary">Guardar</button>
				</div>
			</div>	
		</form>
	</div>
		
	<jsp:include page="./footer.jsp"></jsp:include>
	</div>
</body>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</html>