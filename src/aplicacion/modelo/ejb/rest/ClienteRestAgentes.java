package aplicacion.modelo.ejb.rest;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import aplicacion.modelo.pojo.Agente;

/***
 * Lógica de negocio para las peticiones al servicio rest de agentes
 * 
 * @author tofol
 *
 */
@Singleton
@LocalBean
public class ClienteRestAgentes {

	/***
	 * Token de autenticación
	 */
	private static final String TOKEN = "patata23";

	/***
	 * Url donde se encuentran los métodos del servicio rest
	 */
	private static final String URL = "http://localhost:8080/SeguridadVial/Agentes/";

	/***
	 * Realiza una petición GET a '/Validar' y devuelve el agente que coincida con
	 * esta clave y placa
	 * 
	 * @param placa Placa del agente
	 * @param clave Contraseña del agente
	 * @return Agente con esa placa y clave
	 */
	public Agente validarAgente(String placa, String clave) {
		Client cliente = ClientBuilder.newClient();
		WebTarget login = cliente.target(URL + "Validar/" + TOKEN + "/" + placa + "/" + clave);
		return login.request().get(Agente.class);
	}

	/***
	 * Realiza una petición GET a '/Logueado' y devuelve el agente que está logueado
	 * en el servidor REST
	 * 
	 * @return Agente logueado
	 */
	public Agente agenteLogueado() {
		Client cliente = ClientBuilder.newClient();
		WebTarget logueado = cliente.target(URL + "Logueado/" + TOKEN);
		return logueado.request().get(Agente.class);
	}

	/***
	 * Realiza una petición GET a '/Logout' y cierra la sesión en el servidor REST
	 */
	public void logoutAgente() {
		Client cliente = ClientBuilder.newClient();
		WebTarget logout = cliente.target(URL + "Logout/" + TOKEN);
		logout.request().get();
	}

}
