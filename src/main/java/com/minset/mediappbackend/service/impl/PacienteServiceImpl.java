package com.minset.mediappbackend.service.impl;

import com.minset.mediappbackend.dao.IPacienteDAO;
import com.minset.mediappbackend.model.Paciente;
import com.minset.mediappbackend.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteDAO dao;
    @Override
    public Paciente registrar(Paciente paciente) {
        return dao.save(paciente);
    }

    @Override
    public void modificar(Paciente paciente) {
        dao.save(paciente);
    }

    @Override
    public void eliminar(int idPaciente) {
        dao.deleteById(idPaciente);
    }

    @Override
    public Optional<Paciente> listarId(int idPaciente) {
        return dao.findById(idPaciente);
    }

    @Override
    public List<Paciente> listar() {
        return dao.findAll();
    }
}
