package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Parentesco;
import br.com.wamais.houseCare.domain.ParentescoPK;

@Repository
public interface ParentescoRepository extends JpaRepository<Parentesco, ParentescoPK> {

	
	@Transactional
	@Modifying
	@Query("DELETE FROM Parentesco P WHERE P.id.idFamiliar = :idFamiliar AND P.id.idEmpresa = :idEmpresa")
	void excluirPorIdFamiliar(@Param("idFamiliar") Integer idFamiliar, @Param("idEmpresa") Integer idEmpresa);
	
}
