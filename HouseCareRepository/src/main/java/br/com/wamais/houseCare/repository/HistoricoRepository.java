package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Historico;
import br.com.wamais.houseCare.domain.HistoricoPK;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, HistoricoPK> {

}
