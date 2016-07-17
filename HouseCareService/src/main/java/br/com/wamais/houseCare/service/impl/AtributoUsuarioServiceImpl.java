package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.AtributoUsuario;
import br.com.wamais.houseCare.domain.AtributoUsuarioPK;
import br.com.wamais.houseCare.repository.AtributoUsuarioRepository;
import br.com.wamais.houseCare.service.IAtributoUsuarioService;

@Service
@Transactional
public class AtributoUsuarioServiceImpl extends AbstractService<AtributoUsuario, AtributoUsuarioPK> implements IAtributoUsuarioService {

	@Autowired
	private AtributoUsuarioRepository repository;

	@Autowired
	public void superRepository(final AtributoUsuarioRepository repository) {

		super.setRepository(repository);
	}

}
