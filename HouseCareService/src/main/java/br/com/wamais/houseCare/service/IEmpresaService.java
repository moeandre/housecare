package br.com.wamais.houseCare.service;

import br.com.wamais.houseCare.domain.Empresa;

public interface IEmpresaService extends ICrudService<Empresa, Integer> {

	Empresa findByIdUsuario(Integer idUsuario);

	String obterVencimento(Integer idEmpresa);
	
	String obterTipoFatura(Integer idEmpresa);
}
