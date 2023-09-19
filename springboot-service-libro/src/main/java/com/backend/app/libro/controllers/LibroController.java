package com.backend.app.libro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.backend.app.libro.entity.Libro;
import com.backend.app.libro.service.LibroService;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;
    
    @GetMapping("/list")
    public List<Libro> lista() {
        return libroService.obtenerTodosLosLibros();
    }
   
    @GetMapping("/libro/{id}")
    public Libro detalles(@PathVariable Long id) {
    	return libroService.obtenerLibroPorId(id);
    }
    
    @DeleteMapping("/libro/{id}")
    public Libro detallesD(@PathVariable Long id) {
    	return libroService.obtenerLibroPorId(id);
    }
    
    @PostMapping
    public Libro crearLibro(@RequestBody Libro nuevoLibro) {
        return libroService.crearLibro(nuevoLibro);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libroActualizado) {
        return libroService.actualizarLibro(id, libroActualizado);
    }
}
