<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión TINAG</title>
</head>
<body>
	<ul>
		<li>
			<a href="Principal">Gestión TINAG</a>
		</li>
		<li>
			<a href="Accidentes">Accidentes</a>
		</li>
		<li>
			<a href="CrearAccidente">Registrar accidente</a>
		</li>
		<li>
			<a href="EliminarAccidente">Eliminar accidente</a>
		</li>
		<li>
			<a href="Logout">Cerrar sesión</a>
		</li>
	</ul>
	<h1>Gestión This Is Not A Gameland</h1>
	<p>Debes iniciar sesión para poder usar esta aplicación</p>
	<form action="Login" method="POST">
		<p>Placa de identificación:</p>
		<input type="text" name="placa">
		<p>Contraseña:</p>
		<input type="password" name="clave">
		<button type="submit">Login</button>
	</form>
	<%
		String error = (String) request.getAttribute("error");
		if(error != null){
			out.print("<p>"+error+"</p>");
		}
	%>
	<div>
		<p>Gestión de accidentes del ayuntamiento de Madrid.</p>
	</div>
</body>
</html>