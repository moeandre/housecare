package br.com.wamais.houseCare.service;

import java.util.List;

import br.com.wamais.houseCare.domain.Familiar;
import br.com.wamais.houseCare.domain.FamiliarPK;

public interface IFamiliarService extends ICrudService<Familiar, FamiliarPK> {

	List<Familiar> listarPorIdClienteIdEmpresa(Integer idCliente, Integer idEmpresa);

}
