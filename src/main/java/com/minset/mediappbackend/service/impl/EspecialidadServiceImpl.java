package com.minset.mediappbackend.service.impl;

import com.minset.mediappbackend.dao.IEspecialidadDAO;
import com.minset.mediappbackend.model.Especialidad;
import com.minset.mediappbackend.service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {
    @Autowired
    private IEspecialidadDAO dao;
    @Override
    public void registrar(Especialidad especialidad) {
        dao.save(especialidad);
    }

    @Override
    public void modificar(Especialidad especialidad) {
        dao.save(especialidad);
    }

    @Override
    public void eliminar(int idEspecialidad) {
        dao.deleteById(idEspecialidad);
    }

    @Override
    public Optional<Especialidad> listarId(int idEspecialidad) {
        return dao.findById(idEspecialidad);
    }

    @Override
    public List<Especialidad> listar() {
        return dao.findAll();
    }
}
