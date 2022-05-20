package com.prueba.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The persistent class for the historia_clinica database table.
 * 
 */
@Entity
@Table(name = "historia_clinica")
@NamedQuery(name = "HistoriaClinica.findAll", query = "SELECT h FROM HistoriaClinica h")
public class HistoriaClinica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "bigserial")
	private Long id;

	private String diagnostico;

	// bi-directional many-to-one association to CitasMedica

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cita")
	private CitasMedica citasMedica;

	public HistoriaClinica() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	@JsonIgnore
	public CitasMedica getCitasMedica() {
		return this.citasMedica;
	}
   @JsonProperty
	public void setCitasMedica(CitasMedica citasMedica) {
		this.citasMedica = citasMedica;
	}

}