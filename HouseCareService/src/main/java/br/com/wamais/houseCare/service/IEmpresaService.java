package br.com.wamais.houseCare.service;

import br.com.wamais.houseCare.domain.Empresa;

public interface IEmpresaService extends ICrudService<Empresa, Integer> {

	public Empresa findByIdUsuario(Integer idUsuario);
}
