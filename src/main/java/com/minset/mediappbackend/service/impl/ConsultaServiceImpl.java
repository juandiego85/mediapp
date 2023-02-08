package com.minset.mediappbackend.service.impl;

import com.minset.mediappbackend.dao.IConsultaDAO;
import com.minset.mediappbackend.model.Consulta;
import com.minset.mediappbackend.service.IConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements IConsultaService {
    @Autowired
    private IConsultaDAO dao;
    @Override
    public Consulta registrar(Consulta consulta) {
        consulta.getDetalleConsultaList().forEach(x -> x.setConsulta(consulta));
        return dao.save(consulta);
    }

    @Override
    public void modificar(Consulta consulta) {
        dao.save(consulta);
    }

    @Override
    public void eliminar(int idConsulta) {
        dao.deleteById(idConsulta);
    }

    @Override
    public Optional<Consulta> listarId(int idConsulta) {
        return dao.findById(idConsulta);
    }

    @Override
    public List<Consulta> listar() {
        return dao.findAll();
    }
}
