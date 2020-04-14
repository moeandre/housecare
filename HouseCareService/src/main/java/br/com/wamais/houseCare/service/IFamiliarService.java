package br.com.wamais.houseCare.service;

import java.util.List;

import br.com.wamais.houseCare.domain.Familiar;

public interface IFamiliarService extends ICrudService<Familiar, Integer> {

	List<Familiar> listarPorIdClienteIdEmpresa(Integer idCliente, Integer idEmpresa);

	List<Familiar> listarPorIdEmpresa(Integer idEmpresa);

	Familiar obterPorIdFamiliar(Integer idFamiliar, Integer idEmpresa);

	void excluirPorIdFamiliar(Integer idFamiliar, Integer idEmpresa);

	Familiar obterPorIdFamiliar(Integer idFamiliar, Integer idCliente, Integer idEmpresa);

	Familiar criar(Familiar familiar);

	void excluir(Integer idFamiliar, Integer idEmpresa);

}
