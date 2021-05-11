package com.histoclin.apirest.excepciones;

public class MensajeError {

	private String excepcion;
	private String mensaje;
	private String path;

	public MensajeError(Exception excepcion, String path) {
		super();
		this.excepcion = excepcion.getClass().getSimpleName();
		this.mensaje = excepcion.getMessage();
		this.path = path;
	}

	public String getExcepcion() {
		return excepcion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getPath() {
		return path;
	}

	@Override
	public String toString() {
		return "MensajeError{" + " excepcion ='" + excepcion + '\'' + ",mensaje='" + mensaje + '\'' + ",path='" + path
				+ '\'' + '}';
	}
	
}
