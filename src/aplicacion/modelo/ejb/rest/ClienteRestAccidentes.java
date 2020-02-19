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

/***
 * Lógica de negocio para las peticiones al servicio rest de accidentes
 * 
 * @author tofol
 *
 */
@Singleton
@LocalBean
public class ClienteRestAccidentes {

	/***
	 * Token de autenticación
	 */
	private static final String TOKEN = "patata23";

	/***
	 * Url donde se encuentran los métodos del servicio rest
	 */
	private static final String URL = "http://localhost:8080/SeguridadVial/Accidente/";

	/***
	 * Realiza una petición GET a '/getAccidente' y devuelve el accidente con esa id
	 * 
	 * @param id Id del accidente
	 * @return Accidente con esa id
	 */
	public Accidente getAccidente(String id) {
		Client cliente = ClientBuilder.newClient();

		WebTarget logueado = cliente.target(URL + "getAccidente/" + TOKEN + "?id=" + id);

		return logueado.request().get(Accidente.class);
	}

	/***
	 * Realiza una petición GET a '/getAccidentesConDistritos' y devuelve una lista
	 * con todos los accidentes del distrito
	 * 
	 * @param idDistrito Id del distrito
	 * @return ArrayList con todos los accidentes en ese distrito
	 */
	public ArrayList<AccidenteConDistrito> getAccidentesConDistrito(String idDistrito) {
		Client cliente = ClientBuilder.newClient();

		WebTarget target = cliente.target(URL + "getAccidentesConDistritos/" + TOKEN + "?idDistrito=" + idDistrito);

		return (ArrayList<AccidenteConDistrito>) target.request().get(new GenericType<List<AccidenteConDistrito>>() {
		});
	}

	/***
	 * Realiza una petición DELETE a '/borraAccidente' para borrar su registro en la
	 * BBDD
	 * 
	 * @param id Id del accidente a borrar
	 */
	public void borraAccidente(String id) {
		Client cliente = ClientBuilder.newClient();

		WebTarget logueado = cliente.target(URL + "borraAccidente/" + TOKEN + "/" + id);

		logueado.request().delete();
	}

	/***
	 * Realiza una petición GET a '/getDistritos' y devuelve una lista con todos los
	 * distritos
	 * 
	 * @return ArrayList con todos los distritos
	 */
	public ArrayList<Distrito> getDistritos() {
		Client cliente = ClientBuilder.newClient();

		WebTarget target = cliente.target(URL + "getDistritos/" + TOKEN);

		return (ArrayList<Distrito>) target.request().get(new GenericType<List<Distrito>>() {
		});
	}

	/***
	 * Realiza una petición GET a '/getTiposAccidentes' y devuelve una lista con
	 * todos los tipos de accidentes
	 * 
	 * @return ArrayList con todos los tipos de accidentes
	 */
	public ArrayList<TiposAccidente> getTiposAccidentes() {
		Client cliente = ClientBuilder.newClient();

		WebTarget target = cliente.target(URL + "getTiposAccidentes/" + TOKEN);

		return (ArrayList<TiposAccidente>) target.request().get(new GenericType<List<TiposAccidente>>() {
		});
	}

	/***
	 * Realiza una petición GET a '/getTiposSexos' y devuelve una lista con todos
	 * los tipos de sexos
	 * 
	 * @return ArrayList con todos los tipos de sexos
	 */
	public ArrayList<TiposSexo> getTiposSexos() {
		Client cliente = ClientBuilder.newClient();

		WebTarget target = cliente.target(URL + "getTiposSexos/" + TOKEN);

		return (ArrayList<TiposSexo>) target.request().get(new GenericType<List<TiposSexo>>() {
		});
	}

	/***
	 * Realiza una petición GET a '/getTiposVehiculos' y devuelve una lista con
	 * todos los tipos de vehículos
	 * 
	 * @return ArrayList con todos los tipos de vehículos
	 */
	public ArrayList<TiposVehiculo> getTiposVehiculos() {
		Client cliente = ClientBuilder.newClient();

		WebTarget target = cliente.target(URL + "getTiposVehiculos/" + TOKEN);

		return (ArrayList<TiposVehiculo>) target.request().get(new GenericType<List<TiposVehiculo>>() {
		});
	}

	/***
	 * Realiza una petición PUT a '/insertAccidente' para insertar los datos de un
	 * accidente
	 * 
	 * @param nuevo El nuevo accidente insertado
	 */
	public void insertAccidente(Accidente nuevo) {
		Client cliente = ClientBuilder.newClient();

		WebTarget logueado = cliente.target(URL + "insertAccidente/" + TOKEN);

		logueado.request().put(Entity.json(nuevo), Accidente.class);
	}

	/***
	 * Realiza una petición PUT a '/updateAccidente' para actualizar los datos de un
	 * accidente
	 * 
	 * @param modificado El accidente modificado
	 */
	public void updateAccidente(Accidente modificado) {
		Client cliente = ClientBuilder.newClient();

		WebTarget logueado = cliente.target(URL + "updateAccidente/" + TOKEN);

		logueado.request().put(Entity.json(modificado), Accidente.class);
	}

}
