package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Fatura;
import br.com.wamais.houseCare.repository.FaturaRepository;
import br.com.wamais.houseCare.service.IFaturaService;

@Service
@Transactional
public class FaturaServiceImpl extends AbstractService<Fatura, Integer> implements IFaturaService {

	@Autowired
	private FaturaRepository repository;

	@Autowired
	public void superRepository(final FaturaRepository repository) {

		super.setRepository(repository);
	}

}
