package com.minset.mediappbackend.dao;

import com.minset.mediappbackend.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExamenDAO extends JpaRepository<Examen,Integer> {
}
