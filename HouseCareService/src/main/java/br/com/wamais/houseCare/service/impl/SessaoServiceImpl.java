package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Sessao;
import br.com.wamais.houseCare.repository.SessaoRepository;
import br.com.wamais.houseCare.service.ISessaoService;

@Service
@Transactional
public class SessaoServiceImpl extends AbstractService<Sessao, Integer> implements ISessaoService {

	@Autowired
	private SessaoRepository repository;

	@Autowired
	public void superRepository(final SessaoRepository repository) {

		super.setRepository(repository);
	}

	@Override
	public void deleteByIdUsuario(final Integer idUsuario) {

		this.repository.deleteByIdUsuario(idUsuario);

	}

}
