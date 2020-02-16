package aplicacion.modelo.ejb;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import aplicacion.modelo.ejb.rest.ClienteRestAccidentes;
import aplicacion.modelo.pojo.Accidente;
import aplicacion.modelo.pojo.AccidenteConDistrito;
import aplicacion.modelo.pojo.Distrito;
import aplicacion.modelo.pojo.TiposAccidente;
import aplicacion.modelo.pojo.TiposSexo;
import aplicacion.modelo.pojo.TiposVehiculo;

@Singleton
@LocalBean
public class AccidentesEJBCliente {

	@EJB
	ClienteRestAccidentes clienteRestAccidentes;

	public ArrayList<AccidenteConDistrito> getAccidentesConDistrito() {
		return clienteRestAccidentes.getAccidentesConDistrito();
	}

	public Accidente getAccidente(String id) {
		return clienteRestAccidentes.getAccidente(id);
	}

	public void borraAccidente(String id) {
		clienteRestAccidentes.borraAccidente(id);
	}

	public ArrayList<Distrito> getDistritos() {
		return clienteRestAccidentes.getDistritos();
	}

	public ArrayList<TiposAccidente> getTiposAccidentes() {
		return clienteRestAccidentes.getTiposAccidentes();
	}

	public ArrayList<TiposSexo> getTiposSexos() {
		return clienteRestAccidentes.getTiposSexos();
	}

	public ArrayList<TiposVehiculo> getTiposVehiculos() {
		return clienteRestAccidentes.getTiposVehiculos();
	}

	public void insertAccidente(Accidente nuevo) {
		clienteRestAccidentes.insertAccidente(nuevo);
	}

}
