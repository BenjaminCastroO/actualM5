<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenidos - Accidentes</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<jsp:include page="./header.jsp"></jsp:include>

	<div class="col pt-4">
		<form class="form " action="accidente" method="GET">
			<button class="btn btn-primary" id="btnMostrar" name="btnMostrar" type="submit" value="1">Mostrar accidentes</button>
		</form>	
	</div>

	<div class="container">
		<h2>Crear Accidentes</h2>	
	</div>
	<div class="container">
		<form class="form" action="accidente" method="POST">
			<div class="row">
			
			<div class="row">
				<div class="col">
					<label class="form-label" for="clienteId">Id Cliente</label>
						<input class="form-control" type="number"  id="clienteId" name="clienteId">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="fechaAccidente">Fecha Accidente:</label>
						<input class="form-control" type="date"  id="fechaAccidente" name="fechaAccidente">	
				</div>
			</div>		
			<div class="row">
				<div class="col">
					<label class="form-label" for="detalle">Detalle:</label>
						<input class="form-control" type="text"  id="detalle" name="detalle">	
				</div>
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