package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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

	@Column(length = 2)
	private String tipo;

	@Transient
	private List<Lancamento> lancamentos;

	@Transient
	private Cliente cliente;

	public Fatura() {

		this.lancamentos = new ArrayList<Lancamento>();

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

	public String getTipo() {

		return this.tipo;
	}

	public void setTipo(final String tipo) {

		this.tipo = tipo;
	}

	public Cliente getCliente() {

		return this.cliente;
	}

	public void setCliente(final Cliente cliente) {

		this.cliente = cliente;
	}

}