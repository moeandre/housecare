package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

	@Query(value = "SELECT E.* FROM empresa E, funcionario F WHERE E.id = F.id_empresa AND F.id_usuario = :idUsuario AND F.situacao = 'A'", nativeQuery = true)
	public Empresa findByIdUsuario(@Param("idUsuario") Integer idUsuario);
}
