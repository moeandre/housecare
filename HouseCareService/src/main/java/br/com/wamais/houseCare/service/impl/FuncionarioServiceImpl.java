package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Funcionario;
import br.com.wamais.houseCare.domain.FuncionarioPK;
import br.com.wamais.houseCare.repository.FuncionarioRepository;
import br.com.wamais.houseCare.service.IFuncionarioService;

@Service
@Transactional
public class FuncionarioServiceImpl extends AbstractService<Funcionario, FuncionarioPK> implements IFuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	@Autowired
	public void superRepository(final FuncionarioRepository repository) {

		super.setRepository(repository);
	}

}
