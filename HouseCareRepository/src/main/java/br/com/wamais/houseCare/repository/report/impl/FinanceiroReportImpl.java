package br.com.wamais.houseCare.repository.report.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.report.domain.DashFinanceiro;
import br.com.wamais.houseCare.repository.report.IFinanceiroReport;

@Repository
public class FinanceiroReportImpl implements IFinanceiroReport {

	@PersistenceContext(name = "housePU")
	private EntityManager entityManager;

	@Override
	public DashFinanceiro obterPorIdEmpresa(final Integer idEmpresa, final Integer mesano) {

		final StringBuilder buildQuery = new StringBuilder("SELECT SUM(valor) as total, ");
		buildQuery.append(" SUM(if(pagamento is not null, valor, 0)) as pago, ");
		buildQuery.append(" SUM(if(pagamento is null AND vencimento > NOW() , valor, 0)) as avencer, ");
		buildQuery.append("	SUM(if(pagamento is null and vencimento <= NOW(), valor, 0)) as vencido ");
		buildQuery.append(" FROM Fatura WHERE EXTRACT(year_month from data) = :mesano AND id_empresa = :idEmpresa ");

		final Query query = this.entityManager.createNativeQuery(buildQuery.toString());

		query.setParameter("idEmpresa", idEmpresa);
		query.setParameter("mesano", mesano);

		final Object[] dashFinanceiro = (Object[]) query.getSingleResult();

		final BigDecimal total = (BigDecimal) dashFinanceiro[0];
		final BigDecimal pago = (BigDecimal) dashFinanceiro[1];
		final BigDecimal aVencer = (BigDecimal) dashFinanceiro[2];
		final BigDecimal vencido = (BigDecimal) dashFinanceiro[3];

		return new DashFinanceiro(total, pago, aVencer, vencido);
	}

}
