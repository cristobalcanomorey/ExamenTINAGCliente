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
import aplicacion.modelo.ejb.AccidentesEJBCliente;
import aplicacion.modelo.ejb.AgentesEJBCliente;
import aplicacion.modelo.ejb.SesionesEJB;
import aplicacion.modelo.pojo.Agente;

@WebServlet("/EliminarAccidente")
public class EliminarAccidente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AgentesEJBCliente agentesEJBCliente;

	@EJB
	AccidentesEJBCliente accidentesEJBCliente;

	@EJB
	SesionesEJB sesionesEJB;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LogSingleton log = LogSingleton.getInstance();
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/EliminarAccidente.jsp");
		String id = request.getParameter("id");

		try {
			Agente agente = sesionesEJB.agenteLogueado(request.getSession(false));
			if (agente == null || id == null) {
				response.sendRedirect("Principal");
			}
			request.setAttribute("accidente", accidentesEJBCliente.getAccidente(id));
			rs.forward(request, response);
		} catch (Exception e) {
			log.getLoggerEliminarAccidente().debug("Error en GET Eliminar Accidentes: ", e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogSingleton log = LogSingleton.getInstance();
		String id = request.getParameter("id");
		try {
			Agente agente = sesionesEJB.agenteLogueado(request.getSession(false));
			if (agente == null || id == null) {
				response.sendRedirect("Principal");
			}
			accidentesEJBCliente.borraAccidente(id);
			response.sendRedirect("Accidentes");
		} catch (Exception e) {
			log.getLoggerEliminarAccidente().debug("Error en POST Eliminar Accidente: ", e);
		}
	}

}
