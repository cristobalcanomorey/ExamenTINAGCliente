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
<%!FechaHora fechaYHora;%>
<%!ArrayList<Distrito> distritos;%>
<%!ArrayList<TiposAccidente> tiposAccidentes;%>
<%!ArrayList<TiposSexo> tiposSexos;%>
<%!ArrayList<TiposVehiculo> tiposVehiculos;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is not a Gameland</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav
		class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-center">
		<!-- Links -->
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="Principal">Gestión
					TINAG</a></li>
			<li class="nav-item"><a class="nav-link" href="Accidentes">Accidentes</a></li>
			<li class="nav-item"><a class="nav-link" href="CrearAccidente">Registrar
					accidente</a></li>
			<li class="nav-item"><a class="nav-link" href="Logout">Cerrar
					sesión</a></li>
		</ul>
	</nav>
	<div class="container text-center border mb-5 mt-5">
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
			<div class="form-group">
				<label for="expediente">Nº Expediente:</label> <input
					id="expediente" type="text" class="form-control text-center"
					name="expediente" value="<%=accidente.getExpediente()%>" required>
			</div>

			<div class="form-group">
				<label for="fecha">Fecha:</label> <input id="fecha" type="date"
					class="form-control text-center" name="fecha"
					value="<%=fechaYHora.getFecha()%>" required>
			</div>

			<div class="form-group">
				<label for="hora">Hora:</label> <input id="hora" type="time"
					class="form-control text-center" step="1" name="hora"
					value="<%=fechaYHora.getHora()%>" required>
			</div>

			<div class="form-group">
				<label for="direccion">Dirección:</label> <input
					id="direccion" type="text" class="form-control text-center"
					name="direccion" value="<%=accidente.getDireccion()%>" required>
			</div>

			
			<div class="form-group">
                    <label for="distrito">Distrito:</label><br>
                    <select id="distrito" name="distrito" required>
				<%
					//Muestra las opciones de los distritos y el distrito seleccionado
					for (Distrito dis : distritos) {
						if (dis.getId().equals(accidente.getIdDistrito())) {
							out.print("<option selected='selected' value='" + dis.getId() + "'>");
						} else {
							out.print("<option value='" + dis.getId() + "'>");
						}
						out.print(dis.getNombre());
						out.print("</option>");
					}
				%>
			</select>
			</div>
			
			
			<div class="form-group">
                    <label for="tipoAccidente">Tipo de accidente:</label><br>
                    <select id="tipoAccidente" name="tipoAccidente" required>
				<%
					//Muestra las opciones de los tipos de accidentes y el tipo de accidente seleccionado
					for (TiposAccidente tac : tiposAccidentes) {
						if (tac.getId().equals(accidente.getIdTipoAccidente())) {
							out.print("<option selected='selected' value='" + tac.getId() + "'>");
						} else {
							out.print("<option value='" + tac.getId() + "'>");
						}
						out.print(tac.getNombre());
						out.print("</option>");
					}
				%>
			</select>
			</div>

			<div class="form-group">
                    <label for="tipoSexo">Sexo:</label><br>
                    <select id="tipoSexo" name="tipoSexo" required>
				<%
					//Muestra las opciones de los tipos de sexos y el tipo de sexo seleccionado
					for (TiposSexo tsx : tiposSexos) {
						if (tsx.getId().equals(accidente.getIdSexo())) {
							out.print("<option selected='selected' value='" + tsx.getId() + "'>");
						} else {
							out.print("<option value='" + tsx.getId() + "'>");
						}
						out.print(tsx.getNombre());
						out.print("</option>");
					}
				%>
			</select>
			</div>

			<div class="form-group">
                    <label for="tipoVehiculo">Tipo de vehículo:</label><br>
                    <select id="tipoVehiculo" name="tipoVehiculo" required>
				<%
					//Muestra las opciones de los tipos de vehículos y el tipo de vehículos seleccionado
					for (TiposVehiculo tvh : tiposVehiculos) {
						if (tvh.getId().equals(accidente.getIdTipoVehiculo())) {
							out.print("<option selected='selected' value='" + tvh.getId() + "'>");
						} else {
							out.print("<option value='" + tvh.getId() + "'>");
						}
						out.print(tvh.getNombre());
						out.print("</option>");
					}
				%>
			</select>
			</div>
			<input type="hidden" name="id" value="<%=accidente.getId()%>">
			<button type="submit" class="btn btn-primary mb-2 mt-2 btn-block">Modificar</button>
		</form>
	</div>
<footer class="page-footer font-small blue text-center">
            <p>Gestión de accidentes del ayuntamiento de Madrid.</p>
            <!-- Copyright -->
            <div class="footer-copyright text-center py-3">© 2020 Copyright:
                Dach SL</div>
            <!-- Copyright -->
        </footer>
</body>
</html>