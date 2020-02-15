package aplicacion.modelo.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

import aplicacion.modelo.pojo.Agente;

@Stateless
@LocalBean
public class SesionesEJB {

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

	public void loginAgente(HttpSession session, Agente agente) {
		if (session != null) {
			session.setAttribute("agente", agente);
		}
	}

}
