package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the lancamento database table.
 * 
 */
@Entity
public class Lancamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LancamentoPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date criacao;

	@Column(name="id_fatura")
	private int idFatura;

	private String nome;

	private BigDecimal valor;

	public Lancamento() {
	}

	public LancamentoPK getId() {
		return this.id;
	}

	public void setId(LancamentoPK id) {
		this.id = id;
	}

	public Date getCriacao() {
		return this.criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public int getIdFatura() {
		return this.idFatura;
	}

	public void setIdFatura(int idFatura) {
		this.idFatura = idFatura;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}