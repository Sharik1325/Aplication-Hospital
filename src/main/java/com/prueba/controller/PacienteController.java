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

import com.prueba.model.Paciente;
import com.prueba.repository.PacienteRepository;

@RestController
@RequestMapping("/aplicacion/paciente")

public class PacienteController {

	@Autowired
	private PacienteRepository pacienteRepository;

	@GetMapping("/lista")
	public List<Paciente> listaPaciente() {
		return pacienteRepository.findAll();

	}

	@PostMapping("/agregar")
	public Paciente agregarPaciente(@RequestBody Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	@PutMapping("/modificar")
	public Paciente modificarPaciente(@RequestBody Paciente request) {
		Paciente pacienteUpdate = pacienteRepository.findById(request.getId()).get();
		pacienteUpdate.setEpsActual(request.getEpsActual());
		pacienteRepository.save(pacienteUpdate);
		return pacienteUpdate;

	}

	@DeleteMapping("/eliminar/{id}")
	public String eliminarPaciente(@PathVariable long id) {
		Paciente pacienteDelete = pacienteRepository.findById(id).get();
		pacienteRepository.delete(pacienteDelete);
		return "Ok";

	}

}
