package com.prueba.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the paciente dataFbase table.
 * 
 */
@Entity
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition = "bigserial")
	private Long id;

	@Column(name="eps_actual")
	private String epsActual;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	//bi-directional many-to-one association to CitasMedica
	@OneToMany(mappedBy="paciente")
	private List<CitasMedica> citasMedicas;

	//bi-directional many-to-one association to Persona
	
	@ManyToOne(cascade = CascadeType.ALL)//validar
	@JoinColumn(name="id_persona")
	private Persona persona;

	public Paciente() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEpsActual() {
		return this.epsActual;
	}

	public void setEpsActual(String epsActual) {
		this.epsActual = epsActual;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<CitasMedica> getCitasMedicas() {
		return this.citasMedicas;
	}

	public void setCitasMedicas(List<CitasMedica> citasMedicas) {
		this.citasMedicas = citasMedicas;
	}

	public CitasMedica addCitasMedica(CitasMedica citasMedica) {
		getCitasMedicas().add(citasMedica);
		citasMedica.setPaciente(this);

		return citasMedica;
	}

	public CitasMedica removeCitasMedica(CitasMedica citasMedica) {
		getCitasMedicas().remove(citasMedica);
		citasMedica.setPaciente(null);

		return citasMedica;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}