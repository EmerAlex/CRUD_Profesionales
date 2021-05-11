package com.histoclin.apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesionalDTO {
	
	private String usuario;
	private String nombre;
	private String apellido;
	private String contrasena;
	private String profesion;
	
}
