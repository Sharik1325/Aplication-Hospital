package com.prueba.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the medico database table.
 * 
 */
@Entity
@NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "bigserial")
	private Long id;

	@Column(name = "anios_experiencia")
	private String aniosExperiencia;

	@Column(name = "especialidad")
	private String especialidad;

	@Column(name = "fin_atencion")
	private String finAtencion;

	@Column(name = "inicio_atencion")
	private String inicioAtencion;

	@Column(name = "tarjeta_profesional")
	private String tarjetaProfesional;

	// bi-directional many-to-one association to CitasMedica
	@OneToMany(mappedBy = "medico")
	private List<CitasMedica> citasMedicas;

	// bi-directional many-to-one association to Persona
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_persona")
	private Persona persona;

	public Medico() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAniosExperiencia() {
		return this.aniosExperiencia;
	}

	public void setAniosExperiencia(String aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getFinAtencion() {
		return this.finAtencion;
	}

	public void setFinAtencion(String finAtencion) {
		this.finAtencion = finAtencion;
	}

	public String getInicioAtencion() {
		return this.inicioAtencion;
	}

	public void setInicioAtencion(String inicioAtencion) {
		this.inicioAtencion = inicioAtencion;
	}

	public String getTarjetaProfesional() {
		return this.tarjetaProfesional;
	}

	public void setTarjetaProfesional(String tarjetaProfesional) {
		this.tarjetaProfesional = tarjetaProfesional;
	}

	public List<CitasMedica> getCitasMedicas() {
		return this.citasMedicas;
	}

	public void setCitasMedicas(List<CitasMedica> citasMedicas) {
		this.citasMedicas = citasMedicas;
	}

	public CitasMedica addCitasMedica(CitasMedica citasMedica) {
		getCitasMedicas().add(citasMedica);
		citasMedica.setMedico(this);

		return citasMedica;
	}

	public CitasMedica removeCitasMedica(CitasMedica citasMedica) {
		getCitasMedicas().remove(citasMedica);
		citasMedica.setMedico(null);

		return citasMedica;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}