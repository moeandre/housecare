package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the prescricao_enfermagem database table.
 * 
 */
@Embeddable
public class PrescricaoEnfermagemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_cliente", insertable=false, updatable=false)
	private int idCliente;

	@Column(name="id_empresa", insertable=false, updatable=false)
	private int idEmpresa;

	@Column(name="id_diagnostico", insertable=false, updatable=false)
	private int idDiagnostico;

	public PrescricaoEnfermagemPK() {
	}
	public int getIdCliente() {
		return this.idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdEmpresa() {
		return this.idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public int getIdDiagnostico() {
		return this.idDiagnostico;
	}
	public void setIdDiagnostico(int idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PrescricaoEnfermagemPK)) {
			return false;
		}
		PrescricaoEnfermagemPK castOther = (PrescricaoEnfermagemPK)other;
		return 
			(this.idCliente == castOther.idCliente)
			&& (this.idEmpresa == castOther.idEmpresa)
			&& (this.idDiagnostico == castOther.idDiagnostico);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCliente;
		hash = hash * prime + this.idEmpresa;
		hash = hash * prime + this.idDiagnostico;
		
		return hash;
	}
}