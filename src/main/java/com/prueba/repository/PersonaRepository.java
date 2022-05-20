package com.prueba.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.prueba.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
