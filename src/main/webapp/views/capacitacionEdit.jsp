<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenidos - Capacitacion</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<jsp:include page="./header.jsp"></jsp:include>

	<div class="col pt-4">
		<form class="form " action="capacitacion" method="POST">
			<button class="btn btn-primary" id="btnMostrar" name="btnMostrar" type="submit" value="1">Mostrar usuarios</button>
		</form>	
	</div>

	<div class="container">
		<h2>Editar Capacitacion</h2>	
	</div>
	<div class="container">
		<form class="form" action="capacitacion" method="POST">
			<div class="row">
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="id">Id Capacitacion: ${capacitacion.getId()}</label>
					<input class="form-control" type="hidden"  id="id" name="id" value = "${capacitacion.getId()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="clienteId" >Id Cliente: ${capacitacion.getClienteId()}</label>
					<input class="form-control" type="hidden"  id="clienteId" name="clienteId" value = "${capacitacion.getClienteId()}">
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label class="form-label" for="nombre">Nombre:</label>
						<input class="form-control" type="text"  id="nombre" name="nombre" value = "${capacitacion.getNombre()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="apellido">Detalle:</label>
						<input class="form-control" type="text"  id="detalle" name="detalle" value = "${capacitacion.getDetalle()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="fecha">Fecha:</label>
						<input class="form-control" type="date"  id="fecha" name="fecha" value = "${capacitacion.getFecha()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="hora">Hora:</label>
						<input class="form-control" type="time"  id="hora" name="hora" value = "${capacitacion.getHora()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="lugar">Lugar:</label>
						<input class="form-control" type="text"  id="lugar" name="lugar" value = "${capacitacion.getLugar()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="duracion">Duracion:</label>
						<input class="form-control" type="number"  id="duracion" name="duracion" value = "${capacitacion.getDuracion()}">
				</div>
			</div>	
			<div class="row">
				<div class="col">
					<label class="form-label" for="cantidad">Cantidad:</label>
						<input class="form-control" type="number"  id="cantidad" name="cantidad" value = "${capacitacion.getCantidad()}">
				</div>
			</div>	
			<div class="row pt-4">
				<div class="col">
					<a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Volver</a>
				</div>
				<div class="col">
						<button id = "enviar" name= "enviar" value = "editCapacitacion" type="submit" class="btn btn-primary">Guardar</button>
				</div>
			</div>	
		</form>
	</div>
		
	<jsp:include page="./footer.jsp"></jsp:include>
	</div>
</body>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</html>