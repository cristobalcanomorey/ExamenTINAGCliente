package aplicacion.modelo.pojo;

public class FechaHora {

	private Integer idAccidente;
	private String fecha;
	private String hora;

	public FechaHora(Integer idAccidente, String fecha, String hora) {
		this.idAccidente = idAccidente;
		this.fecha = fecha;
		this.hora = hora.replace("24", "00");
	}

	public Integer getIdAccidente() {
		return idAccidente;
	}

	public void setIdAccidente(Integer idAccidente) {
		this.idAccidente = idAccidente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}
