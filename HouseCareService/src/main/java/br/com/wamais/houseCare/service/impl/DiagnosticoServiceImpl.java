package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Diagnostico;
import br.com.wamais.houseCare.repository.DiagnosticoRepository;
import br.com.wamais.houseCare.service.IDiagnosticoService;

@Service
@Transactional
public class DiagnosticoServiceImpl extends AbstractService<Diagnostico, Integer> implements IDiagnosticoService {

	@Autowired
	private DiagnosticoRepository repository;

	@Autowired
	public void superRepository(final DiagnosticoRepository repository) {

		super.setRepository(repository);
	}

}
