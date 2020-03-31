package br.com.wamais.houseCare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Anotacao;
import br.com.wamais.houseCare.domain.AnotacaoPK;

@Repository
public interface AnotacaoRepository extends JpaRepository<Anotacao, AnotacaoPK> {

	@Query(value = "SELECT A.* FROM anotacao A WHERE A.id_cliente = :idCliente AND A.id_empresa = :idEmpresa", nativeQuery = true)
	List<Anotacao> findByIdClienteIdEmpresa(@Param("idCliente") Integer idCliente, @Param("idEmpresa") Integer idEmpresa);

	@Query(value = "SELECT A.* FROM anotacao A WHERE A.id = :idAnotacao AND A.id_cliente = :idCliente AND A.id_empresa = :idEmpresa", nativeQuery = true)
	Anotacao findByIdIdClienteIdEmpresa(@Param("idCliente") Integer idCliente, @Param("idEmpresa") Integer idEmpresa, @Param("idAnotacao") Integer idAnotacao);
	
	@Query(value = "DETELE FROM anotacao A WHERE A.id = :idAnotacao AND A.id_cliente = :idCliente AND A.id_empresa = :idEmpresa", nativeQuery = true)
	void deleteByIdIdClienteIdEmpresa(@Param("idAnotacao") Integer idAnotacao, @Param("idCliente") Integer idCliente, @Param("idEmpresa") Integer idEmpresa);

}
