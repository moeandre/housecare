package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Inventario;
import br.com.wamais.houseCare.domain.InventarioPK;
import br.com.wamais.houseCare.repository.crud.InventarioRepository;
import br.com.wamais.houseCare.service.IInventarioService;

@Service
@Transactional
public class InventarioServiceImpl extends AbstractService<Inventario, InventarioPK> implements IInventarioService {

	@Autowired
	private InventarioRepository repository;

	@Autowired
	public void superRepository(final InventarioRepository repository) {

		super.setRepository(repository);
	}

}
