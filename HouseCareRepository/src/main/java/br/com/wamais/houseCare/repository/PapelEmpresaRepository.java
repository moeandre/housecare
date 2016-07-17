package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.PapelEmpresa;
import br.com.wamais.houseCare.domain.PapelEmpresaPK;

@Repository
public interface PapelEmpresaRepository extends JpaRepository<PapelEmpresa, PapelEmpresaPK> {

}
