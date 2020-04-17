package br.com.wamais.houseCare.repository.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Funcionario;
import br.com.wamais.houseCare.domain.FuncionarioPK;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, FuncionarioPK> {

	@Query("SELECT F, U FROM Funcionario F, Usuario U WHERE F.id.idEmpresa = :idEmpresa AND U.id = F.id.idUsuario")
	List<Object[]> findByIdEmpresa(@Param("idEmpresa") Integer idEmpresa);
	
	@Query("SELECT F, U FROM Funcionario F, Usuario U WHERE F.id.idEmpresa = :idEmpresa AND F.id.idUsuario = :idUsuario AND U.id = F.id.idUsuario")
	List<Object[]> obterPorIdEmpresa(@Param("idEmpresa") Integer idEmpresa, @Param("idUsuario") Integer idUsuario);

}
