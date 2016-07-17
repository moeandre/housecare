package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.PrescricaoMedicamentosa;
import br.com.wamais.houseCare.domain.PrescricaoMedicamentosaPK;

@Repository
public interface PrescricaoMedicamentosaRepository extends JpaRepository<PrescricaoMedicamentosa, PrescricaoMedicamentosaPK> {

}
