package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.AtributoPapel;
import br.com.wamais.houseCare.domain.AtributoPapelPK;
import br.com.wamais.houseCare.repository.AtributoPapelRepository;
import br.com.wamais.houseCare.service.IAtributoPapelService;

@Service
@Transactional
public class AtributoPapelServiceImpl extends AbstractService<AtributoPapel, AtributoPapelPK> implements IAtributoPapelService {

	@Autowired
	private AtributoPapelRepository repository;

	@Autowired
	public void superRepository(final AtributoPapelRepository repository) {

		super.setRepository(repository);
	}

}
