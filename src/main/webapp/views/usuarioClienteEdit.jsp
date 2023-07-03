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
		<h2>Editar Usuario Cliente</h2>	
	</div>
	<div class="container">
		<form class="form" action="usuario" method="POST">
			<div class="row">
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="id">Id Cliente: ${cliente.getId()}</label>
					<input class="form-control" type="hidden"  id="id" name="id" value = "${cliente.getId()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="usuarioId" >Id Usuario: ${cliente.getUsuarioId()}</label>
					<input class="form-control" type="hidden"  id="usuarioId" name="usuarioId" value = "${cliente.getUsuarioId()}">
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label class="form-label" for="nombre">Nombre:</label>
						<input class="form-control" type="text"  id="nombre" name="nombre" value = "${cliente.getNombre()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="apellido">Apellido:</label>
						<input class="form-control" type="text"  id="apellido" name="apellido" value = "${cliente.getApellido()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="rut">RUT:</label>
						<input class="form-control" type="text"  id="rut" name="rut" value = "${cliente.getRut()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="correo">e-mail:</label>
						<input class="form-control" type="text"  id="correo" name="correo" value = "${cliente.getCorreo()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="nombre">AFP:</label>
						<input class="form-control" type="text"  id="afp" name="afp" value = "${cliente.getAfp()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="sistemaSalud">Sistema de Salud:</label>
						<select class="form-select" id="sistemaSalud" name="sistemaSalud" aria-label="Default select example">
  						<option  selected value = "${cliente.getSistemaSalud()}">${cliente.getSistemaSalud()}</option>
  						<option  value="isapre">Isapre</option>
  						<option  value="fonasa">Fonasa</option>
					</select>
				</div>
			</div>	
			<div class="row">
				<div class="col">
					<label class="form-label" for="direccion">Direccion:</label>
						<input class="form-control" type="text"  id="direccion" name="direccion" value = "${cliente.getDireccion()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="comuna">Comuna:</label>
						<input class="form-control" type="text"  id="comuna" name="comuna" value = "${cliente.getComuna()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label" for="edad">Edad:</label>
						<input class="form-control" type="number"  id="edad" name="edad" value = "${cliente.getEdad()}">
				</div>
			</div>
			
			<div class="row pt-4">
				<div class="col">
					<a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Volver</a>
				</div>
				<div class="col">
						<button id = "enviar" name= "enviar" value = "editCliente" type="submit" class="btn btn-primary">Guardar</button>
				</div>
			</div>	
		</form>
	</div>
		
	<jsp:include page="./footer.jsp"></jsp:include>
	</div>
</body>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</html>