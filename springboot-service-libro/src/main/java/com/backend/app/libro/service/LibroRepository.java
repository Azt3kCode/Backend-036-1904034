package com.backend.app.libro.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.app.libro.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
	
}