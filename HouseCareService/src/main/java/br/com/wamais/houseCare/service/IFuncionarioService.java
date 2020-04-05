package br.com.wamais.houseCare.service;

import java.util.List;

import br.com.wamais.houseCare.domain.Funcionario;
import br.com.wamais.houseCare.domain.FuncionarioPK;

public interface IFuncionarioService extends ICrudService<Funcionario, FuncionarioPK> {

	List<Funcionario> listarPorEmpresa(Integer idEmpresa);

	Funcionario obterPorIdEmpresaIdUsuario(Integer idEmpresa, Integer idUsuario);

}
