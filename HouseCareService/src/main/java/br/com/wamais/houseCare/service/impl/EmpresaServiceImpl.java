package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Empresa;
import br.com.wamais.houseCare.repository.EmpresaRepository;
import br.com.wamais.houseCare.service.IEmpresaService;

@Service
@Transactional
public class EmpresaServiceImpl extends AbstractService<Empresa, Integer> implements IEmpresaService {

	@Autowired
	private EmpresaRepository repository;

	@Autowired
	public void superRepository(final EmpresaRepository repository) {

		super.setRepository(repository);
	}

}
