package com.minset.mediappbackend.dao;

import com.minset.mediappbackend.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicoDAO extends JpaRepository<Medico,Integer> {
}
