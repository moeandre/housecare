package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the funcionario database table.
 *
 */
@Embeddable
public class FuncionarioPK implements Serializable {

	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "id_empresa", insertable = false, updatable = false, unique = true, nullable = false)
	private int idEmpresa;

	@Column(name = "id_usuario", insertable = false, updatable = false, unique = true, nullable = false)
	private int idUsuario;

	public FuncionarioPK() {

	}

	public int getIdEmpresa() {

		return this.idEmpresa;
	}

	public void setIdEmpresa(final int idEmpresa) {

		this.idEmpresa = idEmpresa;
	}

	public int getIdUsuario() {

		return this.idUsuario;
	}

	public void setIdUsuario(final int idUsuario) {

		this.idUsuario = idUsuario;
	}

	@Override
	public boolean equals(final Object other) {

		if (this == other) {
			return true;
		}
		if (!(other instanceof FuncionarioPK)) {
			return false;
		}
		final FuncionarioPK castOther = (FuncionarioPK) other;
		return (this.idEmpresa == castOther.idEmpresa) && (this.idUsuario == castOther.idUsuario);
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idEmpresa;
		hash = hash * prime + this.idUsuario;

		return hash;
	}
}