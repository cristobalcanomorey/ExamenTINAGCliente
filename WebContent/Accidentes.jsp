<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="aplicacion.modelo.pojo.FechaHora"%>
<%@page import="aplicacion.modelo.pojo.Distrito"%>
<%@page import="java.util.ArrayList"%>
<%@page import="aplicacion.modelo.pojo.AccidenteConDistrito"%>
<%!ArrayList<AccidenteConDistrito> accidentesConDistritos;%>
<%!ArrayList<Distrito> distritos;%>
<%!ArrayList<FechaHora> fechasYHoras;%>
<%!String idDistrito;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión TINAG</title>
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
			<li class="nav-item"><a class="nav-link active"
				href="Accidentes">Accidentes</a></li>
			<li class="nav-item"><a class="nav-link" href="CrearAccidente">Registrar
					accidente</a></li>
			<li class="nav-item"><a class="nav-link" href="Logout">Cerrar
					sesión</a></li>
		</ul>
	</nav>
	<div class="container text-center border mb-5 mt-5">
		<h1>Gestión This Is Not A Gameland</h1>
		<h3>Accidentes</h3>
		<form action="Accidentes" method="POST">
			<p>Obtener todos registros de los accidentes de cada distrito</p>
			<div class="form-group">
                    <label for="distrito">Distrito:</label>
                    <select id="distrito" name="idDistrito" required>
				<%
					distritos = (ArrayList<Distrito>) request.getAttribute("distritos");
					idDistrito = (String) request.getAttribute("idDistrito");
					//Muestra las opciones de los distritos y el distrito seleccionado
					for (Distrito dis : distritos) {
						if (idDistrito != null) {
							if (dis.getId().equals(Integer.valueOf(idDistrito))) {
								out.print("<option selected='selected' value='" + dis.getId() + "'>");
							} else {
								out.print("<option value='" + dis.getId() + "'>");
							}
						} else {
							out.print("<option value='" + dis.getId() + "'>");
						}
						out.print(dis.getNombre());
						out.print("</option>");
					}
				%>
			</select>
            </div>
			<button type="submit" class="btn btn-primary mb-2 mt-2 btn-block">Obtener</button>
		</form>
	</div>

	<%
		fechasYHoras = (ArrayList<FechaHora>) request.getAttribute("fechasYHoras");
		accidentesConDistritos = (ArrayList<AccidenteConDistrito>) request.getAttribute("accidentes");
		//Crea la tabla con los datos obtenidos
		if (accidentesConDistritos != null) {
			if (!accidentesConDistritos.isEmpty()) {
				out.print("<table class='table table-striped text-center'>");
				out.print("<thead>");
				out.print("<tr>");
				out.print("<th>Fecha</th><th>Hora</th><th>Expediente</th><th>Distrito</th><th></th><th></th>");
				out.print("</tr>");
				out.print("</thead>");
				out.print("<tbody>");
				for (AccidenteConDistrito aConDiS : accidentesConDistritos) {
					out.print("<tr>");
					for (FechaHora fh : fechasYHoras) {
						if (aConDiS.getId().equals(fh.getIdAccidente())) {
							out.print("<td>" + fh.getFecha() + "</td>");
							out.print("<td>" + fh.getHora() + "</td>");
							break;
						}
					}
					out.print("<td>" + aConDiS.getExpediente() + "</td>");
					out.print("<td>" + aConDiS.getDistrito() + "</td>");
					out.print("<td><a href='ActualizarAccidente?id=" + aConDiS.getId()
							+ "'>Modificar registro</a></td>");
					out.print("<td><a href='EliminarAccidente?id=" + aConDiS.getId()
							+ "'>Eliminar registro</a></td>");
					out.print("</tr>");
				}
				out.print("</tbody>");
				out.print("</table>");
			}
		}
	%>
	<footer class="page-footer font-small blue text-center">
            <p>Gestión de accidentes del ayuntamiento de Madrid.</p>
            <!-- Copyright -->
            <div class="footer-copyright text-center py-3">© 2020 Copyright:
                Dach SL</div>
            <!-- Copyright -->
        </footer>
	
</body>
</html>