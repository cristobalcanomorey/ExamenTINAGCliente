package aplicacion.modelo.pojo;

import java.text.ParseException;

import javax.ejb.EJB;
import javax.xml.bind.annotation.XmlRootElement;

import aplicacion.modelo.ejb.AccidentesEJBCliente;

@XmlRootElement
public class AccidenteConDistritoEnStrings {
	private Integer id;
	private String fecha;
	private String hora;
	private String expediente;
	private String distrito;

	@EJB
	AccidentesEJBCliente accidentesEJBCliente;

	public AccidenteConDistritoEnStrings(AccidenteConDistrito acd, String fecha, String hora) throws ParseException {
		this.id = acd.getId();
		this.expediente = acd.getExpediente();
		this.distrito = acd.getDistrito();
		this.fecha = accidentesEJBCliente.fechaLegible(fecha);
		this.hora = accidentesEJBCliente.horaLegible(hora);
	}

	public Integer getId() {
		return id;
	}

	public String getFecha() {
		return fecha;
	}

	public String getHora() {
		return hora;
	}

	public String getExpediente() {
		return expediente;
	}

	public String getDistrito() {
		return distrito;
	}

}
