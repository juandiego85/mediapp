package com.minset.mediappbackend.service;

import com.minset.mediappbackend.model.Especialidad;

import java.util.List;
import java.util.Optional;


public interface IEspecialidadService {
    void registrar(Especialidad especialidad);

    void modificar(Especialidad especialidad);

    void eliminar(int idEspecialidad);

    Optional<Especialidad> listarId(int idEspecialidad);

    List<Especialidad> listar();
}
