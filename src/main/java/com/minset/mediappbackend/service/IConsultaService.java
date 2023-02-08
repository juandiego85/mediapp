package com.minset.mediappbackend.service;
import com.minset.mediappbackend.model.Consulta;
import java.util.List;
import java.util.Optional;

public interface IConsultaService {
    Consulta registrar(Consulta consulta);

    void modificar(Consulta consulta);

    void eliminar(int idConsulta);

    Optional<Consulta> listarId(int idConsulta);

    List<Consulta> listar();
}
