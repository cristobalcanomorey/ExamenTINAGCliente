<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="aplicacion.modelo.pojo.FechaHora"%>
<%@page import="aplicacion.modelo.pojo.Distrito"%>
<%@page import="java.util.ArrayList"%>
<%@page import="aplicacion.modelo.pojo.AccidenteConDistrito"%>
<%!ArrayList<AccidenteConDistrito> accidentesConDistritos;%>
<%!ArrayList<Distrito> distritos; %>
<%!ArrayList<FechaHora> fechasYHoras; %>
<%!String idDistrito; %>
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
		<p>Obtener todos registros de los accidentes de cada distrito</p>
		<select name="idDistrito" required>
			<%
				distritos = (ArrayList<Distrito>) request.getAttribute("distritos");
				idDistrito = (String) request.getAttribute("idDistrito");
				//Muestra las opciones de los distritos y el distrito seleccionado
				for (Distrito dis : distritos) {
					if(idDistrito != null){
						if (dis.getId().equals(Integer.valueOf(idDistrito))) {
							out.print("<option selected='selected' value='"+dis.getId()+"'>");
						} else {
							out.print("<option value='"+dis.getId()+"'>");
						}	
					} else{
						out.print("<option value='"+dis.getId()+"'>");
					}
					out.print(dis.getNombre());
					out.print("</option>");
				}
			%>
		</select>
		<button type="submit">Obtener</button>
	</form>
	<%
		fechasYHoras = (ArrayList<FechaHora>) request.getAttribute("fechasYHoras");
		accidentesConDistritos = (ArrayList<AccidenteConDistrito>) request.getAttribute("accidentes");
		//Crea la tabla con los datos obtenidos
		if (accidentesConDistritos != null) {
			if (!accidentesConDistritos.isEmpty()) {
				out.print("<table>");
				out.print("<tbody>");
				out.print("<tr>");
				out.print("<th>Fecha</th><th>Hora</th><th>Expediente</th><th>Distrito</th><th></th><th></th>");
				out.print("</tr>");
				for (AccidenteConDistrito aConDiS : accidentesConDistritos) {
					out.print("<tr>");
					for(FechaHora fh: fechasYHoras){
						if(aConDiS.getId().equals(fh.getIdAccidente())){
							out.print("<td>" + fh.getFecha() + "</td>");
							out.print("<td>" + fh.getHora() + "</td>");
							break;
						}
					}
					out.print("<td>" + aConDiS.getExpediente() + "</td>");
					out.print("<td>" + aConDiS.getDistrito() + "</td>");
					out.print("<td><a href='ActualizarAccidente?id=" + aConDiS.getId()
							+ "'>Modificar registro</a></td>");
					out.print(
							"<td><a href='EliminarAccidente?id=" + aConDiS.getId() + "'>Eliminar registro</a></td>");
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