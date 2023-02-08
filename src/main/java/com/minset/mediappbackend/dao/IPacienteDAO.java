package com.minset.mediappbackend.dao;

import com.minset.mediappbackend.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteDAO extends JpaRepository<Paciente,Integer> {
}
