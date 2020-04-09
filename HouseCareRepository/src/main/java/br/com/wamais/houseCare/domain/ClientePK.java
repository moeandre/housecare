package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the cliente database table.
 *
 */
@Embeddable
public class ClientePK implements Serializable {

	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique = true, nullable = false)
	private int id;

	@Column(name = "id_empresa", insertable = false, updatable = false, unique = true, nullable = false)
	private int idEmpresa;

	public ClientePK() {

	}

	public int getId() {

		return this.id;
	}

	public void setId(final int id) {

		this.id = id;
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
		if (!(other instanceof ClientePK)) {
			return false;
		}
		final ClientePK castOther = (ClientePK) other;
		return (this.id == castOther.id) && (this.idEmpresa == castOther.idEmpresa);
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.idEmpresa;

		return hash;
	}
}