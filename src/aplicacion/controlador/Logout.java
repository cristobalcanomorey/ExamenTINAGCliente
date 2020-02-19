package aplicacion.controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aplicacion.modelo.LogSingleton;
import aplicacion.modelo.ejb.AgentesEJBCliente;
import aplicacion.modelo.ejb.SesionesEJBCliente;

/***
 * Cierra la sesión
 * 
 * @author tofol
 *
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AgentesEJBCliente agentesEJB;

	@EJB
	SesionesEJBCliente sesionesEJB;

	/***
	 * Cierra la sesión del agente
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogSingleton log = LogSingleton.getInstance();
		sesionesEJB.logout(request.getSession(false));
		try {
			response.sendRedirect("Principal");
		} catch (Exception e) {
			log.getLoggerLogout().debug("Se ha producido un error en GET Logout: " + e);
		}
	}

}
