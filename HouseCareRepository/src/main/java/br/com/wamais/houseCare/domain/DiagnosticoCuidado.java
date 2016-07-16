package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the diagnostico_cuidado database table.
 * 
 */
@Entity
@Table(name="diagnostico_cuidado")
public class DiagnosticoCuidado implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DiagnosticoCuidadoPK id;

	public DiagnosticoCuidado() {
	}

	public DiagnosticoCuidadoPK getId() {
		return this.id;
	}

	public void setId(DiagnosticoCuidadoPK id) {
		this.id = id;
	}

}