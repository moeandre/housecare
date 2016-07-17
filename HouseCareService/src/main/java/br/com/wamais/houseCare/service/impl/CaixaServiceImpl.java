package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Caixa;
import br.com.wamais.houseCare.domain.CaixaPK;
import br.com.wamais.houseCare.repository.CaixaRepository;
import br.com.wamais.houseCare.service.ICaixaService;

@Service
@Transactional
public class CaixaServiceImpl extends AbstractService<Caixa, CaixaPK> implements ICaixaService {

	@Autowired
	private CaixaRepository repository;

	@Autowired
	public void superRepository(final CaixaRepository repository) {

		super.setRepository(repository);
	}

}
