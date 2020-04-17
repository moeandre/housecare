package br.com.wamais.houseCare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.constants.HouseCareConstants;
import br.com.wamais.houseCare.domain.AtributoCliente;
import br.com.wamais.houseCare.domain.Cliente;
import br.com.wamais.houseCare.domain.ClientePK;
import br.com.wamais.houseCare.repository.crud.AtributoClienteRepository;
import br.com.wamais.houseCare.repository.crud.ClienteRepository;
import br.com.wamais.houseCare.service.IClienteService;

@Service
@Transactional
public class ClienteServiceImpl extends AbstractService<Cliente, ClientePK> implements IClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private AtributoClienteRepository atributoRepository;

	@Autowired
	public void superRepository(final ClienteRepository repository) {

		super.setRepository(repository);
	}

	@Override
	public List<Cliente> listarPorEmpresa(final Integer idEmpresa) {

		return this.repository.findByIdIdEmpresa(idEmpresa);
	}

	@Override
	public String obterVencimento(final Integer idCliente, final Integer idEmpresa) {

		final AtributoCliente atributoCliente = this.findByChave(HouseCareConstants.DIA_VENCIMENTO, idCliente, idEmpresa);
		return atributoCliente.getValor();
	}
	
	@Override
	public String obterTipoFatura(final Integer idCliente, final Integer idEmpresa) {

		final AtributoCliente atributoCliente = this.findByChave(HouseCareConstants.TIPO_FATURA, idCliente, idEmpresa);
		return atributoCliente.getValor();
	}

	private AtributoCliente findByChave(final String chave, final Integer idCliente, final Integer idEmpresa) {

		return this.atributoRepository.findByChave(chave, idCliente, idEmpresa);
	}

}
