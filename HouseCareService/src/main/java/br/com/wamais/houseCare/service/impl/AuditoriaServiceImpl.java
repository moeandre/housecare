package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Auditoria;
import br.com.wamais.houseCare.repository.crud.AuditoriaRepository;
import br.com.wamais.houseCare.service.IAuditoriaService;

@Service
@Transactional
public class AuditoriaServiceImpl extends AbstractService<Auditoria, Integer> implements IAuditoriaService {

	@Autowired
	private AuditoriaRepository repository;

	@Autowired
	public void superRepository(final AuditoriaRepository repository) {

		super.setRepository(repository);
	}

}
