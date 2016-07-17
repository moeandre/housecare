package br.com.wamais.houseCare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Papel;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Integer> {

	@Query(value="SELECT P.* FROM papel P, papel_empresa_usuario peu WHERE p.id = peu.id_papel AND peu.id_usuario = :idUsuario", nativeQuery=true)
	public List<Papel> findByIdUsuario(@Param("idUsuario") Integer idUsuario);
}
