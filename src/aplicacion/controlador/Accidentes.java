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

@WebServlet("/Accidentes")
public class Accidentes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AgentesEJBCliente agentesEJB;

	@EJB
	AccidentesEJBCliente accidentesEJBCliente;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LogSingleton log = LogSingleton.getInstance();
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Accidentes.jsp");

		try {
//			Agente agente = agentesEJB.getAgenteLogueado();
//			if (agente == null) {
//				response.sendRedirect("Principal");
//			}
			request.setAttribute("distritos", accidentesEJBCliente.getDistritos());
			rs.forward(request, response);
		} catch (Exception e) {
			log.getLoggerAccidentes().debug("Error en GET Accidentes: ", e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogSingleton log = LogSingleton.getInstance();
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Accidentes.jsp");

		String idDistrito = request.getParameter("idDistrito");

		try {
//			Agente agente = agentesEJB.getAgenteLogueado();
//			if (agente == null || idDistrito == null) {
//				response.sendRedirect("Principal");
//			}

			request.setAttribute("distritos", accidentesEJBCliente.getDistritos());
			request.setAttribute("idDistrito", idDistrito);
			request.setAttribute("accidentes", accidentesEJBCliente.getAccidentesConDistrito(idDistrito));
			rs.forward(request, response);
		} catch (Exception e) {
			log.getLoggerAccidentes().debug("Error en POST Accidentes: ", e);
		}
	}

}
