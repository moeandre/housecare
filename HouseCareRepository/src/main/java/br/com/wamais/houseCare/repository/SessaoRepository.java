package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer> {

	Long deleteByIdUsuario(Integer idUsuario);

}
