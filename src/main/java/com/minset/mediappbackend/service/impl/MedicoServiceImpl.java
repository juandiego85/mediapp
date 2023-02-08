package com.minset.mediappbackend.service.impl;

import com.minset.mediappbackend.dao.IMedicoDAO;
import com.minset.mediappbackend.model.Medico;
import com.minset.mediappbackend.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements IMedicoService {
    @Autowired
    private IMedicoDAO dao;
    @Override
    public void registrar(Medico medico) {
        dao.save(medico);
    }

    @Override
    public void modificar(Medico medico) {
        dao.save(medico);
    }

    @Override
    public void eliminar(int idMedico) {
        dao.deleteById(idMedico);
    }

    @Override
    public Optional<Medico> listarId(int idMedico) {
        return dao.findById(idMedico);
    }

    @Override
    public List<Medico> listar() {
        return dao.findAll();
    }
}
