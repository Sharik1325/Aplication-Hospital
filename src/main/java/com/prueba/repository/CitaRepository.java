package com.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.prueba.model.CitasMedica;


public interface CitaRepository extends JpaRepository<CitasMedica,Long>{

}
