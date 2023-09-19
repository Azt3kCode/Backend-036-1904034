package com.backend.app.libro.service;

import com.backend.app.libro.dao.LibroDao;
import com.backend.app.libro.entity.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired 
    private LibroDao libroDao;

    @Override
    @Transactional(readOnly = true)
    public List<Libro> obtenerTodosLosLibros() {
        return (List<Libro>) libroDao.findAll();
    }

    @Override
    public Libro obtenerLibroPorId(Long id) {
        return libroDao.findById(id).orElse(null);
    }

    @Override
    public Libro crearLibro(Libro nuevoLibro) {
        return libroDao.save(nuevoLibro);
    }

    @Override
    public Libro actualizarLibro(Long id, Libro libroActualizado) {
        Libro libroExistente = libroDao.findById(id).orElse(null);

        if (libroExistente == null) {
            throw new IllegalArgumentException("Libro no encontrado");
        }

        libroExistente.setNombre(libroActualizado.getNombre());
        libroExistente.setNumeroPaginas(libroActualizado.getNumeroPaginas());
        libroExistente.setAutor(libroActualizado.getAutor());
        libroExistente.setEditorial(libroActualizado.getEditorial());

        return libroDao.save(libroExistente);
    }

    @Override
    public void eliminarLibro(Long id) {
        libroDao.deleteById(id);
    }
}
