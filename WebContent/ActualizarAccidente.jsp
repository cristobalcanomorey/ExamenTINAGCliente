<%@page import="aplicacion.modelo.pojo.FechaHora"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="aplicacion.modelo.pojo.Accidente"%>
<%@page import="aplicacion.modelo.pojo.Distrito"%>
<%@page import="aplicacion.modelo.pojo.TiposAccidente"%>
<%@page import="aplicacion.modelo.pojo.TiposSexo"%>
<%@page import="aplicacion.modelo.pojo.TiposVehiculo"%>
<%!Accidente accidente;%>
<%!FechaHora fechaYHora; %>
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
	<h3>Modificar datos del accidente</h3>
	<%
		fechaYHora = (FechaHora) request.getAttribute("fechaYHora");
		accidente = (Accidente) request.getAttribute("accidente");
		distritos = (ArrayList<Distrito>) request.getAttribute("distritos");
		tiposAccidentes = (ArrayList<TiposAccidente>) request.getAttribute("tiposAccidentes");
		tiposSexos = (ArrayList<TiposSexo>) request.getAttribute("tiposSexos");
		tiposVehiculos = (ArrayList<TiposVehiculo>) request.getAttribute("tiposVehiculos");
		//Pinta los valores por defecto de los input
	%>
	<form action="ActualizarAccidente" method="POST">
		<p>Nº Expediente:</p>
		<input type="text" name="expediente"
			value="<%=accidente.getExpediente()%>" required>
		<p>Fecha: </p>
		<input type="date" name="fecha" value="<%=fechaYHora.getFecha() %>" required>
			
		<p>Hora: </p>
		<input type="time" name="hora" step="1" value="<%=fechaYHora.getHora() %>" required>
			
		<p>Dirección:</p>
		<input type="text" name="direccion" value="<%=accidente.getDireccion()%>" required>

		<p>Distrito:</p>
		<select name="distrito" required>
			<%
			//Muestra las opciones de los distritos y el distrito seleccionado
				for (Distrito dis : distritos) {
					if (dis.getId().equals(accidente.getIdDistrito())) {
						out.print("<option selected='selected' value='"+dis.getId()+"'>");
					} else {
						out.print("<option value='"+dis.getId()+"'>");
					}
					out.print(dis.getNombre());
					out.print("</option>");
				}
			%>
		</select>

		<p>Tipo de accidente:</p>
		<select name="tipoAccidente" required>
			<%
			//Muestra las opciones de los tipos de accidentes y el tipo de accidente seleccionado
				for (TiposAccidente tac : tiposAccidentes) {
					if (tac.getId().equals(accidente.getIdTipoAccidente())) {
						out.print("<option selected='selected' value='"+tac.getId()+"'>");
					} else {
						out.print("<option value='"+tac.getId()+"'>");
					}
					out.print(tac.getNombre());
					out.print("</option>");
				}
			%>
		</select>

		<p>Sexo:</p>
		<select name="tipoSexo" required>
			<%
			//Muestra las opciones de los tipos de sexos y el tipo de sexo seleccionado
				for (TiposSexo tsx : tiposSexos) {
					if (tsx.getId().equals(accidente.getIdSexo())) {
						out.print("<option selected='selected' value='"+tsx.getId()+"'>");
					} else {
						out.print("<option value='"+tsx.getId()+"'>");
					}
					out.print(tsx.getNombre());
					out.print("</option>");
				}
			%>
		</select>

		<p>Tipo de vehículo:</p>
		<select name=tipoVehiculo required>
			<%
			//Muestra las opciones de los tipos de vehículos y el tipo de vehículos seleccionado
				for (TiposVehiculo tvh : tiposVehiculos) {
					if (tvh.getId().equals(accidente.getIdTipoVehiculo())) {
						out.print("<option selected='selected' value='"+tvh.getId()+"'>");
					} else {
						out.print("<option value='"+tvh.getId()+"'>");
					}
					out.print(tvh.getNombre());
					out.print("</option>");
				}
			%>
		</select>
		<input type="hidden" name="id" value="<%= accidente.getId() %>">
		<button type="submit">Modificar</button>
	</form>
	<div>
		<p>Gestión de accidentes del ayuntamiento de Madrid.</p>
	</div>
</body>
</html>