<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="aplicacion.modelo.pojo.Accidente"%>
<%!Accidente accidente; %>
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
			<a href="Logout">Cerrar sesión</a>
		</li>
	</ul>
	<h1>Gestión This Is Not A Gameland</h1>
	<%
		accidente = (Accidente) request.getAttribute("accidente");
		if(accidente != null){
			out.print("<h3>¿Seguro que quieres eliminar el expediente "+accidente.getExpediente()+"?</h3>");
		}
	%>
	<form action="EliminarAccidente" method="POST">
		<%
		//Crea el input si hay accidente
			if(accidente != null){
				out.print("<input type='hidden' name='id' value='"+accidente.getId()+"'>");
			}
		%>
		<button type="submit">Eliminar</button>
	</form>
	<div>
		<p>Gestión de accidentes del ayuntamiento de Madrid.</p>
	</div>
</body>
</html>