package com.minset.mediappbackend.service;

import com.minset.mediappbackend.model.Paciente;

import java.util.List;
import java.util.Optional;


public interface IPacienteService {
    Paciente registrar(Paciente paciente);

    void modificar(Paciente paciente);

    void eliminar(int idPaciente);

    Optional<Paciente> listarId(int idPaciente);

    List<Paciente> listar();
}
