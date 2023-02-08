package com.minset.mediappbackend.service;

import com.minset.mediappbackend.model.Examen;

import java.util.List;
import java.util.Optional;


public interface IExamenService {
    void registrar(Examen examen);

    void modificar(Examen examen);

    void eliminar(int idExamen);

    Optional<Examen> listarId(int idExamen);

    List<Examen> listar();
}
