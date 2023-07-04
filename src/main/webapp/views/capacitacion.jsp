<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenidos - Capacitaciones</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<jsp:include page="./header.jsp"></jsp:include>

	<div class="col pt-4">
		<form class="form " action="capacitacion" method="GET">
			<button class="btn btn-primary" id="btnMostrar" name="btnMostrar" type="submit" value="1">Mostrar capacitaciones</button>
		</form>	
	</div>

	<div class="container">
		<h2>Crear Capacitaciones</h2>	
	</div>
	<div class="container">
		<form class="form" action="capacitacion" method="POST">
			<div class="row">
			
			<div class="row">
				<div class="col">
					<label class="form-label" for="nombre">Nombre:</label>
						<input class="form-control" type="text"  id="nombre" name="nombre">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="detalle">Detalle:</label>
						<input class="form-control" type="text"  id="detalle" name="detalle">	
				</div>
			</div>		
			<div class="row">
				<div class="col">
					<label class="form-label" for="fecha">Fecha:</label>
						<input class="form-control" type="date"  id="fecha" name="fecha">	
				</div>
			</div>		
			<div class="row">
				<div class="col">
					<label class="form-label" for="hora">Hora:</label>
						<input class="form-control" type="time"  id="hora" name="hora">	
				</div>
			</div>		
			<div class="row">
				<div class="col">
					<label class="form-label" for="hora">Lugar:</label>
						<input class="form-control" type="text"  id="lugar" name="lugar">	
				</div>
			</div>		
			<div class="row">
				<div class="col">
					<label class="form-label" for="hora">Duración:</label>
						<input class="form-control" type="number"  id="duracion" name="duracion">	
				</div>
			</div>		
			<div class="row">
				<div class="col">
					<label class="form-label" for="hora">Cantidad:</label>
						<input class="form-control" type="number"  id="cantidad" name="cantidad">	
				</div>
			</div>		
			<div class="row">
				<div class="col">
					<label class="form-label" for="hora">Cliente Id:</label>
						<input class="form-control" type="number"  id="clienteId" name="clienteId">	
				</div>
			</div>		
			</div>		
			
			<div class="row pt-4">
				<div class="col">
					<a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Volver</a>
				</div>
				<div class="col">
						<button id = "enviar" name= "enviar" value = "capacitacion" type="submit" class="btn btn-primary">Guardar</button>
				</div>
			</div>	
		</form>
	</div>
		
	<jsp:include page="./footer.jsp"></jsp:include>
	</div>
</body>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</html>