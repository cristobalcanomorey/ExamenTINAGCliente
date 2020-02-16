package aplicacion.controlador;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aplicacion.modelo.LogSingleton;
import aplicacion.modelo.ejb.AccidentesEJBCliente;
import aplicacion.modelo.ejb.AgentesEJBCliente;
import aplicacion.modelo.pojo.Accidente;

@WebServlet("/ActualizarAccidente")
public class ActualizarAccidente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AgentesEJBCliente agentesEJBCliente;

	@EJB
	AccidentesEJBCliente accidentesEJBCliente;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LogSingleton log = LogSingleton.getInstance();
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/ActualizarAccidente.jsp");
		String id = request.getParameter("id");

		try {
//			Agente agente = agentesEJB.getAgenteLogueado();
//			if (agente == null || id == null) {
//				response.sendRedirect("Principal");
//			}
			Accidente accidente = accidentesEJBCliente.getAccidente(id);
			request.setAttribute("accidente", accidente);
			request.setAttribute("fechaYHora",
					accidentesEJBCliente.getFechaYHora(accidente.getId(), accidente.getFecha(), accidente.getHora()));
			request.setAttribute("distritos", accidentesEJBCliente.getDistritos());
			request.setAttribute("tiposAccidentes", accidentesEJBCliente.getTiposAccidentes());
			request.setAttribute("tiposSexos", accidentesEJBCliente.getTiposSexos());
			request.setAttribute("tiposVehiculos", accidentesEJBCliente.getTiposVehiculos());
			rs.forward(request, response);
		} catch (Exception e) {
			log.getLoggerActualizarAccidente().debug("Error en GET Actualizar Accidentes: ", e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LogSingleton log = LogSingleton.getInstance();
		String id = request.getParameter("id");
		String expediente = request.getParameter("expediente");
		String fecha = request.getParameter("fecha");
		String hora = request.getParameter("hora");
		String direccion = request.getParameter("direccion");
		String distrito = request.getParameter("distrito");
		String tipoAccidente = request.getParameter("tipoAccidente");
		String tipoSexo = request.getParameter("tipoSexo");
		String tipoVehiculo = request.getParameter("tipoVehiculo");
		try {
//			Agente agente = agentesEJB.getAgenteLogueado();
//			if (agente == null || id == null) {
//				response.sendRedirect("Principal");
//			}
			if (id == null || expediente == null || fecha == null || hora == null || direccion == null
					|| distrito == null || tipoAccidente == null || tipoSexo == null || tipoVehiculo == null) {
				response.sendRedirect("Principal");
			} else {
				Accidente modificado = null;
				try {
					Date fechD = accidentesEJBCliente.stringAFecha(fecha);
					Date horaD = accidentesEJBCliente.stringAHora(hora);
					Integer idDistrito = Integer.valueOf(distrito);
					Integer idTipoAccidente = Integer.valueOf(tipoAccidente);
					Integer idTipoVehiculo = Integer.valueOf(tipoVehiculo);
					Integer idTipoSexo = Integer.valueOf(tipoSexo);
					Integer idMod = Integer.valueOf(id);

					modificado = new Accidente(idMod, expediente, fechD, horaD, direccion, idDistrito, idTipoAccidente,
							idTipoVehiculo, idTipoSexo);

					accidentesEJBCliente.updateAccidente(modificado);
					response.sendRedirect("Accidentes");
				} catch (NumberFormatException | ParseException e) {
					log.getLoggerActualizarAccidente().debug("Error en POST Actualizar Accidente: ", e);
					response.sendRedirect("Principal");
				}
			}

		} catch (Exception e) {
			log.getLoggerActualizarAccidente().debug("Error en POST Actualizar Accidente: ", e);
		}

	}

}
