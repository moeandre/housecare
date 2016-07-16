package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the diagnostico_cuidado database table.
 * 
 */
@Embeddable
public class DiagnosticoCuidadoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_diagnostico", insertable=false, updatable=false)
	private int idDiagnostico;

	@Column(name="id_cuidado", insertable=false, updatable=false)
	private int idCuidado;

	public DiagnosticoCuidadoPK() {
	}
	public int getIdDiagnostico() {
		return this.idDiagnostico;
	}
	public void setIdDiagnostico(int idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}
	public int getIdCuidado() {
		return this.idCuidado;
	}
	public void setIdCuidado(int idCuidado) {
		this.idCuidado = idCuidado;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DiagnosticoCuidadoPK)) {
			return false;
		}
		DiagnosticoCuidadoPK castOther = (DiagnosticoCuidadoPK)other;
		return 
			(this.idDiagnostico == castOther.idDiagnostico)
			&& (this.idCuidado == castOther.idCuidado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idDiagnostico;
		hash = hash * prime + this.idCuidado;
		
		return hash;
	}
}