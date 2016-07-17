package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Parametro;

@Repository
public interface ParametroRepository extends JpaRepository<Parametro, Integer> {

}
