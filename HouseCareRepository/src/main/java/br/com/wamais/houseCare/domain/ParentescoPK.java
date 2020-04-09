package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the parentesco database table.
 *
 */
@Embeddable
public class ParentescoPK implements Serializable {

	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "id_familiar", insertable = false, updatable = false, unique = true, nullable = false)
	private int idFamiliar;

	@Column(name = "id_cliente", insertable = false, updatable = false, unique = true, nullable = false)
	private int idCliente;

	@Column(name = "id_empresa", insertable = false, updatable = false, unique = true, nullable = false)
	private int idEmpresa;

	public ParentescoPK() {

	}

	public int getIdFamiliar() {

		return this.idFamiliar;
	}

	public void setIdFamiliar(final int idFamiliar) {

		this.idFamiliar = idFamiliar;
	}

	public int getIdCliente() {

		return this.idCliente;
	}

	public void setIdCliente(final int idCliente) {

		this.idCliente = idCliente;
	}

	public int getIdEmpresa() {

		return this.idEmpresa;
	}

	public void setIdEmpresa(final int idEmpresa) {

		this.idEmpresa = idEmpresa;
	}

	@Override
	public boolean equals(final Object other) {

		if (this == other) {
			return true;
		}
		if (!(other instanceof ParentescoPK)) {
			return false;
		}
		final ParentescoPK castOther = (ParentescoPK) other;
		return (this.idFamiliar == castOther.idFamiliar) && (this.idCliente == castOther.idCliente) && (this.idEmpresa == castOther.idEmpresa);
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idFamiliar;
		hash = hash * prime + this.idCliente;
		hash = hash * prime + this.idEmpresa;

		return hash;
	}
}