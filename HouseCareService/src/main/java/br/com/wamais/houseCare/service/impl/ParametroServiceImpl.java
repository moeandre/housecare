package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Parametro;
import br.com.wamais.houseCare.repository.ParametroRepository;
import br.com.wamais.houseCare.service.IParametroService;

@Service
@Transactional
public class ParametroServiceImpl extends AbstractService<Parametro, Integer> implements IParametroService {

	@Autowired
	private ParametroRepository repository;

	@Autowired
	public void superRepository(final ParametroRepository repository) {

		super.setRepository(repository);
	}

}
