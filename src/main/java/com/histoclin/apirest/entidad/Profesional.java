package com.histoclin.apirest.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.histoclin.apirest.excepciones.excepciones.BadRequestException;
import com.histoclin.apirest.util.Mensajes;
import com.histoclin.apirest.util.Validador;

@Entity
@Table(name = "profesional")
public class Profesional {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "usaurio")
	private String usuario;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "contrasena")
	private String contrasena;

	@Column(name = "profesion")
	private String profesion;
	

	public void setId(Integer id) throws BadRequestException {
		Validador.numeroNulo(id, Mensajes.ID_PROFESIONAL_NULO);
		this.id=id;
	}

	// Se va a utiliza un patron builder
	private Profesional() {
		super();
	}
	
	public static class ProfesionalBuilder {

		private String usuario;
		private String nombre;
		private String apellido;
		private String contrasena;
		private String profesion;

		public ProfesionalBuilder setUsuario(String usuario) {
			this.usuario = usuario;
			return this;
		}

		public ProfesionalBuilder setNombre(String nombre) {
			this.nombre = nombre;
			return this;
		}

		public ProfesionalBuilder setApellido(String apellido) {
			this.apellido = apellido;
			return this;
		}

		public ProfesionalBuilder setContrasena(String contrasena) {
			this.contrasena = contrasena;
			return this;
		}

		public ProfesionalBuilder setProfesion(String profesion) {
			this.profesion = profesion;
			return this;
		}

		public Profesional build() throws BadRequestException {
			Profesional profesional = new Profesional();
			Validador.textoNulo(usuario, Mensajes.USUARIO_PROFESIONAL_NULO);
			Validador.textoVacio(usuario, Mensajes.USUARIO_PROFESIONAL_VACIO);
			profesional.usuario=usuario;
			
			Validador.textoNulo(nombre, Mensajes.NOMBRE_PROFESIONAL_NULO);
			Validador.textoVacio(nombre, Mensajes.NOMBRE_PROFESIONAL_VACIO);
			profesional.nombre=nombre;
			
			Validador.textoNulo(apellido, Mensajes.APELLIDO_PROFESIONAL_NULO);
			Validador.textoVacio(apellido, Mensajes.APELLIDO_PROFESIONAL_VACIO);
			profesional.apellido=apellido;
			
			Validador.textoNulo(contrasena, Mensajes.CONTRASENA_PROFESIONAL_NULO);
			Validador.textoVacio(contrasena, Mensajes.CONTRASENA_PROFESIONAL_VACIO);
			profesional.contrasena=contrasena;
			
			Validador.textoNulo(profesion, Mensajes.PROFESION_PROFESIONAL_NULO);
			Validador.textoVacio(profesion, Mensajes.APELLIDO_PROFESIONAL_VACIO);
			profesional.profesion=profesion;
			
			return profesional;
		}
	}

	public Integer getId() {
		return id;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getContrasena() {
		return contrasena;
	}

	public String getProfesion() {
		return profesion;
	}

}
