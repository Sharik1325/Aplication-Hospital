package com.prueba.controller;

import java.util.Date;
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
import com.prueba.model.Medico;
import com.prueba.model.Paciente;
import com.prueba.repository.CitaRepository;
import com.prueba.repository.MedicoRepository;
import com.prueba.repository.PacienteRepository;

@RestController
@RequestMapping("/aplicacion/citasmedicas")
public class CitaController {

	@Autowired
	private CitaRepository citaRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private PacienteRepository pacienteRepository;

	@GetMapping("/citasprogramadas")
	private List<CitasMedica> citasprogramadas() {
		return citaRepository.findAll();
	}

	@PostMapping("/agregar")
	public CitasMedica agregarCita(@RequestBody CitasMedica citasMedicasRequest) {
		Medico medico = medicoRepository.findById(citasMedicasRequest.getMedico().getId()).get();
		Paciente paciente = pacienteRepository.findById(citasMedicasRequest.getPaciente().getId()).get();

		CitasMedica citasmedicas = new CitasMedica();
		citasmedicas.setMedico(medico);
		citasmedicas.setPaciente(paciente);
		citasmedicas.setFechaCita(new Date());
		citasmedicas.setHoraCita(citasMedicasRequest.getHoraCita());
		citaRepository.save(citasmedicas);

		/*
		 * LocalDate a =
		 * citasMedicasRequest.getFechaCita().toInstant().atZone(ZoneId.systemDefault())
		 * .toLocalDate(); System.out.println("----------->" + a);
		 */

		return citasMedicasRequest;

	}

	@DeleteMapping("/cancelarcita/{id}")
	public String cancelarCitas(@PathVariable long id) {
		CitasMedica citasDelete = citaRepository.findById(id).get();
		citaRepository.delete(citasDelete);
		return "OK";

	}

}
