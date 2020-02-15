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

	public void loginAgente(String placa, String clave) {
		Client cliente = ClientBuilder.newClient();
		WebTarget login = cliente.target("http://localhost:8080/SeguridadVial/Sesion/Login/" + placa + "/" + clave);
		login.request().post(null);
	}

	public Agente agenteLogueado() {
		Client cliente = ClientBuilder.newClient();
		WebTarget logueado = cliente.target("http://localhost:8080/SeguridadVial/Sesion/Logueado");
		Agente agente = logueado.request().get(Agente.class);
		return agente;
	}

	public void logoutAgente() {
		Client cliente = ClientBuilder.newClient();
		WebTarget logout = cliente.target("http://localhost:8080/SeguridadVial/Sesion/Logout");
		logout.request().get();
	}

}
