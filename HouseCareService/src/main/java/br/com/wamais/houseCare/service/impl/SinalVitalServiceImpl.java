package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.SinalVital;
import br.com.wamais.houseCare.repository.SinalVitalRepository;
import br.com.wamais.houseCare.service.ISinalVitalService;

@Service
@Transactional
public class SinalVitalServiceImpl extends AbstractService<SinalVital, Integer> implements ISinalVitalService {

	@Autowired
	private SinalVitalRepository repository;

	@Autowired
	public void superRepository(final SinalVitalRepository repository) {

		super.setRepository(repository);
	}

}
