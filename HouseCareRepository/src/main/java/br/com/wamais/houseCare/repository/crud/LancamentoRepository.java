package br.com.wamais.houseCare.repository.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Lancamento;
import br.com.wamais.houseCare.domain.LancamentoPK;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, LancamentoPK> {

	@Query("SELECT L FROM Lancamento L WHERE L.id.idCliente = :idCliente AND L.id.idEmpresa = :idEmpresa")
	List<Lancamento> findByIdClienteIdEmpresa(@Param("idCliente") Integer idCliente, @Param("idEmpresa") Integer idEmpresa);
	
	@Query("SELECT L FROM Lancamento L WHERE L.id.idCliente = :idCliente AND L.id.idEmpresa = :idEmpresa AND L.idFatura is null")
	List<Lancamento> findPendentes(@Param("idCliente") Integer idCliente, @Param("idEmpresa") Integer idEmpresa);
	
}
