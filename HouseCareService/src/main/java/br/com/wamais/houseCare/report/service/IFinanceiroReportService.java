package br.com.wamais.houseCare.report.service;

import br.com.wamais.houseCare.report.domain.DashFinanceiro;
import br.com.wamais.houseCare.service.IService;

public interface IFinanceiroReportService extends IService {

	DashFinanceiro obterPorIdEmpresa(Integer idEmpresa, Integer mesano);

}