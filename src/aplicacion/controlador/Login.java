package aplicacion.controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aplicacion.modelo.LogSingleton;
import aplicacion.modelo.ejb.AgentesEJB;
import aplicacion.modelo.pojo.Agente;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String FALTAN_DATOS = "1";
	private final String AGENTE_NO_EXISTE = "2";

	@EJB
	AgentesEJB agentesEJB;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		LogSingleton log = LogSingleton.getInstance();
		String placa = request.getParameter("placa");
		String clave = request.getParameter("clave");

		if (placa == null || clave == null) {
			try {
				response.sendRedirect("Principal?error=" + FALTAN_DATOS);
			} catch (Exception e) {
				log.getLoggerLogin().debug("Error en POST Login: ", e);
			}
		}

		Agente agente = agentesEJB.loginAgente(session, placa, clave);
		try {
			if (agente != null) {
				response.sendRedirect("Accidentes");
			} else {
				response.sendRedirect("Principal?error=" + AGENTE_NO_EXISTE);
			}
		} catch (Exception e) {
			log.getLoggerLogin().debug("Error en POST Login: ", e);
		}

	}

}
