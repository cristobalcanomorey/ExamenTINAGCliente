package aplicacion.modelo.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

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

}
