package aplicacion.controlador;

import java.io.IOException;
import java.text.ParseException;

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

@WebServlet("/CrearAccidente")
public class CrearAccidente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AgentesEJBCliente agentesEJB;

	@EJB
	AccidentesEJBCliente accidentesEJBCliente;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LogSingleton log = LogSingleton.getInstance();
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/CrearAccidente.jsp");

		try {
//			Agente agente = agentesEJB.getAgenteLogueado();
//			if (agente == null) {
//				response.sendRedirect("Principal");
//			}
			request.setAttribute("distritos", accidentesEJBCliente.getDistritos());
			request.setAttribute("tiposAccidentes", accidentesEJBCliente.getTiposAccidentes());
			request.setAttribute("tiposSexos", accidentesEJBCliente.getTiposSexos());
			request.setAttribute("tiposVehiculos", accidentesEJBCliente.getTiposVehiculos());
			rs.forward(request, response);
		} catch (Exception e) {
			log.getLoggerCrearAccidente().debug("Error en GET Crear Accidente: ", e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LogSingleton log = LogSingleton.getInstance();

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
//			if (agente == null) {
//				response.sendRedirect("Principal");
//			}
			if (expediente == null || fecha == null || hora == null || direccion == null || distrito == null
					|| tipoAccidente == null || tipoSexo == null || tipoVehiculo == null) {
				response.sendRedirect("Principal");
			} else {
				Accidente nuevo = null;
				try {
					nuevo = new Accidente(null, expediente, accidentesEJBCliente.stringAFecha(fecha),
							accidentesEJBCliente.stringAHora(hora), direccion, Integer.valueOf(distrito),
							Integer.valueOf(tipoAccidente), Integer.valueOf(tipoVehiculo), Integer.valueOf(tipoSexo));
				} catch (NumberFormatException | ParseException e) {
					log.getLoggerCrearAccidente().debug("Error en POST Crear Accidente: ", e);
					response.sendRedirect("Principal");
				}
				accidentesEJBCliente.insertAccidente(nuevo);
				response.sendRedirect("CrearAccidente");
			}

		} catch (Exception e) {
			log.getLoggerCrearAccidente().debug("Error en POST Crear Accidente: ", e);
		}

	}

}
