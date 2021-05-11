package com.histoclin.apirest.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.histoclin.apirest.dto.ProfesionalDTO;
import com.histoclin.apirest.entidad.Profesional;
import com.histoclin.apirest.excepciones.excepciones.BadRequestException;
import com.histoclin.apirest.excepciones.excepciones.NotFoundException;
import com.histoclin.apirest.fabrica.ProfesionalFabrica;
import com.histoclin.apirest.servicio.ServicioProfesional;

@RestController
@RequestMapping("/profesionales")
public class ProfesionalControlador {

	@Autowired
	ServicioProfesional servicioProfesional;
	@Autowired
	ProfesionalFabrica profesionalFabrica;

	@PostMapping()
	public String registarProfesional(@RequestBody ProfesionalDTO profesionalDTO) throws BadRequestException {
		return servicioProfesional.registrarProfesional(profesionalDTO);

	}

	@GetMapping("/buscarid/{idProfesional}")
	public ProfesionalDTO buscarPorId(@PathVariable Integer idProfesional)
			throws BadRequestException, NotFoundException {
		return profesionalFabrica.convertiorEntidadaDTO(servicioProfesional.buscarPorId(idProfesional));
	}

	@PutMapping("/editar/{idProfesional}")
	public String editarProfesional(@PathVariable Integer idProfesional, @RequestBody ProfesionalDTO profesionalDTO)
			throws BadRequestException, NotFoundException {
		return servicioProfesional.editarProfesional(idProfesional, profesionalDTO);

	}

	@GetMapping()
	public List<Profesional> listarUsaurio() throws  NotFoundException {
		return servicioProfesional.buscarTodos();
	}

	@GetMapping("/buscarusuario/{usuario}")
	public ProfesionalDTO buscarPorUsuario(@PathVariable String usuario) throws BadRequestException, NotFoundException {

		return profesionalFabrica.convertiorEntidadaDTO(servicioProfesional.buscarPorUsuario(usuario).get(0));
	}
}
