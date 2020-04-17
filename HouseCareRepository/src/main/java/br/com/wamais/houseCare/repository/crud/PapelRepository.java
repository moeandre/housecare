package br.com.wamais.houseCare.repository.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Papel;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Integer> {

	@Query("SELECT P FROM Papel P, PapelEmpresaUsuario PEU WHERE P.id = PEU.id.idPapel AND PEU.id.idUsuario = :idUsuario")
	public List<Papel> findByIdUsuario(@Param("idUsuario") Integer idUsuario);
}
