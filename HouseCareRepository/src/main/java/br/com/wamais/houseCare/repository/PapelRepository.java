package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Papel;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Integer> {

}
