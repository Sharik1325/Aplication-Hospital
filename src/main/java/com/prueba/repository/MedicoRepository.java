package com.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.prueba.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
