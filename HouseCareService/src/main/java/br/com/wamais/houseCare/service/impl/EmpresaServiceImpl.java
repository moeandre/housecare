package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.constants.HouseCareConstants;
import br.com.wamais.houseCare.domain.Configuracao;
import br.com.wamais.houseCare.domain.Empresa;
import br.com.wamais.houseCare.repository.crud.ConfiguracaoRepository;
import br.com.wamais.houseCare.repository.crud.EmpresaRepository;
import br.com.wamais.houseCare.service.IEmpresaService;

@Service
@Transactional
public class EmpresaServiceImpl extends AbstractService<Empresa, Integer> implements IEmpresaService {

	@Autowired
	private EmpresaRepository repository;

	@Autowired
	private ConfiguracaoRepository configuracaoRepository;

	@Autowired
	public void superRepository(final EmpresaRepository repository) {

		super.setRepository(repository);
	}

	@Override
	public Empresa findByIdUsuario(final Integer idUsuario) {

		return this.repository.findByIdUsuario(idUsuario);

	}

	@Override
	public String obterVencimento(final Integer idEmpresa) {

		final Configuracao configuracao = this.findByChave(HouseCareConstants.DIA_VENCIMENTO, idEmpresa);
		return configuracao.getValor();
	}

	private Configuracao findByChave(final String chave, final Integer idEmpresa) {

		return this.configuracaoRepository.findByChave(chave, idEmpresa);
	}

	@Override
	public String obterTipoFatura(final Integer idEmpresa) {

		final Configuracao configuracao = this.findByChave(HouseCareConstants.TIPO_FATURA, idEmpresa);
		return configuracao.getValor();

	}

}
