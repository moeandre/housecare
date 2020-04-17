package br.com.wamais.houseCare.repository.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Quarto;
import br.com.wamais.houseCare.domain.QuartoPK;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, QuartoPK> {

}
