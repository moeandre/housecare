package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Lotacao;
import br.com.wamais.houseCare.domain.LotacaoPK;
import br.com.wamais.houseCare.repository.LotacaoRepository;
import br.com.wamais.houseCare.service.ILotacaoService;

@Service
@Transactional
public class LotacaoServiceImpl extends AbstractService<Lotacao, LotacaoPK> implements ILotacaoService {

	@Autowired
	private LotacaoRepository repository;

	@Autowired
	public void superRepository(final LotacaoRepository repository) {

		super.setRepository(repository);
	}

}
