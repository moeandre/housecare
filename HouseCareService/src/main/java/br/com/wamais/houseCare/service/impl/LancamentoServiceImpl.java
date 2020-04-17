package br.com.wamais.houseCare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Lancamento;
import br.com.wamais.houseCare.domain.LancamentoPK;
import br.com.wamais.houseCare.repository.crud.LancamentoRepository;
import br.com.wamais.houseCare.service.ILancamentoService;

@Service
@Transactional
public class LancamentoServiceImpl extends AbstractService<Lancamento, LancamentoPK> implements ILancamentoService {

	@Autowired
	private LancamentoRepository repository;

	@Autowired
	public void superRepository(final LancamentoRepository repository) {

		super.setRepository(repository);
	}

	@Override
	public List<Lancamento> listarPorIdClienteIdEmpresa(final Integer idCliente, final Integer idEmpresa) {

		return this.repository.findByIdClienteIdEmpresa(idCliente, idEmpresa);

	}
	
	@Override
	public List<Lancamento> listarPendentes(final Integer idCliente, final Integer idEmpresa) {

		return this.repository.findPendentes(idCliente, idEmpresa);

	}
	
	


}
