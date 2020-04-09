package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the papel_empresa database table.
 *
 */
@Embeddable
public class PapelEmpresaPK implements Serializable {

	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "id_papel", insertable = false, updatable = false, unique = true, nullable = false)
	private int idPapel;

	@Column(name = "id_empresa", insertable = false, updatable = false, unique = true, nullable = false)
	private int idEmpresa;

	public PapelEmpresaPK() {

	}

	public int getIdPapel() {

		return this.idPapel;
	}

	public void setIdPapel(final int idPapel) {

		this.idPapel = idPapel;
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
		if (!(other instanceof PapelEmpresaPK)) {
			return false;
		}
		final PapelEmpresaPK castOther = (PapelEmpresaPK) other;
		return (this.idPapel == castOther.idPapel) && (this.idEmpresa == castOther.idEmpresa);
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPapel;
		hash = hash * prime + this.idEmpresa;

		return hash;
	}
}