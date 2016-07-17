package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Anotacao;
import br.com.wamais.houseCare.domain.AnotacaoPK;

@Repository
public interface AnotacaoRepository extends JpaRepository<Anotacao, AnotacaoPK> {

}
