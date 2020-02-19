package aplicacion.modelo.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/***
 * Pojo con los datos de un accidente
 * 
 * @author tofol
 *
 */
@XmlRootElement
public class Accidente {
	private Integer id;
	private String expediente;
	private Date fecha;
	private Date hora;
	private String direccion;
	private Integer id_distrito;
	private Integer id_tipo_accidente;
	private Integer id_tipo_vehiculo;
	private Integer id_sexo;

	public Accidente() {

	}

	public Accidente(Integer id, String expediente, Date fecha, Date hora, String direccion, Integer id_distrito,
			Integer id_tipo_accidente, Integer id_tipo_vehiculo, Integer id_sexo) {
		this.id = id;
		this.expediente = expediente;
		this.fecha = fecha;
		this.hora = hora;
		this.direccion = direccion;
		this.id_distrito = id_distrito;
		this.id_tipo_accidente = id_tipo_accidente;
		this.id_tipo_vehiculo = id_tipo_vehiculo;
		this.id_sexo = id_sexo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExpediente() {
		return expediente;
	}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getIdDistrito() {
		return id_distrito;
	}

	public void setIdDistrito(Integer idDistrito) {
		this.id_distrito = idDistrito;
	}

	public Integer getIdTipoAccidente() {
		return id_tipo_accidente;
	}

	public void setIdTipoAccidente(Integer idTipoAccidente) {
		this.id_tipo_accidente = idTipoAccidente;
	}

	public Integer getIdTipoVehiculo() {
		return id_tipo_vehiculo;
	}

	public void setIdTipoVehiculo(Integer idTipoVehiculo) {
		this.id_tipo_vehiculo = idTipoVehiculo;
	}

	public Integer getIdSexo() {
		return id_sexo;
	}

	public void setIdSexo(Integer idSexo) {
		this.id_sexo = idSexo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

}
