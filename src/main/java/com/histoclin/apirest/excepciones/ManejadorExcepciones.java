package com.histoclin.apirest.excepciones;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.histoclin.apirest.excepciones.excepciones.BadRequestException;
import com.histoclin.apirest.excepciones.excepciones.NotFoundException;

@ControllerAdvice
public class ManejadorExcepciones {

	@ResponseStatus (HttpStatus.BAD_REQUEST)
	@ExceptionHandler({
		BadRequestException.class
	})
	@ResponseBody
	public MensajeError badRequest (HttpServletRequest request, Exception excepcion) {
		return new MensajeError(excepcion, request.getRequestURI());
	}
	
	@ResponseStatus (HttpStatus.NOT_FOUND)
	@ExceptionHandler({
		NotFoundException.class
	})
	@ResponseBody
	public MensajeError notFound (HttpServletRequest request, Exception excepcion) {
		return new MensajeError(excepcion, request.getRequestURI());
	}
}
