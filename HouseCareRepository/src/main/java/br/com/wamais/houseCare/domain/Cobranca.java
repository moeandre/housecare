package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the cobranca database table.
 *
 */
@Entity
@Table(name = "cobranca")
public class Cobranca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date data;

	@Column(name = "id_cliente", nullable = false)
	private int idCliente;

	@Column(name = "id_empresa", nullable = false)
	private int idEmpresa;

	@Column(name = "id_familiar")
	private Integer idFamiliar;

	@Temporal(TemporalType.TIMESTAMP)
	private Date pagamento;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valor;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date vencimento;

	public Cobranca() {

	}

	public int getId() {

		return this.id;
	}

	public void setId(final int id) {

		this.id = id;
	}

	public Date getData() {

		return this.data;
	}

	public void setData(final Date data) {

		this.data = data;
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

	public Integer getIdFamiliar() {

		return this.idFamiliar;
	}

	public void setIdFamiliar(final Integer idFamiliar) {

		this.idFamiliar = idFamiliar;
	}

	public Date getPagamento() {

		return this.pagamento;
	}

	public void setPagamento(final Date pagamento) {

		this.pagamento = pagamento;
	}

	public BigDecimal getValor() {

		return this.valor;
	}

	public void setValor(final BigDecimal valor) {

		this.valor = valor;
	}

	public Date getVencimento() {

		return this.vencimento;
	}

	public void setVencimento(final Date vencimento) {

		this.vencimento = vencimento;
	}

}