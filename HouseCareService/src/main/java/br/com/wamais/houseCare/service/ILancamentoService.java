package br.com.wamais.houseCare.service;

import java.util.List;

import br.com.wamais.houseCare.domain.Lancamento;
import br.com.wamais.houseCare.domain.LancamentoPK;

public interface ILancamentoService extends ICrudService<Lancamento, LancamentoPK> {

	List<Lancamento> listarPorIdClienteIdEmpresa(Integer idCliente, Integer idEmpresa);

}
