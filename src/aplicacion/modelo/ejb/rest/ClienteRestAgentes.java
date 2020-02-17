package aplicacion.modelo.ejb.rest;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import aplicacion.modelo.pojo.Agente;

@Singleton
@LocalBean
public class ClienteRestAgentes {

	private static final String TOKEN = "patata23";

	private static final String URL = "http://localhost:8080/SeguridadVial/Agentes/";

	public Agente validarAgente(String placa, String clave) {
		Client cliente = ClientBuilder.newClient();
		WebTarget login = cliente.target(URL + "Validar/" + TOKEN + "/" + placa + "/" + clave);
		return login.request().get(Agente.class);
	}

	public Agente agenteLogueado() {
		Client cliente = ClientBuilder.newClient();
		WebTarget logueado = cliente.target(URL + "Logueado");
		Agente agente = logueado.request().get(Agente.class);
		return agente;
	}

	public void logoutAgente() {
		Client cliente = ClientBuilder.newClient();
		WebTarget logout = cliente.target(URL + "Logout");
		logout.request().get();
	}

}
