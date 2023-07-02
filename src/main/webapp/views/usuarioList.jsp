<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenidos - Lista de Usuarios</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/81a2ed02b0.js" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
	<jsp:include page="./header.jsp"></jsp:include>

	<div class="container ">
		<h2>Lista de Usuarios</h2>
		<div class = "row">
		<div class="dropdown col pt-4">
			<button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
  			  Crear Usuario
 			</button>
  			<ul class="dropdown-menu">
   				<li><a class="dropdown-item" href="${pageContext.request.contextPath}/usuario?op=createAdministrativo">Administrativo</a></li>
    			<li><a class="dropdown-item" href="${pageContext.request.contextPath}/usuario?op=createCliente">Cliente</a></li>
    			<li><a class="dropdown-item" href="${pageContext.request.contextPath}/usuario?op=createProfesional">Profesional</a></li>
 			</ul>
		</div>
		
			<div class="dropdown col pt-4">
				<button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
	  			  Mostrar Usuarios
	 			</button>
	  			<ul class="dropdown-menu">
	   				<li><a class="dropdown-item" href="${pageContext.request.contextPath}/usuario?op=readAdministrativo">Administrativo</a></li>
	    			<li><a class="dropdown-item" href="${pageContext.request.contextPath}/usuario?op=readCliente">Cliente</a></li>
	    			<li><a class="dropdown-item" href="${pageContext.request.contextPath}/usuario?op=readProfesional">Profesional</a></li>
	 			</ul>
			</div>
		</div>
	
	
	<div class = "col pt-4"></div>
	<table class="table pt-4">
		<thead class="table-dark pt-4">
			<tr>
				<th>Id Usuario</th>
				<th>Nombre</th>
				<th>Tipo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="usuario" items="${listaUsuarios}">
				<tr>
					<td><c:out value="${usuario.getId()}"/></td>
					<td><c:out value="${usuario.getNombre()}"/></td>
					
					<td>
						<a href="${pageContext.request.contextPath}/usuario?id=${usuario.getId()}&op=read"><i class="fa-solid fa-eye"></i></a>
						<a href="${pageContext.request.contextPath}/usuario?id=${usuario.getId()}&op=edit"><i class="fa-solid fa-pen-to-square"></i></a>
						<a href="${pageContext.request.contextPath}/usuario?id=${usuario.getId()}&op=delete"><i class="fa-solid fa-trash"></i></a>
					</td>				
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
	<jsp:include page="./footer.jsp"></jsp:include>
	</div>
</body>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</html>