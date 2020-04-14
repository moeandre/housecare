package br.com.wamais.houseCare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Familiar;

@Repository
public interface FamiliarRepository extends JpaRepository<Familiar, Integer> {

	@Query("SELECT F, P, C FROM Familiar F, Cliente C, Parentesco P WHERE F.idFamiliar = :idFamiliar AND F.idEmpresa = :idEmpresa AND P.id.idFamiliar = F.idFamiliar AND C.id.id = P.id.idCliente")
	List<Object[]> obterPorIdFamiliar(@Param("idFamiliar") Integer idFamiliar, @Param("idEmpresa") Integer idEmpresa);
	
	@Query("SELECT F, P, C FROM Familiar F, Cliente C, Parentesco P WHERE F.idFamiliar = :idFamiliar AND F.idEmpresa = :idEmpresa AND P.id.idCliente = :idCliente AND P.id.idFamiliar = F.idFamiliar AND C.id.id = P.id.idCliente")
	List<Object[]> obterPorIdFamiliar(@Param("idCliente") Integer idCliente, @Param("idFamiliar") Integer idFamiliar, @Param("idEmpresa") Integer idEmpresa);
	
	@Query("SELECT F, P, C FROM Familiar F, Cliente C, Parentesco P WHERE F.idEmpresa = :idEmpresa AND P.id.idFamiliar = F.idFamiliar AND C.id.id = P.id.idCliente GROUP BY F.idFamiliar")
	List<Object[]> findByIdEmpresa(@Param("idEmpresa") Integer idEmpresa);
	
	@Query("SELECT F, P, C FROM Familiar F, Cliente C, Parentesco P WHERE F.idEmpresa = :idEmpresa AND P.id.idCliente = :idCliente AND C.id.id = P.id.idCliente GROUP BY F.idFamiliar")
	List<Object[]> findByIdClienteIdEmpresa(@Param("idCliente") Integer idCliente, @Param("idEmpresa") Integer idEmpresa);
	
	@Query("DELETE FROM Familiar F WHERE F.id.idFamiliar = :idFamiliar AND F.id.idEmpresa = :idEmpresa")
	void excluirPorIdFamiliar(@Param("idFamiliar") Integer idFamiliar, @Param("idEmpresa") Integer idEmpresa);

}
