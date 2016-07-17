package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.PrescricaoEnfermagem;
import br.com.wamais.houseCare.domain.PrescricaoEnfermagemPK;

@Repository
public interface PrescricaoEnfermagemRepository extends JpaRepository<PrescricaoEnfermagem, PrescricaoEnfermagemPK> {

}
