package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * The persistent class for the fatura database table.
 *
 */
@Entity
@Table(name = "fatura")
public class Fatura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(name = "id_cobranca")
	private Integer idCobranca;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date data;

	@Transient
	private Cobranca cobranca;

	@Transient
	private List<Lancamento> lancamentos;

	public Fatura() {

		this.lancamentos = new ArrayList<Lancamento>();

	}

	public int getId() {

		return this.id;
	}

	public void setId(final int id) {

		this.id = id;
	}

	public Integer getIdCobranca() {

		return this.idCobranca;
	}

	public void setIdCobranca(final Integer idCobranca) {

		this.idCobranca = idCobranca;
	}

	public List<Lancamento> getLancamentos() {

		return this.lancamentos;
	}

	public void setLancamentos(final List<Lancamento> lancamentos) {

		this.lancamentos = lancamentos;
	}

	public void addLancamentos(final Lancamento lancamento) {

		this.lancamentos.add(lancamento);
	}

	public Cobranca getCobranca() {

		return this.cobranca;
	}

	public void setCobranca(final Cobranca cobranca) {

		this.cobranca = cobranca;
	}

	public Date getData() {

		return this.data;
	}

	public void setData(final Date data) {

		this.data = data;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + this.id;
		return result;
	}

	@Override
	public boolean equals(final Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Fatura other = (Fatura) obj;
		if (this.id != other.id) {
			return false;
		}
		return true;
	}

}