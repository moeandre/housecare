package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.AtributoPapel;
import br.com.wamais.houseCare.domain.AtributoPapelPK;

@Repository
public interface AtributoPapelRepository extends JpaRepository<AtributoPapel, AtributoPapelPK> {

}
