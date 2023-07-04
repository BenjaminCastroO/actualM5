<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CeroACC</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">


<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<jsp:include page="./header.jsp"></jsp:include>
	<div class = "container">

		<h1 style="font-size: 24px;">Buenos días por favor, para contactarse con nosotros indique su nombre, correo electrónico y motivo de contacto. ¡De antemano, muchas gracias!</h1>


   <h2>Formulario de Contacto</h2>
    <form action="contacto" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        
        <br> 
        
        <label for="mensaje">Mensaje:</label>
        <br> 
        <textarea id="mensaje" name="mensaje" rows="8" cols="60" required></textarea>
        
        <br> 
        
        <div class="col pt-4">
						<button id = "enviar" name= "enviar" value = "contacto" type="submit" class="btn btn-primary">Enviar</button>
				</div>
    </form>
</div>
<jsp:include page="./footer.jsp"></jsp:include>
</div>.
</body>
</html>