package br.com.wamais.houseCare.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Cliente;
import br.com.wamais.houseCare.domain.Familiar;
import br.com.wamais.houseCare.domain.Parentesco;
import br.com.wamais.houseCare.domain.ParentescoPK;
import br.com.wamais.houseCare.repository.FamiliarRepository;
import br.com.wamais.houseCare.repository.ParentescoRepository;
import br.com.wamais.houseCare.service.IFamiliarService;

@Service
@Transactional
public class FamiliarServiceImpl extends AbstractService<Familiar, Integer> implements IFamiliarService {

	@Autowired
	private FamiliarRepository repository;

	@Autowired
	private ParentescoRepository parentescoRepository;

	@Autowired
	public void superRepository(final FamiliarRepository repository) {

		super.setRepository(repository);
	}

	@Override
	public Familiar obterPorIdFamiliar(final Integer idFamiliar, final Integer idCliente, final Integer idEmpresa) {

		List<Familiar> familiars = this.parseFamiliars(this.repository.obterPorIdFamiliar(idCliente, idFamiliar, idEmpresa));

		// Familiar familiar = new Familiar();
		// final List<Object[]> listaEntidades = ;
		// if (listaEntidades.isEmpty() == false && listaEntidades.get(0) !=
		// null) {
		// final Object entidade[] = listaEntidades.get(0);
		// familiar = this.buildFamiliar(entidade);
		// }

		return familiars.get(0);

	}

	@Override
	public Familiar obterPorIdFamiliar(final Integer idFamiliar, final Integer idEmpresa) {

		List<Familiar> familiars = this.parseFamiliars(this.repository.obterPorIdFamiliar(idFamiliar, idEmpresa));

		return familiars.get(0);

		// Familiar familiar = new Familiar();
		// final List<Object[]> listaEntidades =
		// this.repository.obterPorIdFamiliar(idFamiliar, idEmpresa);
		// if (listaEntidades.isEmpty() == false && listaEntidades.get(0) !=
		// null) {
		// final Object entidade[] = listaEntidades.get(0);
		// familiar = this.buildFamiliar(entidade);
		// }
		//
		// return familiar;

	}

	@Override
	public List<Familiar> listarPorIdEmpresa(final Integer idEmpresa) {

		return this.parseFamiliars(this.repository.findByIdEmpresa(idEmpresa));
	}

	@Override
	public List<Familiar> listarPorIdClienteIdEmpresa(final Integer idCliente, final Integer idEmpresa) {

		return this.parseFamiliars(this.repository.findByIdClienteIdEmpresa(idCliente, idEmpresa));
	}

	@Override
	public void excluirPorIdFamiliar(final Integer idFamiliar, final Integer idEmpresa) {

		this.repository.excluirPorIdFamiliar(idFamiliar, idEmpresa);
	}

	@Override
	public Familiar criar(final Familiar familiar) {

		final Familiar savedFamiliar = super.alterar(familiar);

		this.salvarParentescos(familiar.getParentescos(), savedFamiliar);

		return savedFamiliar;
	}

	@Override
	public Familiar alterar(final Familiar familiar) {

		super.alterar(familiar);

		this.parentescoRepository.excluirPorIdFamiliar(familiar.getIdEmpresa(), familiar.getIdFamiliar());

		this.salvarParentescos(familiar.getParentescos(), familiar);

		return familiar;
	}

	@Override
	public void excluir(final Integer idFamiliar, final Integer idEmpresa) {

		this.parentescoRepository.excluirPorIdFamiliar(idEmpresa, idFamiliar);

		super.excluirPorId(idFamiliar);
	}

	private void salvarParentescos(final List<Parentesco> parentescos, final Familiar familiar) {

		parentescos.stream().forEach(parentesco -> {
			final ParentescoPK parentescoPK = new ParentescoPK();
			parentescoPK.setIdEmpresa(familiar.getIdEmpresa());
			parentescoPK.setIdCliente(parentesco.getCliente().getId().getId());
			parentescoPK.setIdFamiliar(familiar.getIdFamiliar());
			parentesco.setId(parentescoPK);
			this.parentescoRepository.save(parentesco);

		});

	}

	private List<Familiar> parseFamiliars(final List<Object[]> listaEntidades) {

		final List<Familiar> familiars = new ArrayList<Familiar>();

		listaEntidades.stream().forEach(entidade -> {
			Familiar familiar = (Familiar) entidade[0];
			final Parentesco parentesco = (Parentesco) entidade[1];
			final Cliente cliente = (Cliente) entidade[2];
			parentesco.setCliente(cliente);

			if (familiars.contains(familiar)) {
				familiars.get(familiars.indexOf(familiar)).addParentesco(parentesco);
			} else {
				familiar.addParentesco(parentesco);
				familiars.add(familiar);
			}
		});

		return familiars;
		
	}

}
