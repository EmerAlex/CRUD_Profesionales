package com.histoclin.apirest.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.histoclin.apirest.dto.ProfesionalDTO;
import com.histoclin.apirest.entidad.Profesional;
import com.histoclin.apirest.excepciones.excepciones.BadRequestException;
import com.histoclin.apirest.excepciones.excepciones.NotFoundException;
import com.histoclin.apirest.fabrica.ProfesionalFabrica;
import com.histoclin.apirest.repositorio.RepositorioProfesional;
import com.histoclin.apirest.servicio.ServicioProfesional;
import com.histoclin.apirest.util.Mensajes;

@Service
public class ImplementacionServicioProfesional implements ServicioProfesional {

	@Autowired
	private RepositorioProfesional repositorioProfesional;
	@Autowired
	private ProfesionalFabrica profesionalFabrica;

	@Override
	public Profesional buscarPorId(Integer id) throws NotFoundException {
		Profesional profesional = repositorioProfesional.findById(id).orElse(null);
		if(profesional != null) {
			return profesional;
		}else {
			throw new NotFoundException(Mensajes.PROFESIONAL_NO_ENCONTRADO);
		}
			
		
	}

	@Override
	public List<Profesional> buscarTodos() throws  NotFoundException {
		List<Profesional> profesionales = (List<Profesional>) repositorioProfesional.findAll();
		if(profesionales.isEmpty() || profesionales == null) {
			throw new NotFoundException(Mensajes.NO_HAY_REGISTRO_PROFESIONALES);
		}else {
			return profesionales;
		}
	}

	@Override
	public List<Profesional> buscarPorUsuario(String usuario) throws NotFoundException {
		List<Profesional> profesionales = repositorioProfesional.buscarPorUsuario(usuario);
		if(profesionales.isEmpty() || profesionales == null) {
			throw new NotFoundException(Mensajes.PROFESIONAL_NO_ENCONTRADO_CON_USUARIO);
		}else {
			return profesionales;
		}
	}

	@Override
	public String registrarProfesional(ProfesionalDTO profesionalDTO) throws BadRequestException {
		if (profesionalDTO != null && !existeUsuarioProfesional(profesionalDTO.getUsuario())) {
			repositorioProfesional.save(profesionalFabrica.convertiorDTOaEntidad(profesionalDTO));
			return Mensajes.PROFESIONAL_CREADO_CORRECTAMENTE;
		} else {
			throw new BadRequestException(Mensajes.PROFESIONAL_NULO);
		}
	}

	@Override
	public boolean existePorId(Integer id) throws NotFoundException {
		if(repositorioProfesional.existsById(id)) {
			return true;
		}else {
			throw new NotFoundException(Mensajes.PROFESIONAL_NO_ENCONTRADO);
		}
	}

	@Override
	public String editarProfesional(Integer id, ProfesionalDTO profesionalDTO) throws BadRequestException, NotFoundException {
		if (profesionalDTO != null && existePorId(id)) {
			repositorioProfesional.save(profesionalFabrica.actualizarEntidad(id, profesionalDTO));
			return Mensajes.PROFESIONAL_ACTUALIZADO_CORRECTAMENTE;
		} else {
			throw new BadRequestException(Mensajes.PROFESIONAL_NULO);
		}
	}
	
	public boolean existeUsuarioProfesional(String usuario) throws BadRequestException {
		List<Profesional> profesionales = repositorioProfesional.buscarPorUsuario(usuario);
		if(profesionales.isEmpty() || profesionales == null) {
			return false;
		}else {
			throw new BadRequestException(Mensajes.EXISTE_PROFESIONAL_CON_USUARIO);
		}
		
	}

}
