package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the lotacao database table.
 * 
 */
@Embeddable
public class LotacaoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_leito", insertable=false, updatable=false)
	private int idLeito;

	@Column(name="id_quarto", insertable=false, updatable=false)
	private int idQuarto;

	@Column(name="id_cliente", insertable=false, updatable=false)
	private int idCliente;

	@Column(name="id_empresa", insertable=false, updatable=false)
	private int idEmpresa;

	public LotacaoPK() {
	}
	public int getIdLeito() {
		return this.idLeito;
	}
	public void setIdLeito(int idLeito) {
		this.idLeito = idLeito;
	}
	public int getIdQuarto() {
		return this.idQuarto;
	}
	public void setIdQuarto(int idQuarto) {
		this.idQuarto = idQuarto;
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
		if (!(other instanceof LotacaoPK)) {
			return false;
		}
		LotacaoPK castOther = (LotacaoPK)other;
		return 
			(this.idLeito == castOther.idLeito)
			&& (this.idQuarto == castOther.idQuarto)
			&& (this.idCliente == castOther.idCliente)
			&& (this.idEmpresa == castOther.idEmpresa);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idLeito;
		hash = hash * prime + this.idQuarto;
		hash = hash * prime + this.idCliente;
		hash = hash * prime + this.idEmpresa;
		
		return hash;
	}
}