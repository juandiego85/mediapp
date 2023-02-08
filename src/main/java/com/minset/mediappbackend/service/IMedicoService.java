package com.minset.mediappbackend.service;

import com.minset.mediappbackend.model.Medico;

import java.util.List;
import java.util.Optional;


public interface IMedicoService {
    void registrar(Medico medico);

    void modificar(Medico medico);

    void eliminar(int idMedico);

    Optional<Medico> listarId(int idMedico);

    List<Medico> listar();
}
