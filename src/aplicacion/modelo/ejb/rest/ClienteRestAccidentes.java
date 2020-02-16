package aplicacion.modelo.ejb.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import aplicacion.modelo.pojo.Accidente;
import aplicacion.modelo.pojo.AccidenteConDistrito;
import aplicacion.modelo.pojo.Distrito;
import aplicacion.modelo.pojo.TiposAccidente;
import aplicacion.modelo.pojo.TiposSexo;
import aplicacion.modelo.pojo.TiposVehiculo;

@Singleton
@LocalBean
public class ClienteRestAccidentes {

	public Accidente getAccidente(String id) {
		Client cliente = ClientBuilder.newClient();

		WebTarget logueado = cliente.target("http://localhost:8080/SeguridadVial/Accidente/getAccidente?id=" + id);

		return logueado.request().get(Accidente.class);
	}

	public ArrayList<AccidenteConDistrito> getAccidentesConDistrito() {
		Client cliente = ClientBuilder.newClient();

		WebTarget target = cliente.target("http://localhost:8080/SeguridadVial/Accidente/getAccidentesConDistritos");

		return (ArrayList<AccidenteConDistrito>) target.request().get(new GenericType<List<AccidenteConDistrito>>() {
		});
	}

	public void borraAccidente(String id) {
		Client cliente = ClientBuilder.newClient();

		WebTarget logueado = cliente.target("http://localhost:8080/SeguridadVial/Accidente/borraAccidente/" + id);

		logueado.request().delete();
	}

	public ArrayList<Distrito> getDistritos() {
		Client cliente = ClientBuilder.newClient();

		WebTarget target = cliente.target("http://localhost:8080/SeguridadVial/Accidente/getDistritos");

		return (ArrayList<Distrito>) target.request().get(new GenericType<List<Distrito>>() {
		});
	}

	public ArrayList<TiposAccidente> getTiposAccidentes() {
		Client cliente = ClientBuilder.newClient();

		WebTarget target = cliente.target("http://localhost:8080/SeguridadVial/Accidente/getTiposAccidentes");

		return (ArrayList<TiposAccidente>) target.request().get(new GenericType<List<TiposAccidente>>() {
		});
	}

	public ArrayList<TiposSexo> getTiposSexos() {
		Client cliente = ClientBuilder.newClient();

		WebTarget target = cliente.target("http://localhost:8080/SeguridadVial/Accidente/getTiposSexos");

		return (ArrayList<TiposSexo>) target.request().get(new GenericType<List<TiposSexo>>() {
		});
	}

	public ArrayList<TiposVehiculo> getTiposVehiculos() {
		Client cliente = ClientBuilder.newClient();

		WebTarget target = cliente.target("http://localhost:8080/SeguridadVial/Accidente/getTiposVehiculos");

		return (ArrayList<TiposVehiculo>) target.request().get(new GenericType<List<TiposVehiculo>>() {
		});
	}

	public void insertAccidente(Accidente nuevo) {
		Client cliente = ClientBuilder.newClient();

		WebTarget logueado = cliente.target("http://localhost:8080/SeguridadVial/Accidente/insertAccidente");

		logueado.request().put(Entity.json(nuevo), Accidente.class);
	}

}
