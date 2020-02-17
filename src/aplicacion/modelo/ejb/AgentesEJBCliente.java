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

	public Agente validarAgente(String placa, String clave) {
		clienteRestAgentes.validarAgente(placa, clave);
		return clienteRestAgentes.agenteLogueado();
	}

}
