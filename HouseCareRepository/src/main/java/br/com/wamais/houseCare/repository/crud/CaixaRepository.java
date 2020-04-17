package br.com.wamais.houseCare.repository.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Caixa;
import br.com.wamais.houseCare.domain.CaixaPK;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, CaixaPK> {

}
