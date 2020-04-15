package br.com.wamais.houseCare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Fatura;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Integer> {

	
	@Query("SELECT F, C, L FROM Fatura F, Cobranca C, Lancamento L WHERE C.idEmpresa = :idEmpresa AND C.id = F.idCobranca AND L.idFatura = F.id")
	List<Object[]> listarPorEmpresa(@Param("idEmpresa") Integer idEmpresa);

	@Query("SELECT F, C, L FROM Fatura F, Cobranca C, Lancamento L WHERE F.id = :idFatura AND C.idEmpresa = :idEmpresa AND C.id = F.idCobranca AND L.idFatura = F.id")
	List<Object[]> obterPorIdEmpresa(@Param("idEmpresa") Integer idEmpresa, @Param("idFatura") Integer idFatura);
}
