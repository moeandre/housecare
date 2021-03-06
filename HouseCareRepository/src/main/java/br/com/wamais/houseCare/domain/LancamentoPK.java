package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * The primary key class for the lancamento database table.
 *
 */
@Embeddable
public class LancamentoPK implements Serializable {

	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(name = "id_cliente", insertable = false, updatable = false, unique = true, nullable = false)
	private int idCliente;

	@Column(name = "id_empresa", insertable = false, updatable = false, unique = true, nullable = false)
	private int idEmpresa;

	public LancamentoPK() {

	}

	public int getId() {

		return this.id;
	}

	public void setId(final int id) {

		this.id = id;
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
		if (!(other instanceof LancamentoPK)) {
			return false;
		}
		final LancamentoPK castOther = (LancamentoPK) other;
		return (this.id == castOther.id) && (this.idCliente == castOther.idCliente) && (this.idEmpresa == castOther.idEmpresa);
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.idCliente;
		hash = hash * prime + this.idEmpresa;

		return hash;
	}
}