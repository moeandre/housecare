package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.DiagnosticoCuidado;
import br.com.wamais.houseCare.domain.DiagnosticoCuidadoPK;

@Repository
public interface DiagnosticoCuidadoRepository extends JpaRepository<DiagnosticoCuidado, DiagnosticoCuidadoPK> {

}
