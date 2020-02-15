package aplicacion.modelo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplicacion.controlador.Accidentes;
import aplicacion.controlador.ActualizarAccidente;
import aplicacion.controlador.CrearAccidente;
import aplicacion.controlador.EliminarAccidente;
import aplicacion.controlador.Principal;

public class LogSingleton {
	private static final LogSingleton INSTANCE = new LogSingleton();
	private Logger loggerAccidentes = LoggerFactory.getLogger(Accidentes.class);
	private Logger loggerActualizarAccidente = LoggerFactory.getLogger(ActualizarAccidente.class);
	private Logger loggerCrearAccidente = LoggerFactory.getLogger(CrearAccidente.class);
	private Logger loggerEliminarAccidente = LoggerFactory.getLogger(EliminarAccidente.class);
	private Logger loggerPrincipal = LoggerFactory.getLogger(Principal.class);

	private LogSingleton() {

	}

	public static LogSingleton getInstance() {
		return INSTANCE;
	}

	public Logger getLoggerMyBatisUtil() {
		return loggerAccidentes;
	}

	public Logger getLoggerAccidentes() {
		return loggerAccidentes;
	}

	public void setLoggerAccidentes(Logger loggerAccidentes) {
		this.loggerAccidentes = loggerAccidentes;
	}

	public Logger getLoggerActualizarAccidente() {
		return loggerActualizarAccidente;
	}

	public void setLoggerActualizarAccidente(Logger loggerActualizarAccidente) {
		this.loggerActualizarAccidente = loggerActualizarAccidente;
	}

	public Logger getLoggerCrearAccidente() {
		return loggerCrearAccidente;
	}

	public void setLoggerCrearAccidente(Logger loggerCrearAccidente) {
		this.loggerCrearAccidente = loggerCrearAccidente;
	}

	public Logger getLoggerEliminarAccidente() {
		return loggerEliminarAccidente;
	}

	public void setLoggerEliminarAccidente(Logger loggerEliminarAccidente) {
		this.loggerEliminarAccidente = loggerEliminarAccidente;
	}

	public Logger getLoggerPrincipal() {
		return loggerPrincipal;
	}

	public void setLoggerPrincipal(Logger loggerPrincipal) {
		this.loggerPrincipal = loggerPrincipal;
	}

}
