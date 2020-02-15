package aplicacion.modelo.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Distrito {
	private Integer id;
	private String nombre;

	public Distrito() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
