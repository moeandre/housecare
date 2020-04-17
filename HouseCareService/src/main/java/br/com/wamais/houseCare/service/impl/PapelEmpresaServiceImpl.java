package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.PapelEmpresa;
import br.com.wamais.houseCare.domain.PapelEmpresaPK;
import br.com.wamais.houseCare.repository.crud.PapelEmpresaRepository;
import br.com.wamais.houseCare.service.IPapelEmpresaService;

@Service
@Transactional
public class PapelEmpresaServiceImpl extends AbstractService<PapelEmpresa, PapelEmpresaPK> implements IPapelEmpresaService {

	@Autowired
	private PapelEmpresaRepository repository;

	@Autowired
	public void superRepository(final PapelEmpresaRepository repository) {

		super.setRepository(repository);
	}

}
