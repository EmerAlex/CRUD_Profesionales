package com.histoclin.apirest.util;

import com.histoclin.apirest.excepciones.excepciones.BadRequestException;

public class Validador {
	
	public static void textoNulo(String texto, String mensaje) throws BadRequestException {
		if(texto == null) {
			throw new BadRequestException(mensaje);
		}
	}
	
	public static void textoVacio(String texto, String mensaje) throws BadRequestException {
		if(texto.trim().equals("")) {
			throw new BadRequestException(mensaje);
		}
	}
	public static void numeroNulo(Integer numero, String mensaje) throws BadRequestException {
		if(numero == null || numero==0) {
			throw new BadRequestException(mensaje);
		}
	}

}
