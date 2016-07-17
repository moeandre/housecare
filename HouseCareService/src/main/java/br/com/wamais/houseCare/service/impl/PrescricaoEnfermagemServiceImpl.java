package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.PrescricaoEnfermagem;
import br.com.wamais.houseCare.domain.PrescricaoEnfermagemPK;
import br.com.wamais.houseCare.repository.PrescricaoEnfermagemRepository;
import br.com.wamais.houseCare.service.IPrescricaoEnfermagemService;

@Service
@Transactional
public class PrescricaoEnfermagemServiceImpl extends AbstractService<PrescricaoEnfermagem, PrescricaoEnfermagemPK> implements
		IPrescricaoEnfermagemService {

	@Autowired
	private PrescricaoEnfermagemRepository repository;

	@Autowired
	public void superRepository(final PrescricaoEnfermagemRepository repository) {

		super.setRepository(repository);
	}

}
