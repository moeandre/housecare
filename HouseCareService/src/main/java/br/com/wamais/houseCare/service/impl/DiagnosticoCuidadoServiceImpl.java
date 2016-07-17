package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.DiagnosticoCuidado;
import br.com.wamais.houseCare.domain.DiagnosticoCuidadoPK;
import br.com.wamais.houseCare.repository.DiagnosticoCuidadoRepository;
import br.com.wamais.houseCare.service.IDiagnosticoCuidadoService;

@Service
@Transactional
public class DiagnosticoCuidadoServiceImpl extends AbstractService<DiagnosticoCuidado, DiagnosticoCuidadoPK> implements IDiagnosticoCuidadoService {

	@Autowired
	private DiagnosticoCuidadoRepository repository;

	@Autowired
	public void superRepository(final DiagnosticoCuidadoRepository repository) {

		super.setRepository(repository);
	}

}
