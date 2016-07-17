package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Lancamento;
import br.com.wamais.houseCare.domain.LancamentoPK;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, LancamentoPK> {

}
