package aplicacion.controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aplicacion.modelo.LogSingleton;
import aplicacion.modelo.ejb.AgentesEJBCliente;
import aplicacion.modelo.ejb.SesionesEJB;
import aplicacion.modelo.pojo.Agente;

@WebServlet("/Principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String FALTAN_DATOS = "1";
	private final String AGENTE_NO_EXISTE = "2";

	@EJB
	AgentesEJBCliente agentesEJB;

	@EJB
	SesionesEJB sesionesEJB;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogSingleton log = LogSingleton.getInstance();
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Principal.jsp");

		String err = request.getParameter("error");

		Agente agente = sesionesEJB.agenteLogueado(request.getSession(false));

		try {
			if (agente != null) {
				response.sendRedirect("Accidentes");
			} else {
				if (err != null) {
					if (err.equals(FALTAN_DATOS)) {
						request.setAttribute("error", "No puedes dejar campos en blanco");
					} else if (err.equals(AGENTE_NO_EXISTE)) {
						request.setAttribute("error", "La placa y/o la contraseña son incorrectas");
					}
				}
				rs.forward(request, response);
			}
		} catch (Exception e) {
			log.getLoggerPrincipal().debug("Error en GET Principal: ", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogSingleton log = LogSingleton.getInstance();
		String placa = request.getParameter("placa");
		String clave = request.getParameter("clave");

		try {
			if (placa != null && clave != null) {
				if (placa.equals("") || clave.equals("")) {
					response.sendRedirect("Principal?error=" + FALTAN_DATOS);
				}
			} else {
				response.sendRedirect("Principal?error=" + FALTAN_DATOS);
			}
		} catch (Exception e) {
			log.getLoggerPrincipal().debug("Error en POST Principal: ", e);
		}

		Agente agente = agentesEJB.validarAgente(placa, clave);
		try {
			if (agente != null) {
				sesionesEJB.loginAgente(request.getSession(true), agente);
				response.sendRedirect("Accidentes");
			} else {
				response.sendRedirect("Principal?error=" + AGENTE_NO_EXISTE);
			}
		} catch (Exception e) {
			log.getLoggerPrincipal().debug("Error en POST Principal: ", e);
		}

	}

}
