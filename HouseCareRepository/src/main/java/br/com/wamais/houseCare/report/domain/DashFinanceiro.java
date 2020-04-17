package br.com.wamais.houseCare.report.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class DashFinanceiro implements Serializable {

	private static final long serialVersionUID = 5213375711540402015L;

	private BigDecimal total;
	private BigDecimal pago;
	private BigDecimal aVencer;
	private BigDecimal vencido;
	
	public DashFinanceiro() {

		super();
	}

	public DashFinanceiro(final BigDecimal total, final BigDecimal pago, final BigDecimal aVencer, final BigDecimal vencido) {

		super();
		this.total = total;
		this.pago = pago;
		this.aVencer = aVencer;
		this.vencido = vencido;
		
	}

	public BigDecimal getTotal() {

		return this.total;
	}

	public void setTotal(final BigDecimal total) {

		this.total = total;
	}

	public BigDecimal getPago() {

		return this.pago;
	}

	public void setPago(final BigDecimal pago) {

		this.pago = pago;
	}

	public BigDecimal getVencido() {

		return this.vencido;
	}

	public void setVencido(final BigDecimal vencido) {

		this.vencido = vencido;
	}

	public BigDecimal getaVencer() {

		return this.aVencer;
	}

	public void setaVencer(final BigDecimal aVencer) {

		this.aVencer = aVencer;
	}

}
