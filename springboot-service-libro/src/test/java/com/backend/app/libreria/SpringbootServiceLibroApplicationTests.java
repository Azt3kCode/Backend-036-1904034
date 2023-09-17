package com.backend.app.libreria;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.app.libro.entity.Libro;
import com.backend.app.libro.service.LibroRepository;

@SpringBootTest
class SpringbootServiceLibroApplicationTests {

    @Autowired
    private LibroRepository libroRepository;

    @Test
    void contextLoads() {
        assertNotNull(libroRepository);
    }

    @Test
    void createLibro() {
        Libro libro = new Libro("Nombre del Libro", 300, "Autor del Libro", "Editorial del Libro");
        Libro savedLibro = libroRepository.save(libro);
        assertNotNull(savedLibro);
        assertNotNull(savedLibro.getId());
    }

    @Test
    void findLibroById() {
        Libro libro = new Libro("Nombre del Libro", 300, "Autor del Libro", "Editorial del Libro");
        Libro savedLibro = libroRepository.save(libro);
        Long libroId = savedLibro.getId();

        Libro foundLibro = libroRepository.findById(libroId).orElse(null);
        assertNotNull(foundLibro);
    }
}
