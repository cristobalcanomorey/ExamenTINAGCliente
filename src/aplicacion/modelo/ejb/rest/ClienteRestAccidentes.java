package aplicacion.modelo.ejb.rest;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import aplicacion.modelo.pojo.Accidente;

@Singleton
@LocalBean
public class ClienteRestAccidentes {

	public Accidente getAccidente(String id) {
		Client cliente = ClientBuilder.newClient();

		WebTarget logueado = cliente.target("http://localhost:8080/SeguridadVial/Accidente/getAccidente?id=" + id);

		return logueado.request().get(Accidente.class);
	}
}
