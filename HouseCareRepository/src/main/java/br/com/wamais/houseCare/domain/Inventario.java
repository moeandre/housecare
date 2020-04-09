package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the inventario database table.
 *
 */
@Entity
@Table(name = "inventario")
public class Inventario implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InventarioPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;

	@Column(nullable = false)
	private byte cobranca;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date criacao;

	@Lob
	private String descricao;

	@Column(name = "id_medicamento")
	private int idMedicamento;

	@Column(nullable = false)
	private byte medicamento;

	@Column(nullable = false, length = 75)
	private String nome;

	@Column(nullable = false)
	private int quantidade;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valor;

	public Inventario() {

	}

	public InventarioPK getId() {

		return this.id;
	}

	public void setId(final InventarioPK id) {

		this.id = id;
	}

	public Date getAlteracao() {

		return this.alteracao;
	}

	public void setAlteracao(final Date alteracao) {

		this.alteracao = alteracao;
	}

	public byte getCobranca() {

		return this.cobranca;
	}

	public void setCobranca(final byte cobranca) {

		this.cobranca = cobranca;
	}

	public Date getCriacao() {

		return this.criacao;
	}

	public void setCriacao(final Date criacao) {

		this.criacao = criacao;
	}

	public String getDescricao() {

		return this.descricao;
	}

	public void setDescricao(final String descricao) {

		this.descricao = descricao;
	}

	public int getIdMedicamento() {

		return this.idMedicamento;
	}

	public void setIdMedicamento(final int idMedicamento) {

		this.idMedicamento = idMedicamento;
	}

	public byte getMedicamento() {

		return this.medicamento;
	}

	public void setMedicamento(final byte medicamento) {

		this.medicamento = medicamento;
	}

	public String getNome() {

		return this.nome;
	}

	public void setNome(final String nome) {

		this.nome = nome;
	}

	public int getQuantidade() {

		return this.quantidade;
	}

	public void setQuantidade(final int quantidade) {

		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {

		return this.valor;
	}

	public void setValor(final BigDecimal valor) {

		this.valor = valor;
	}

}