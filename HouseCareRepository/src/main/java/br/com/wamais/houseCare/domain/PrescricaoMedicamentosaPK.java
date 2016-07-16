package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the prescricao_medicamentosa database table.
 * 
 */
@Embeddable
public class PrescricaoMedicamentosaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="id_medicamento", insertable=false, updatable=false)
	private int idMedicamento;

	@Column(name="id_cliente", insertable=false, updatable=false)
	private int idCliente;

	@Column(name="id_empresa_cliente", insertable=false, updatable=false)
	private int idEmpresaCliente;

	public PrescricaoMedicamentosaPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdMedicamento() {
		return this.idMedicamento;
	}
	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
	}
	public int getIdCliente() {
		return this.idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdEmpresaCliente() {
		return this.idEmpresaCliente;
	}
	public void setIdEmpresaCliente(int idEmpresaCliente) {
		this.idEmpresaCliente = idEmpresaCliente;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PrescricaoMedicamentosaPK)) {
			return false;
		}
		PrescricaoMedicamentosaPK castOther = (PrescricaoMedicamentosaPK)other;
		return 
			(this.id == castOther.id)
			&& (this.idMedicamento == castOther.idMedicamento)
			&& (this.idCliente == castOther.idCliente)
			&& (this.idEmpresaCliente == castOther.idEmpresaCliente);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.idMedicamento;
		hash = hash * prime + this.idCliente;
		hash = hash * prime + this.idEmpresaCliente;
		
		return hash;
	}
}