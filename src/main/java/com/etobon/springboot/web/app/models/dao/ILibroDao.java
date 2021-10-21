package com.etobon.springboot.web.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.etobon.springboot.web.app.models.entity.Libro;

public interface ILibroDao extends CrudRepository<Libro, Long> {
	
	@Query("select l from Libro l where l.title like %?1%")
	public List<Libro> findByNombre(String nombreLibro);
	
}
