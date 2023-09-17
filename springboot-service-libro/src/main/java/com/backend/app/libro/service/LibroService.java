package com.backend.app.libro.service;

import java.util.List;

import com.backend.app.libro.entity.Libro;

public interface LibroService {
    List<Libro> obtenerTodosLosLibros();
    Libro obtenerLibroPorId(Long id);
}