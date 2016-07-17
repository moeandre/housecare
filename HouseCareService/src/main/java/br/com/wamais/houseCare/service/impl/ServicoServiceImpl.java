package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Servico;
import br.com.wamais.houseCare.domain.ServicoPK;
import br.com.wamais.houseCare.repository.ServicoRepository;
import br.com.wamais.houseCare.service.IServicoService;

@Service
@Transactional
public class ServicoServiceImpl extends AbstractService<Servico, ServicoPK> implements IServicoService {

	@Autowired
	private ServicoRepository repository;

	@Autowired
	public void superRepository(final ServicoRepository repository) {

		super.setRepository(repository);
	}

}
