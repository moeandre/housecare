package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the historico database table.
 * 
 */
@Embeddable
public class HistoricoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="id_cliente", insertable=false, updatable=false)
	private int idCliente;

	@Column(name="id_empresa", insertable=false, updatable=false)
	private int idEmpresa;

	@Column(name="id_sinal_vital", insertable=false, updatable=false)
	private int idSinalVital;

	@Column(name="id_usuario", insertable=false, updatable=false)
	private int idUsuario;

	public HistoricoPK() {
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
	public int getIdSinalVital() {
		return this.idSinalVital;
	}
	public void setIdSinalVital(int idSinalVital) {
		this.idSinalVital = idSinalVital;
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HistoricoPK)) {
			return false;
		}
		HistoricoPK castOther = (HistoricoPK)other;
		return 
			(this.id == castOther.id)
			&& (this.idCliente == castOther.idCliente)
			&& (this.idEmpresa == castOther.idEmpresa)
			&& (this.idSinalVital == castOther.idSinalVital)
			&& (this.idUsuario == castOther.idUsuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.idCliente;
		hash = hash * prime + this.idEmpresa;
		hash = hash * prime + this.idSinalVital;
		hash = hash * prime + this.idUsuario;
		
		return hash;
	}
}