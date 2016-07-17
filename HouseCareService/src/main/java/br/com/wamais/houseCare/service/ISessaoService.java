package br.com.wamais.houseCare.service;

import br.com.wamais.houseCare.domain.Sessao;

public interface ISessaoService extends ICrudService<Sessao, Integer> {
	
	public void deleteByIdUsuario(Integer idUsuario);

}
