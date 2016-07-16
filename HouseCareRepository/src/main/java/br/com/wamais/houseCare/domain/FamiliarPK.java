package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the familiar database table.
 * 
 */
@Embeddable
public class FamiliarPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_familiar")
	private int idFamiliar;

	@Column(name="id_cliente", insertable=false, updatable=false)
	private int idCliente;

	@Column(name="id_empresa", insertable=false, updatable=false)
	private int idEmpresa;

	public FamiliarPK() {
	}
	public int getIdFamiliar() {
		return this.idFamiliar;
	}
	public void setIdFamiliar(int idFamiliar) {
		this.idFamiliar = idFamiliar;
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FamiliarPK)) {
			return false;
		}
		FamiliarPK castOther = (FamiliarPK)other;
		return 
			(this.idFamiliar == castOther.idFamiliar)
			&& (this.idCliente == castOther.idCliente)
			&& (this.idEmpresa == castOther.idEmpresa);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idFamiliar;
		hash = hash * prime + this.idCliente;
		hash = hash * prime + this.idEmpresa;
		
		return hash;
	}
}