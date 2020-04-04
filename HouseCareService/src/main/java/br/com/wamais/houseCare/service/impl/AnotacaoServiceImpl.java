package br.com.wamais.houseCare.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Anotacao;
import br.com.wamais.houseCare.domain.AnotacaoPK;
import br.com.wamais.houseCare.domain.Usuario;
import br.com.wamais.houseCare.repository.AnotacaoRepository;
import br.com.wamais.houseCare.service.IAnotacaoService;

@Service
@Transactional
public class AnotacaoServiceImpl extends AbstractService<Anotacao, AnotacaoPK> implements IAnotacaoService {

	@Autowired
	private AnotacaoRepository repository;

	@Autowired
	public void superRepository(final AnotacaoRepository repository) {

		super.setRepository(repository);
	}

	@Override
	public List<Anotacao> listarPorIdClienteIdEmpresa(final Integer idCliente, final Integer idEmpresa) {

		final List<Anotacao> anotacaos = new ArrayList<Anotacao>();
		final List<Object[]> listaEntidades = this.repository.findByIdClienteIdEmpresa(idCliente, idEmpresa);
		for (final Object entidade[] : listaEntidades) {
			final Anotacao anotacao = (Anotacao) entidade[0];
			final Usuario usuario = (Usuario) entidade[1];
			anotacao.setUsuario(usuario);
			anotacaos.add(anotacao);
		}

		return anotacaos;
	}

	@Override
	public Anotacao obterPorIdClienteIdEmpresaIdAnotacao(final Integer idCliente, final Integer idEmpresa, final Integer idAnocatao) {

		Anotacao anotacao = new Anotacao();
		final List<Object[]> listaEntidades = this.repository.findByIdIdClienteIdEmpresa(idCliente, idEmpresa, idAnocatao);
		if (listaEntidades.isEmpty() == false && listaEntidades.get(0) != null) {
			final Object entidade[] = listaEntidades.get(0);
			anotacao = (Anotacao) entidade[0];
			final Usuario usuario = (Usuario) entidade[1];
			anotacao.setUsuario(usuario);
		}

		return anotacao;
	}

	@Override
	public void excluirPorIdClienteIdEmpresaIdAnotacao(final Integer idCliente, final Integer idEmpresa, final Integer idAnocatao) {

		this.repository.deleteByIdIdClienteIdEmpresa(idAnocatao, idCliente, idEmpresa);

	}

}
