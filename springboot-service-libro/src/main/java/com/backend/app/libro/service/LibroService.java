package com.backend.app.libro.service;

import com.backend.app.libro.entity.Libro;
import java.util.List;

public interface LibroService {
	public List<Libro> obtenerTodosLosLibros();
    public Libro obtenerLibroPorId(Long id);
	public Libro crearLibro(Libro nuevoLibro);
	public Libro actualizarLibro(Long id, Libro libroActualizado);
	void eliminarLibro(Long id);
}