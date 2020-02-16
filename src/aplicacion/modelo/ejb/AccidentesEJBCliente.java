package aplicacion.modelo.ejb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

	public ArrayList<AccidenteConDistrito> getAccidentesConDistrito(String idDistrito) {
		return clienteRestAccidentes.getAccidentesConDistrito(idDistrito);
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

	public void updateAccidente(Accidente modificado) {
		clienteRestAccidentes.updateAccidente(modificado);
	}

	public String fechaAString(Date fecha) {
		return new SimpleDateFormat("yyyy-MM-dd").format(fecha);
	}

	public String horaAString(Date hora) {
		return new SimpleDateFormat("kk:mm:ss").format(hora);
	}

	public Date stringAFecha(String fecha) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
	}

	public Date stringAHora(String hora) throws ParseException {
		return new SimpleDateFormat("kk:mm:ss").parse(hora);
	}

	public String fechaLegible(String fecha) throws ParseException {
		return fechaAString(stringAFecha(fecha));
	}

	public String horaLegible(String hora) throws ParseException {
		return horaAString(stringAHora(hora));
	}

}
