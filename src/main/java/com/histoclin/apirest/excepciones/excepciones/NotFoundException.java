package com.histoclin.apirest.excepciones.excepciones;

public class NotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public  NotFoundException(String mensaje) {
		super(mensaje);
	}
}
