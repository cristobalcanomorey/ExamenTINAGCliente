package aplicacion.modelo.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

import aplicacion.modelo.pojo.Agente;

/***
 * Lógica de negocio para las sesiónes
 * 
 * @author tofol
 *
 */
@Stateless
@LocalBean
public class SesionesEJBCliente {

	/**
	 * Obtiene un agente de la sesión
	 * 
	 * @param session La sesión dónde buscamos al agente
	 * @return El agente que hay en la sesión o null si no hay agente
	 */
	public Agente agenteLogueado(HttpSession session) {
		Agente agente = null;
		if (session != null) {
			agente = (Agente) session.getAttribute("agente");
		}
		return agente;
	}

	/***
	 * Guarda una sesión para el agente
	 * 
	 * @param session Nueva sesión
	 * @param agente  Agente a loguear
	 */
	public void loginAgente(HttpSession session, Agente agente) {
		if (session != null) {
			session.setAttribute("agente", agente);
		}
	}

	/***
	 * Cierra la sesión
	 * 
	 * @param session sesión a cerrar
	 */
	public void logout(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
	}

}
