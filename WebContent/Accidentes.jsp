<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="aplicacion.modelo.pojo.AccidenteConDistrito"%>
<%!ArrayList<AccidenteConDistrito> accidentesConDistritos;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión TINAG</title>
</head>
<body>
	<ul>
		<li><a href="Principal">Gestión TINAG</a></li>
		<li><a href="Accidentes">Accidentes</a></li>
		<li><a href="CrearAccidente">Registrar accidente</a></li>
		<li><a href="Logout">Cerrar sesión</a></li>
	</ul>
	<h1>Gestión This Is Not A Gameland</h1>
	<h3>Accidentes</h3>
	<form action="Accidentes" method="POST">
		Obtener todos registros de los accidentes
		<button type="submit">Obtener</button>
	</form>
	<%
		accidentesConDistritos = (ArrayList<AccidenteConDistrito>) request.getAttribute("accidentes");
		if (accidentesConDistritos != null) {
			out.print("<p class='advertencia'>Obteniendo accidentes... Esto puede tardar varios segundos</p>");
			if (!accidentesConDistritos.isEmpty()) {
				out.print("<table>");
				out.print("<tbody>");
				out.print("<tr>");
				out.print("<th>Fecha</th><th>Hora</th><th>Expediente</th><th>Distrito</th><th></th><th></th>");
				out.print("</tr>");
				for (AccidenteConDistrito aConDi : accidentesConDistritos) {
					out.print("<tr>");
					out.print("<td>" + aConDi.getFecha() + "</td>");
					out.print("<td>" + aConDi.getHora() + "</td>");
					out.print("<td>" + aConDi.getExpediente() + "</td>");
					out.print("<td>" + aConDi.getDistrito() + "</td>");
					out.print("<td><a href='ActualizarAccidente?id=" + aConDi.getId()
							+ "'>Modificar registro</a></td>");
					out.print(
							"<td><a href='EliminarAccidente?id=" + aConDi.getId() + "'>Eliminar registro</a></td>");
					out.print("</tr>");
				}
				out.print("</tbody>");
				out.print("</table>");
			}
		}
	%>
	<div>
		<p>Gestión de accidentes del ayuntamiento de Madrid.</p>
	</div>
</body>
</html>