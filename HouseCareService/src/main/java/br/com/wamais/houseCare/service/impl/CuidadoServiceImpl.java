package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Cuidado;
import br.com.wamais.houseCare.repository.CuidadoRepository;
import br.com.wamais.houseCare.service.ICuidadoService;

@Service
@Transactional
public class CuidadoServiceImpl extends AbstractService<Cuidado, Integer> implements ICuidadoService {

	@Autowired
	private CuidadoRepository repository;

	@Autowired
	public void superRepository(final CuidadoRepository repository) {

		super.setRepository(repository);
	}

}
