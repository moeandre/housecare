package br.com.wamais.houseCare.report.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.report.domain.DashFinanceiro;
import br.com.wamais.houseCare.report.service.IFinanceiroReportService;
import br.com.wamais.houseCare.repository.report.IFinanceiroReport;

@Service
@Transactional(readOnly = true)
public class FinanceiroReportServiceImpl implements IFinanceiroReportService {

	@Autowired
	IFinanceiroReport report;

	@Override
	public DashFinanceiro obterPorIdEmpresa(final Integer idEmpresa, final Integer mesano) {

		return this.report.obterPorIdEmpresa(idEmpresa, mesano);
	}

}
