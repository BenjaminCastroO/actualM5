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
		<form class="form " action="usuario" method="POST">
			<button class="btn btn-primary" id="btnMostrar" name="btnMostrar" type="submit" value="1">Mostrar usuarios</button>
		</form>	
	</div>

	<div class="container">
		<h2>Ver Usuario Administrativo</h2>	
	</div>
	<div class="container">
		<form class="form" action="usuario" method="POST">
			<div class="row">
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="id">Id Admin: ${admin.getId()}</label>
					<input disabled class="form-control" type="hidden"  id="id" name="id" value = "${admin.getId()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="usuarioId" >Id Usuario: ${admin.getUsuarioId()}</label>
					<input disabled class="form-control" type="hidden"  id="usuarioId" name="usuarioId" value = "${admin.getUsuarioId()}">
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label class="form-label" for="nombre">Nombre:</label>
						<input disabled class="form-control" type="text"  id="nombre" name="nombre" value = "${admin.getNombre()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="apellido">Apellido:</label>
						<input disabled class="form-control" type="text"  id="apellido" name="apellido" value = "${admin.getApellido()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="run">RUN:</label>
						<input disabled class="form-control" type="text"  id="run" name="run" value = "${admin.getRun()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="correo">e-mail:</label>
						<input disabled class="form-control" type="text"  id="mail" name="mail" value = "${admin.getCorreo()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="area">Area:</label>
						<input disabled class="form-control" type="text"  id="area" name="area" value = "${admin.getArea()}">
				</div>
			</div>	
			<div class="row pt-4">
				<div class="col">
					<a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Volver</a>
				</div>
				<div class="col">
						<button id = "enviar" name= "enviar" value = "editAdmin" type="submit" class="btn btn-primary">Guardar</button>
				</div>
			</div>	
		</form>
	</div>
		
	<jsp:include page="./footer.jsp"></jsp:include>
	</div>
</body>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</html>