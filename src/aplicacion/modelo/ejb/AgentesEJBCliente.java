package aplicacion.modelo.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import aplicacion.modelo.ejb.rest.ClienteRestAgentes;
import aplicacion.modelo.pojo.Agente;

@Singleton
@LocalBean
public class AgentesEJBCliente {

	@EJB
	ClienteRestAgentes clienteRestAgentes;

	public Agente loginAgente(String placa, String clave) {
		clienteRestAgentes.loginAgente(placa, clave);
		return clienteRestAgentes.agenteLogueado();
	}

	public Agente getAgenteLogueado() {
		return clienteRestAgentes.agenteLogueado();
	}

	public void logoutAgente() {
		clienteRestAgentes.logoutAgente();
	}

}
