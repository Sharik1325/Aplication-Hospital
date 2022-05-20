package com.prueba.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the citas_medica database table.
 * 
 */
@Entity
@Table(name = "citas_medica")
@NamedQuery(name = "CitasMedica.findAll", query = "SELECT c FROM CitasMedica c")
public class CitasMedica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "bigserial")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_cita")
	private Date fechaCita;

	@Column(name = "hora_cita")
	private String horaCita;

	// bi-directional many-to-one association to Medico
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_medico")
	private Medico medico;

	// bi-directional many-to-one association to Paciente
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;

	//bi-directional many-to-one association to HistoriaClinica
		@OneToMany(mappedBy="citasMedica")
		private List<HistoriaClinica> historiaClinicas;
	
	public CitasMedica() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaCita() {
		return this.fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getHoraCita() {
		return this.horaCita;
	}

	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}
	@JsonIgnore
	public Medico getMedico() {
		return this.medico;
	}

	@JsonProperty
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	@JsonIgnore
	public Paciente getPaciente() {
		return this.paciente;
	}

	@JsonProperty
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public List<HistoriaClinica> getHistoriaClinicas() {
		return this.historiaClinicas;
	}

	public void setHistoriaClinicas(List<HistoriaClinica> historiaClinicas) {
		this.historiaClinicas = historiaClinicas;
	}

	public HistoriaClinica addHistoriaClinica(HistoriaClinica historiaClinica) {
		getHistoriaClinicas().add(historiaClinica);
		historiaClinica.setCitasMedica(this);

		return historiaClinica;
	}

	public HistoriaClinica removeHistoriaClinica(HistoriaClinica historiaClinica) {
		getHistoriaClinicas().remove(historiaClinica);
		historiaClinica.setCitasMedica(null);

		return historiaClinica;
	}



}