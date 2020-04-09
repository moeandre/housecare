package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;

/**
 * The persistent class for the parentesco database table.
 *
 */
@Entity
@Table(name = "parentesco")
public class Parentesco implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ParentescoPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date criacao;

	@Column(nullable = false)
	private byte financeiro;

	@Column(nullable = false, length = 2)
	private String parentesco;

	@Column(nullable = false)
	private byte responsavel;

	@Transient
	@Valid
	private Familiar familiar;

	@Transient
	private List<Familiar> familiars;

	public Parentesco() {

	}

	public ParentescoPK getId() {

		return this.id;
	}

	public void setId(final ParentescoPK id) {

		this.id = id;
	}

	public Date getAlteracao() {

		return this.alteracao;
	}

	public void setAlteracao(final Date alteracao) {

		this.alteracao = alteracao;
	}

	public Date getCriacao() {

		return this.criacao;
	}

	public void setCriacao(final Date criacao) {

		this.criacao = criacao;
	}

	public byte getFinanceiro() {

		return this.financeiro;
	}

	public void setFinanceiro(final byte financeiro) {

		this.financeiro = financeiro;
	}

	public String getParentesco() {

		return this.parentesco;
	}

	public void setParentesco(final String parentesco) {

		this.parentesco = parentesco;
	}

	public byte getResponsavel() {

		return this.responsavel;
	}

	public void setResponsavel(final byte responsavel) {

		this.responsavel = responsavel;
	}

	public Familiar getFamiliar() {

		return this.familiar;
	}

	public void setFamiliar(final Familiar familiar) {

		this.familiar = familiar;
	}

	public List<Familiar> getFamiliars() {

		return this.familiars;
	}

	public void setFamiliars(final List<Familiar> familiars) {

		this.familiars = familiars;
	}

}