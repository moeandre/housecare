package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Configuracao;
import br.com.wamais.houseCare.domain.ConfiguracaoPK;
import br.com.wamais.houseCare.repository.crud.ConfiguracaoRepository;
import br.com.wamais.houseCare.service.IConfiguracaoService;

@Service
@Transactional
public class ConfiguracaoServiceImpl extends AbstractService<Configuracao, ConfiguracaoPK> implements IConfiguracaoService {

	@Autowired
	private ConfiguracaoRepository repository;

	@Autowired
	public void superRepository(final ConfiguracaoRepository repository) {

		super.setRepository(repository);
	}

}
