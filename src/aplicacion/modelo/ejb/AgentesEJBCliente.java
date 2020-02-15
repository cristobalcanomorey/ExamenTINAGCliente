package aplicacion.modelo.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.servlet.http.HttpSession;

import aplicacion.modelo.ejb.rest.ClienteRestAgentes;
import aplicacion.modelo.pojo.Agente;

@Singleton
@LocalBean
public class AgentesEJBCliente {

	@EJB
	ClienteRestAgentes clienteRestAgentes;

	@EJB
	SesionesEJBCliente sesionesEJB;

	public Agente loginAgente(HttpSession session, String placa, String clave) {
		Agente logueado = clienteRestAgentes.loginAgente(placa, clave);
		sesionesEJB.loginAgente(session, logueado);
		return logueado;
	}

	public void logoutAgente() {
		clienteRestAgentes.logoutAgente();
	}

}
