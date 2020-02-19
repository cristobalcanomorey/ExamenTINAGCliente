<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="aplicacion.modelo.pojo.Distrito"%>
<%@page import="aplicacion.modelo.pojo.TiposAccidente"%>
<%@page import="aplicacion.modelo.pojo.TiposSexo"%>
<%@page import="aplicacion.modelo.pojo.TiposVehiculo"%>
<%!ArrayList<Distrito> distritos;%>
<%!ArrayList<TiposAccidente> tiposAccidentes;%>
<%!ArrayList<TiposSexo> tiposSexos;%>
<%!ArrayList<TiposVehiculo> tiposVehiculos;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is not a Gameland</title>
</head>
<body>
	<ul>
		<li><a href="Principal">Gestión TINAG</a></li>
		<li><a href="Accidentes">Accidentes</a></li>
		<li><a href="CrearAccidente">Registrar accidente</a></li>
		<li><a href="Logout">Cerrar sesión</a></li>
	</ul>
	<h1>Gestión This Is Not A Gameland</h1>
	<h3>Registra los datos de un accidente</h3>
	<%
		distritos = (ArrayList<Distrito>) request.getAttribute("distritos");
		tiposAccidentes = (ArrayList<TiposAccidente>) request.getAttribute("tiposAccidentes");
		tiposSexos = (ArrayList<TiposSexo>) request.getAttribute("tiposSexos");
		tiposVehiculos = (ArrayList<TiposVehiculo>) request.getAttribute("tiposVehiculos");

	%>
	<form action="CrearAccidente" method="POST">
		<p>Nº Expediente:</p>
		<input type="text" name="expediente" required>
		<p>Fecha:</p>
		<input type="date" name="fecha" required>
		<p>Hora:</p>
		<input type="time" name="hora" step="1" required>
		<p>Dirección:</p>
		<input type="text" name="direccion" required>
		
		<p>Distrito:</p>
		<select name="distrito" required>
			<%
			//Muestra las opciones de los distritos
				for (Distrito dis : distritos) {
					out.print("<option value='"+dis.getId()+"'>");
					out.print(dis.getNombre());
					out.print("</option>");
				}
			%>
		</select>
		
		<p>Tipo de accidente:</p>
		<select name="tipoAccidente" required>
			<%
			//Muestra las opciones de los tipos de accidente
				for (TiposAccidente tac : tiposAccidentes) {
					out.print("<option value='"+tac.getId()+"'>");
					out.print(tac.getNombre());
					out.print("</option>");
				}
			%>
		</select>
		
		<p>Sexo:</p>
		<select name="tipoSexo" required>
			<%
			//Muestra las opciones de los tipos de sexo
				for (TiposSexo tsx : tiposSexos) {
					out.print("<option value='"+tsx.getId()+"'>");
					out.print(tsx.getNombre());
					out.print("</option>");
				}
			%>
		</select>
		
		<p>Tipo de vehículo:</p>
		<select name="tipoVehiculo" required>
			<%
			//Muestra las opciones de los tipos de vehículos
				for (TiposVehiculo tvh : tiposVehiculos) {
					out.print("<option value='"+tvh.getId()+"'>");
					out.print(tvh.getNombre());
					out.print("</option>");
				}
			%>
		</select>
		
		<button type="submit">Registrar</button>
	</form>
	<div>
		<p>Gestión de accidentes del ayuntamiento de Madrid.</p>
	</div>
</body>
</html>