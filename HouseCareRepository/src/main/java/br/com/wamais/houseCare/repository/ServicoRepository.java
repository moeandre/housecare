package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Servico;
import br.com.wamais.houseCare.domain.ServicoPK;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, ServicoPK> {

}
