package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Usuario;
import br.com.wamais.houseCare.repository.UsuarioRepository;
import br.com.wamais.houseCare.service.IUsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl extends AbstractService<Usuario, Integer> implements IUsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	public void superRepository(final UsuarioRepository repository) {

		super.setRepository(repository);
	}

}
