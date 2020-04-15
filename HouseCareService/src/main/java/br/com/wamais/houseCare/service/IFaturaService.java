package br.com.wamais.houseCare.service;

import java.util.List;

import br.com.wamais.houseCare.domain.Fatura;

public interface IFaturaService extends ICrudService<Fatura, Integer> {

	Fatura faturar(Integer idEmpresa, Integer idCliente, Fatura fatura);

	List<Fatura> listarPorEmpresa(Integer idEmpresa);

	Fatura obterPorIdEmpresa(Integer idEmpresa, Integer idFatura);

}
