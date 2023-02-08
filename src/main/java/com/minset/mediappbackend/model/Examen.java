package com.minset.mediappbackend.model;

import jakarta.persistence.*;

@Entity
@Table
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExamen;
    @Column(name = "nombre",nullable = false,length = 50)
    private String nombre;
    @Column(name = "descripcion",nullable = false,length = 250)
    private String descripcion;

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
