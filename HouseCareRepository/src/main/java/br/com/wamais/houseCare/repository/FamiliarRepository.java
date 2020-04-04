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

	@Query("SELECT F, C FROM Familiar F, Cliente C WHERE F.id.idFamiliar = :idFamiliar AND F.id.idEmpresa = :idEmpresa AND C.id.id = F.id.idCliente")
	List<Object[]> obterPorIdFamiliar(@Param("idFamiliar") Integer idFamiliar, @Param("idEmpresa") Integer idEmpresa);
	
	@Query("SELECT F, C FROM Familiar F, Cliente C WHERE F.id.idEmpresa = :idEmpresa AND C.id.id = F.id.idCliente")
	List<Object[]> findByIdEmpresa(@Param("idEmpresa") Integer idEmpresa);
	
	@Query("SELECT F, C FROM Familiar F, Cliente C WHERE F.id.idCliente = :idCliente AND F.id.idEmpresa = :idEmpresa AND C.id.id = F.id.idCliente")
	List<Object[]> findByIdClienteIdEmpresa(@Param("idCliente") Integer idCliente, @Param("idEmpresa") Integer idEmpresa);
	
	@Query("DELETE FROM Familiar F WHERE F.id.idFamiliar = :idFamiliar AND F.id.idEmpresa = :idEmpresa")
	void excluirPorIdFamiliar(@Param("idFamiliar") Integer idFamiliar, @Param("idEmpresa") Integer idEmpresa);

}
