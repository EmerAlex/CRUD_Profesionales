package com.histoclin.apirest.fabrica;

import org.springframework.stereotype.Component;

import com.histoclin.apirest.dto.ProfesionalDTO;
import com.histoclin.apirest.entidad.Profesional;
import com.histoclin.apirest.excepciones.excepciones.BadRequestException;

@Component
public class ProfesionalFabrica {

	public Profesional convertiorDTOaEntidad(ProfesionalDTO profesionalDTO) throws BadRequestException {
		Profesional profesional = new Profesional.ProfesionalBuilder().setUsuario(profesionalDTO.getUsuario())
				.setNombre(profesionalDTO.getNombre()).setApellido(profesionalDTO.getApellido())
				.setContrasena(profesionalDTO.getContrasena()).setProfesion(profesionalDTO.getProfesion()).build();

		return profesional;
	}
	public Profesional actualizarEntidad(Integer id,ProfesionalDTO profesionalDTO) throws BadRequestException {
		Profesional profesional = new Profesional.ProfesionalBuilder().setUsuario(profesionalDTO.getUsuario())
				.setNombre(profesionalDTO.getNombre()).setApellido(profesionalDTO.getApellido())
				.setContrasena(profesionalDTO.getContrasena()).setProfesion(profesionalDTO.getProfesion()).build();
		profesional.setId(id);
		return profesional;
	}

	public ProfesionalDTO convertiorEntidadaDTO(Profesional profesional) throws BadRequestException {
		ProfesionalDTO profesionalDTO = new ProfesionalDTO();
		profesionalDTO.setUsuario(profesional.getUsuario());
		profesionalDTO.setNombre(profesional.getNombre());
		profesionalDTO.setApellido(profesional.getApellido());
		profesionalDTO.setContrasena(profesional.getContrasena());
		profesionalDTO.setProfesion(profesional.getProfesion());

		return profesionalDTO;
	}

}
