package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Cobranca;

@Repository
public interface CobrancaRepository extends JpaRepository<Cobranca, Integer> {

}
