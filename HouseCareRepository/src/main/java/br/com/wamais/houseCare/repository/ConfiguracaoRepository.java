package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Configuracao;
import br.com.wamais.houseCare.domain.ConfiguracaoPK;

@Repository
public interface ConfiguracaoRepository extends JpaRepository<Configuracao, ConfiguracaoPK> {

}
