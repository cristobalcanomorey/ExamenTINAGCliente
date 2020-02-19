package aplicacion.modelo.pojo;

import javax.xml.bind.annotation.XmlRootElement;

/***
 * Pojo con los datos de un agente
 * 
 * @author tofol
 *
 */
@XmlRootElement
public class Agente {

	private String numero_placa;
	private String rango;
	private String clave;
	private String nombre;
	private String apellidos;
	private Integer id_distrito;

	public Agente() {

	}

	public String getNumeroPlaca() {
		return numero_placa;
	}

	public void setNumeroPlaca(String numeroPlaca) {
		this.numero_placa = numeroPlaca;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getIdDistrito() {
		return id_distrito;
	}

	public void setIdDistrito(Integer idDistrito) {
		this.id_distrito = idDistrito;
	}

}
