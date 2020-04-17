package br.com.wamais.houseCare.repository.report;

import br.com.wamais.houseCare.report.domain.DashFinanceiro;

public interface IFinanceiroReport {

	DashFinanceiro obterPorIdEmpresa(Integer idEmpresa, Integer mesano);

}