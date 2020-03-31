package br.com.wamais.houseCare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Lancamento;
import br.com.wamais.houseCare.domain.LancamentoPK;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, LancamentoPK> {

	@Query(value = "SELECT L.* FROM lancamento L WHERE L.id_cliente = :idCliente AND L.id_empresa = :idEmpresa", nativeQuery = true)
	List<Lancamento> findByIdClienteIdEmpresa(@Param("idCliente") Integer idCliente, @Param("idEmpresa") Integer idEmpresa);

}
