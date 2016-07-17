package br.com.wamais.houseCare.service;

import java.util.List;

import br.com.wamais.houseCare.domain.Papel;

public interface IPapelService extends ICrudService<Papel, Integer> {

	List<Papel> findByIdUsuario(Integer idUsuario);
	
}
