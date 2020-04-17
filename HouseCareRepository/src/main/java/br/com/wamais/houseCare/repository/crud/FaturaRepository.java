package br.com.wamais.houseCare.repository.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Fatura;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Integer> {

	
	@Query("SELECT F, C FROM Fatura F, Cliente C WHERE F.idEmpresa = :idEmpresa AND C.id.id = F.idCliente")
	List<Object[]> listarPorEmpresa(@Param("idEmpresa") Integer idEmpresa);
	
	@Query("SELECT F, C FROM Fatura F, Cliente C WHERE F.idEmpresa = :idEmpresa AND C.id.id = F.idCliente AND YEAR(F.data) = :ano AND MONTH(F.data) = :mes ")
	List<Object[]> listarPorEmpresa(@Param("idEmpresa") Integer idEmpresa, @Param("mes") Integer mes, @Param("ano") Integer ano);

	@Query("SELECT F, C, L FROM Fatura F, Lancamento L, Cliente C WHERE F.id = :idFatura AND F.idEmpresa = :idEmpresa AND L.idFatura = F.id AND C.id.id = F.idCliente")
	List<Object[]> obterPorIdEmpresa(@Param("idEmpresa") Integer idEmpresa, @Param("idFatura") Integer idFatura);
}
