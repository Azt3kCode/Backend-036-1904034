package com.backend.app.libreria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backend.app.libro.entity.Libro;

@SpringBootApplication
public class SpringbootServiceLibroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceLibroApplication.class, args);
		
		Libro libro = new Libro();

		libro.setNombre("El Gran Gatsby");
		libro.setNumeroPaginas(300); 
		libro.setAutor("F. Scott Fitzgerald");
		libro.setEditorial("Editorial XYZ");
	}

}