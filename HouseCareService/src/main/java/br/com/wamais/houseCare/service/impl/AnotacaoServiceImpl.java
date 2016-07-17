package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Anotacao;
import br.com.wamais.houseCare.domain.AnotacaoPK;
import br.com.wamais.houseCare.repository.AnotacaoRepository;
import br.com.wamais.houseCare.service.IAnotacaoService;

@Service
@Transactional
public class AnotacaoServiceImpl extends AbstractService<Anotacao, AnotacaoPK> implements IAnotacaoService {

	@Autowired
	private AnotacaoRepository repository;

	@Autowired
	public void superRepository(final AnotacaoRepository repository) {

		super.setRepository(repository);
	}

}
