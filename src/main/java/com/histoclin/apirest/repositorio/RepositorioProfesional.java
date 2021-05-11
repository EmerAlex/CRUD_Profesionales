package com.histoclin.apirest.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.histoclin.apirest.entidad.Profesional;


@Repository
public interface RepositorioProfesional extends CrudRepository<Profesional, Integer> {
	
	@Query( value = "SELECT * FROM PROFESIONAL  WHERE usaurio LIKE %:usaurio%",   nativeQuery = true)
	List<Profesional> buscarPorUsuario(@Param ("usaurio") String usuario);
	
	
	
}
