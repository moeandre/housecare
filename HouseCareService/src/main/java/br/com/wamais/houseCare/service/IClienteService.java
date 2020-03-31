package br.com.wamais.houseCare.service;

import java.util.List;

import br.com.wamais.houseCare.domain.Cliente;
import br.com.wamais.houseCare.domain.ClientePK;

public interface IClienteService extends ICrudService<Cliente, ClientePK> {

	List<Cliente> listarPorEmpresa(Integer idEmpresa);
}
