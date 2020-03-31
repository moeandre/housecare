package br.com.wamais.houseCare.service;

import java.util.List;

import br.com.wamais.houseCare.domain.Anotacao;
import br.com.wamais.houseCare.domain.AnotacaoPK;

public interface IAnotacaoService extends ICrudService<Anotacao, AnotacaoPK> {

	List<Anotacao> listarPorIdClienteIdEmpresa(Integer idCliente, Integer idEmpresa);
	
	Anotacao obterPorIdClienteIdEmpresaIdAnotacao(Integer idCliente, Integer idEmpresa, Integer idAnocatao);
	
	void excluirPorIdClienteIdEmpresaIdAnotacao(Integer idCliente, Integer idEmpresa, Integer idAnocatao);

	
}
