package com.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.model.CitasMedica;
import com.prueba.model.HistoriaClinica;
import com.prueba.repository.CitaRepository;
import com.prueba.repository.HistoriaRepository;

@RestController
@RequestMapping("/aplicacion/historia")

public class HistoriaController {
	@Autowired
	private HistoriaRepository hitoriaRepository;
	@Autowired
	private CitaRepository citaRepository;

	@GetMapping("/mostrar")
	private List<HistoriaClinica> listaHistoria() {
		return hitoriaRepository.findAll();

	}

	@PostMapping("/agregar")
	public HistoriaClinica agregarHistoria(@RequestBody HistoriaClinica historiaRequest) {

		CitasMedica cita = citaRepository.findById(historiaRequest.getCitasMedica().getId()).get();
		HistoriaClinica historia = new HistoriaClinica();
		historia.setCitasMedica(cita);
		historia.setDiagnostico(historiaRequest.getDiagnostico());
		hitoriaRepository.save(historia);
		return historiaRequest;

	}
	
	@DeleteMapping("/cancelarhistoria/{id}")
	public String cancelarhistoria(@PathVariable long id) {
		HistoriaClinica historiaDelete = hitoriaRepository.findById(id).get();
		hitoriaRepository.delete(historiaDelete);
		return "OK";

	}


}
