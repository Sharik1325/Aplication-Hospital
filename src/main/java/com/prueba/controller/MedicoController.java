package com.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.model.Medico;
import com.prueba.repository.MedicoRepository;

@RestController
@RequestMapping("/aplicacion/medico")
public class MedicoController {

	@Autowired
	private MedicoRepository medicoRepository;

	@GetMapping("/lista")
	public List<Medico> listaMedicos() {
		return medicoRepository.findAll();

	}

	@PostMapping("/agregar")
	public Medico agregarMedico(@RequestBody Medico medico) { // El post tiene body
		return medicoRepository.save(medico);
	}

	@PutMapping("/editar")
	public Medico editarMedico(@RequestBody Medico request) {
		Medico medicoUpdate = medicoRepository.findById(request.getId()).get();
		medicoUpdate.setAniosExperiencia(request.getAniosExperiencia());
		medicoUpdate.setEspecialidad(request.getEspecialidad());
		medicoUpdate.setInicioAtencion(request.getInicioAtencion());
		medicoUpdate.setFinAtencion(request.getFinAtencion());
		medicoRepository.save(medicoUpdate);
		return medicoUpdate;

	}

	@DeleteMapping("/borrar/{id}")
	public String borrarMedico(@PathVariable long id) {
		Medico medicoDelete = medicoRepository.findById(id).get();
		medicoRepository.delete(medicoDelete);
		return "OK";

	}
}
