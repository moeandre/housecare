package br.com.wamais.houseCare.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Cliente;
import br.com.wamais.houseCare.domain.Familiar;
import br.com.wamais.houseCare.domain.FamiliarPK;
import br.com.wamais.houseCare.repository.FamiliarRepository;
import br.com.wamais.houseCare.service.IFamiliarService;

@Service
@Transactional
public class FamiliarServiceImpl extends AbstractService<Familiar, FamiliarPK> implements IFamiliarService {

	@Autowired
	private FamiliarRepository repository;

	@Autowired
	public void superRepository(final FamiliarRepository repository) {

		super.setRepository(repository);
	}

	@Override
	public Familiar obterPorIdFamiliar(final Integer idFamiliar, final Integer idEmpresa) {

		Familiar familiar = new Familiar();
		final List<Object[]> listaEntidades = this.repository.obterPorIdFamiliar(idFamiliar, idEmpresa);
		if (listaEntidades.isEmpty() == false && listaEntidades.get(0) != null) {
			final Object entidade[] = listaEntidades.get(0);
			familiar = (Familiar) entidade[0];
			final Cliente cliente = (Cliente) entidade[1];
			familiar.setCliente(cliente);
		}

		return familiar;

	}

	@Override
	public List<Familiar> listarPorIdEmpresa(final Integer idEmpresa) {

		final List<Familiar> familiars = new ArrayList<Familiar>();
		final List<Object[]> listaEntidades = this.repository.findByIdEmpresa(idEmpresa);
		for (final Object entidade[] : listaEntidades) {
			final Familiar familiar = (Familiar) entidade[0];
			final Cliente cliente = (Cliente) entidade[1];
			familiar.setCliente(cliente);
			familiars.add(familiar);
		}
		return familiars;
	}

	@Override
	public List<Familiar> listarPorIdClienteIdEmpresa(final Integer idCliente, final Integer idEmpresa) {

		final List<Familiar> familiars = new ArrayList<Familiar>();
		final List<Object[]> listaEntidades = this.repository.findByIdClienteIdEmpresa(idCliente, idEmpresa);
		for (final Object entidade[] : listaEntidades) {
			final Familiar familiar = (Familiar) entidade[0];
			final Cliente cliente = (Cliente) entidade[1];
			familiar.setCliente(cliente);
			familiars.add(familiar);
		}
		return familiars;
	}

	@Override
	public void excluirPorIdFamiliar(final Integer idFamiliar, final Integer idEmpresa) {

		this.repository.excluirPorIdFamiliar(idFamiliar, idEmpresa);
	}

}
