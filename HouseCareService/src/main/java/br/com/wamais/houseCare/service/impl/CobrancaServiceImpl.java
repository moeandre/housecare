package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Cobranca;
import br.com.wamais.houseCare.repository.CobrancaRepository;
import br.com.wamais.houseCare.service.ICobrancaService;

@Service
@Transactional
public class CobrancaServiceImpl extends AbstractService<Cobranca, Integer> implements ICobrancaService {

	@Autowired
	private CobrancaRepository repository;

	@Autowired
	public void superRepository(final CobrancaRepository repository) {

		super.setRepository(repository);
	}

}
