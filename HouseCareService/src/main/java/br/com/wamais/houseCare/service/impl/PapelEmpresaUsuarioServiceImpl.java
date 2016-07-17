package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.PapelEmpresaUsuario;
import br.com.wamais.houseCare.domain.PapelEmpresaUsuarioPK;
import br.com.wamais.houseCare.repository.PapelEmpresaUsuarioRepository;
import br.com.wamais.houseCare.service.IPapelEmpresaUsuarioService;

@Service
@Transactional
public class PapelEmpresaUsuarioServiceImpl extends AbstractService<PapelEmpresaUsuario, PapelEmpresaUsuarioPK> implements
		IPapelEmpresaUsuarioService {

	@Autowired
	private PapelEmpresaUsuarioRepository repository;

	@Autowired
	public void superRepository(final PapelEmpresaUsuarioRepository repository) {

		super.setRepository(repository);
	}

}
