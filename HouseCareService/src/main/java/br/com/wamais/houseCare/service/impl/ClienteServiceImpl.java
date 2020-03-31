package br.com.wamais.houseCare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Cliente;
import br.com.wamais.houseCare.domain.ClientePK;
import br.com.wamais.houseCare.repository.ClienteRepository;
import br.com.wamais.houseCare.service.IClienteService;

@Service
@Transactional
public class ClienteServiceImpl extends AbstractService<Cliente, ClientePK> implements IClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	public void superRepository(final ClienteRepository repository) {

		super.setRepository(repository);
	}

	@Override
	public List<Cliente> listarPorEmpresa(final Integer idEmpresa) {

		return this.repository.findByIdIdEmpresa(idEmpresa);
	}

}
