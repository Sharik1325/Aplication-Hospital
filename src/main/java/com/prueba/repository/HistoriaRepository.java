package com.prueba.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.prueba.model.HistoriaClinica;

public interface HistoriaRepository extends JpaRepository<HistoriaClinica,Long>{

}
