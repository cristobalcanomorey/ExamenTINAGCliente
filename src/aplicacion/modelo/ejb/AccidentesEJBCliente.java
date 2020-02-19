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
import aplicacion.modelo.pojo.FechaHora;
import aplicacion.modelo.pojo.TiposAccidente;
import aplicacion.modelo.pojo.TiposSexo;
import aplicacion.modelo.pojo.TiposVehiculo;

/***
 * Lógica de negocio para los accidentes
 * 
 * @author tofol
 *
 */
@Singleton
@LocalBean
public class AccidentesEJBCliente {

	@EJB
	ClienteRestAccidentes clienteRestAccidentes;

	/***
	 * Obtiene una lista de 'AccidenteConDistrito' de un distrito
	 * 
	 * @param idDistrito Id del distrito
	 * @return ArrayList de 'AccidenteConDistrito'
	 */
	public ArrayList<AccidenteConDistrito> getAccidentesConDistrito(String idDistrito) {
		return clienteRestAccidentes.getAccidentesConDistrito(idDistrito);
	}

	/***
	 * Obtiene un accidente a partir de su id
	 * 
	 * @param id Id del accidente
	 * @return Accidente con esa id
	 */
	public Accidente getAccidente(String id) {
		return clienteRestAccidentes.getAccidente(id);
	}

	/***
	 * Borra el accidente que tenga esa id
	 * 
	 * @param id Id del accidente a borrar
	 */
	public void borraAccidente(String id) {
		clienteRestAccidentes.borraAccidente(id);
	}

	/***
	 * Obtiene una lista con todos los distritos
	 * 
	 * @return ArrayList con los distritos
	 */
	public ArrayList<Distrito> getDistritos() {
		return clienteRestAccidentes.getDistritos();
	}

	/***
	 * Obtiene una lista con los tipos de accidentes
	 * 
	 * @return ArrayList con los tipos de accidentes
	 */
	public ArrayList<TiposAccidente> getTiposAccidentes() {
		return clienteRestAccidentes.getTiposAccidentes();
	}

	/***
	 * Obtiene una lista con los tipos de sexos
	 * 
	 * @return ArrayList con los tipos de sexos
	 */
	public ArrayList<TiposSexo> getTiposSexos() {
		return clienteRestAccidentes.getTiposSexos();
	}

	/***
	 * Obtiene una lista con los tipos de vehiculos
	 * 
	 * @return ArrayList con los tipos de vehiculos
	 */
	public ArrayList<TiposVehiculo> getTiposVehiculos() {
		return clienteRestAccidentes.getTiposVehiculos();
	}

	/***
	 * Inserta un nuevo accidente
	 * 
	 * @param accidente El nuevo accidente
	 */
	public void insertAccidente(Accidente nuevo) {
		clienteRestAccidentes.insertAccidente(nuevo);
	}

	/***
	 * Modifica los datos del accidente que tenga la misma id que el accidente
	 * pasado por parametro
	 * 
	 * @param accidente Accidente con los datos modificados
	 */
	public void updateAccidente(Accidente modificado) {
		clienteRestAccidentes.updateAccidente(modificado);
	}

	/***
	 * Obtiene una fecha y la formatea a String
	 * 
	 * @param fecha Date
	 * @return String
	 */
	public String fechaAString(Date fecha) {
		return new SimpleDateFormat("yyyy-MM-dd").format(fecha);
	}

	/***
	 * Obtiene una hora y la formatea a String
	 * 
	 * @param hora Date
	 * @return String
	 */
	public String horaAString(Date hora) {
		return new SimpleDateFormat("kk:mm:ss").format(hora);
	}

	/***
	 * Obtiene una fecha String y la parsea a Date
	 * 
	 * @param fecha String
	 * @return Date
	 * @throws ParseException Error si no consigue parsearla
	 */
	public Date stringAFecha(String fecha) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
	}

	/***
	 * Obtiene una hora String y la parsea a Date
	 * 
	 * @param hora String
	 * @return Date
	 * @throws ParseException Error si no consigue parsearla
	 */
	public Date stringAHora(String hora) throws ParseException {
		return new SimpleDateFormat("kk:mm:ss").parse(hora);
	}

	/***
	 * Formatea una fecha y una hora y devuelve un FechaHora
	 * 
	 * @param id Id del accidente
	 * @param f  Fecha Date
	 * @param h  Hora Date
	 * @return FechaHora
	 */
	public FechaHora getFechaYHora(Integer id, Date f, Date h) {
		String fecha = fechaAString(f);
		String hora = horaAString(h);
		return new FechaHora(id, fecha, hora);
	}

	/***
	 * Obtiene una lista de accidentes y devuelve una lista con sus fechas y horas
	 * formateadas a String y guardadas en una lista de FechaHora
	 * 
	 * @param accidentesConDistritos ArrayList con los accidentes
	 * @return ArrayList con las fechas y horas
	 */
	public ArrayList<FechaHora> getFechasYHoras(ArrayList<AccidenteConDistrito> accidentesConDistritos) {
		ArrayList<FechaHora> fechasYHoras = new ArrayList<FechaHora>();
		for (AccidenteConDistrito acd : accidentesConDistritos) {
			fechasYHoras.add(getFechaYHora(acd.getId(), acd.getFecha(), acd.getHora()));
		}
		return fechasYHoras;
	}

}
