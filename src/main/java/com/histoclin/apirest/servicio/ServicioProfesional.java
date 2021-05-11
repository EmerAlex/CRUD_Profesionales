package com.histoclin.apirest.servicio;

import java.util.List;

import com.histoclin.apirest.dto.ProfesionalDTO;
import com.histoclin.apirest.entidad.Profesional;
import com.histoclin.apirest.excepciones.excepciones.BadRequestException;
import com.histoclin.apirest.excepciones.excepciones.NotFoundException;


public interface ServicioProfesional {
	
	String registrarProfesional (ProfesionalDTO profesionalDTO) throws BadRequestException;
	Profesional buscarPorId (Integer id) throws NotFoundException;
	List<Profesional> buscarTodos() throws  NotFoundException;
	List<Profesional> buscarPorUsuario(String usaurio) throws NotFoundException;
	boolean existePorId(Integer id) throws NotFoundException;
	String editarProfesional (Integer id, ProfesionalDTO profesionalDTO) throws BadRequestException, NotFoundException;

}
