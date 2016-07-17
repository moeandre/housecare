package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Familiar;
import br.com.wamais.houseCare.domain.FamiliarPK;
import br.com.wamais.houseCare.repository.FamiliarRepository;
import br.com.wamais.houseCare.service.IFamiliarService;

@Service
@Transactional
public class FamiliarServiceImpl extends AbstractService<Familiar, FamiliarPK> implements IFamiliarService {

	@Autowired
	private FamiliarRepository repository;

	@Autowired
	public void superRepository(final FamiliarRepository repository) {

		super.setRepository(repository);
	}

}
