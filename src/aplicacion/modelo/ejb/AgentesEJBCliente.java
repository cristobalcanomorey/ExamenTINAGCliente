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

	/***
	 * Obtiene el agente que coincide con esta placa y clave
	 * 
	 * @param placa Placa del agente
	 * @param clave Contraseña del agente
	 * @return Agente con esa placa y clave o null
	 */
	public Agente validarAgente(String placa, String clave) {
		return clienteRestAgentes.validarAgente(placa, clave);
	}

}
