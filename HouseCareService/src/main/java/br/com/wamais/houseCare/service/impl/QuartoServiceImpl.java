package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Quarto;
import br.com.wamais.houseCare.domain.QuartoPK;
import br.com.wamais.houseCare.repository.QuartoRepository;
import br.com.wamais.houseCare.service.IQuartoService;

@Service
@Transactional
public class QuartoServiceImpl extends AbstractService<Quarto, QuartoPK> implements IQuartoService {

	@Autowired
	private QuartoRepository repository;

	@Autowired
	public void superRepository(final QuartoRepository repository) {

		super.setRepository(repository);
	}

}
