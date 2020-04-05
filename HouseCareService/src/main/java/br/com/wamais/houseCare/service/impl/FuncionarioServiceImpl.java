package br.com.wamais.houseCare.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Funcionario;
import br.com.wamais.houseCare.domain.FuncionarioPK;
import br.com.wamais.houseCare.domain.Usuario;
import br.com.wamais.houseCare.repository.FuncionarioRepository;
import br.com.wamais.houseCare.service.IFuncionarioService;
import br.com.wamais.houseCare.service.IUsuarioService;

@Service
@Transactional
public class FuncionarioServiceImpl extends AbstractService<Funcionario, FuncionarioPK> implements IFuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	public void superRepository(final FuncionarioRepository repository) {

		super.setRepository(repository);
	}
	
	@Override
	public Funcionario alterar(final Funcionario funcionario) {
		
		if(funcionario.getUsuario() != null) {
			
			//Não permite sobrescrever usuario;
			funcionario.getUsuario().setId(funcionario.getId().getIdUsuario());
			
			final Usuario usuario = usuarioService.alterar(funcionario.getUsuario());
			funcionario.getId().setIdUsuario(usuario.getId());
		}
		
		this.repository.save(funcionario);
		
		return funcionario;
	}
	

	@Override
	public List<Funcionario> listarPorEmpresa(final Integer idEmpresa) {

		final List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		final List<Object[]> listaEntidades = this.repository.findByIdEmpresa(idEmpresa);
		for (final Object entidade[] : listaEntidades) {
			final Funcionario funcionario = (Funcionario) entidade[0];
			final Usuario usuario = (Usuario) entidade[1];
			funcionario.setUsuario(usuario);
			funcionarios.add(funcionario);
		}

		return funcionarios;
	}

	@Override
	public Funcionario obterPorIdEmpresaIdUsuario(final Integer idEmpresa, final Integer idUsuario) {

		Funcionario funcionario = new Funcionario();
		final List<Object[]> listaEntidades = this.repository.obterPorIdEmpresa(idEmpresa, idUsuario);
		if (listaEntidades.isEmpty() == false && listaEntidades.get(0) != null) {
			final Object entidade[] = listaEntidades.get(0);
			funcionario = (Funcionario) entidade[0];
			final Usuario usuario = (Usuario) entidade[1];
			funcionario.setUsuario(usuario);
		}

		return funcionario;
	}
	
	

}
