package com.minset.mediappbackend.service.impl;

import com.minset.mediappbackend.dao.IExamenDAO;
import com.minset.mediappbackend.model.Examen;
import com.minset.mediappbackend.service.IExamenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenServiceImpl implements IExamenService {
    private IExamenDAO dao;
    @Override
    public void registrar(Examen examen) {
        dao.save(examen);
    }

    @Override
    public void modificar(Examen examen) {
        dao.save(examen);
    }

    @Override
    public void eliminar(int idExamen) {
        dao.deleteById(idExamen);
    }

    @Override
    public Optional<Examen> listarId(int idExamen) {
        return dao.findById(idExamen);
    }

    @Override
    public List<Examen> listar() {
        return dao.findAll();
    }
}
