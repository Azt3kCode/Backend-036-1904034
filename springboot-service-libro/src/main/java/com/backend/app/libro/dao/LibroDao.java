package com.backend.app.libro.dao;

import org.springframework.data.repository.CrudRepository;
import com.backend.app.libro.entity.Libro;

public interface LibroDao extends CrudRepository<Libro, Long> {
	
}
