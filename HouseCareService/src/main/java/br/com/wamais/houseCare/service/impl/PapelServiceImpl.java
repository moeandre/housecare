package br.com.wamais.houseCare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Papel;
import br.com.wamais.houseCare.repository.crud.PapelRepository;
import br.com.wamais.houseCare.service.IPapelService;

@Service
@Transactional
public class PapelServiceImpl extends AbstractService<Papel, Integer> implements IPapelService {

	@Autowired
	private PapelRepository repository;

	@Autowired
	public void superRepository(final PapelRepository repository) {

		super.setRepository(repository);
	}

	@Override
	public List<Papel> findByIdUsuario(final Integer idUsuario) {

		return repository.findByIdUsuario(idUsuario);
	}

}
