package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Historico;
import br.com.wamais.houseCare.domain.HistoricoPK;
import br.com.wamais.houseCare.repository.HistoricoRepository;
import br.com.wamais.houseCare.service.IHistoricoService;

@Service
@Transactional
public class HistoricoServiceImpl extends AbstractService<Historico, HistoricoPK> implements IHistoricoService {

	@Autowired
	private HistoricoRepository repository;

	@Autowired
	public void superRepository(final HistoricoRepository repository) {

		super.setRepository(repository);
	}

}
