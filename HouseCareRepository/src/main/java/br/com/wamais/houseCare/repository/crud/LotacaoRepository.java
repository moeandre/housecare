package br.com.wamais.houseCare.repository.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Lotacao;
import br.com.wamais.houseCare.domain.LotacaoPK;

@Repository
public interface LotacaoRepository extends JpaRepository<Lotacao, LotacaoPK> {

}
