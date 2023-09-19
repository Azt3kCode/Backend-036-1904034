package com.backend.app.libro.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Getter
@Setter

@Entity
@Table(name = "libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    
    @Column(name = "numero_paginas")
    private int numeroPaginas;
    
    private String autor;
    private String editorial;
    
    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    public Libro() {
    }

    public Libro(String nombre, int numeroPaginas, String autor, String editorial) {
        this.nombre = nombre;
        this.numeroPaginas = numeroPaginas;
        this.autor = autor;
        this.editorial = editorial;
    }    
    
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    public Date getCreateAt() {
        return createAt;
    }
}