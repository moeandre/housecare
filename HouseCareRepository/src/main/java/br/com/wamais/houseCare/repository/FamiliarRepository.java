package br.com.wamais.houseCare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Familiar;
import br.com.wamais.houseCare.domain.FamiliarPK;

@Repository
public interface FamiliarRepository extends JpaRepository<Familiar, FamiliarPK> {

	@Query(value = "SELECT F.* FROM familiar F WHERE F.id_cliente = :idCliente AND F.id_empresa = :idEmpresa", nativeQuery = true)
	List<Familiar> findByIdClienteIdEmpresa(@Param("idCliente") Integer idCliente, @Param("idEmpresa") Integer idEmpresa);

}
