package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the servico database table.
 * 
 */
@Embeddable
public class ServicoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="id_cliente", insertable=false, updatable=false)
	private int idCliente;

	@Column(name="id_empresa", insertable=false, updatable=false)
	private int idEmpresa;

	public ServicoPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
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
		if (!(other instanceof ServicoPK)) {
			return false;
		}
		ServicoPK castOther = (ServicoPK)other;
		return 
			(this.id == castOther.id)
			&& (this.idCliente == castOther.idCliente)
			&& (this.idEmpresa == castOther.idEmpresa);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.idCliente;
		hash = hash * prime + this.idEmpresa;
		
		return hash;
	}
}