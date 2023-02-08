package com.minset.mediappbackend.dao;

import com.minset.mediappbackend.model.Consulta;
import com.minset.mediappbackend.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IConsultaDAO extends JpaRepository<Consulta,Integer> {
}
