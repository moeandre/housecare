package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Parentesco;
import br.com.wamais.houseCare.domain.ParentescoPK;
import br.com.wamais.houseCare.repository.ParentescoRepository;
import br.com.wamais.houseCare.service.IParentescoService;

@Service
@Transactional
public class ParentescoServiceImpl extends AbstractService<Parentesco, ParentescoPK> implements IParentescoService {

	@Autowired
	private ParentescoRepository repository;

	@Autowired
	public void superRepository(final ParentescoRepository repository) {

		super.setRepository(repository);
	}
		

}
