package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the atributo_papel database table.
 * 
 */
@Embeddable
public class AtributoPapelPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="id_papel", insertable=false, updatable=false)
	private int idPapel;

	public AtributoPapelPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPapel() {
		return this.idPapel;
	}
	public void setIdPapel(int idPapel) {
		this.idPapel = idPapel;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AtributoPapelPK)) {
			return false;
		}
		AtributoPapelPK castOther = (AtributoPapelPK)other;
		return 
			(this.id == castOther.id)
			&& (this.idPapel == castOther.idPapel);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.idPapel;
		
		return hash;
	}
}