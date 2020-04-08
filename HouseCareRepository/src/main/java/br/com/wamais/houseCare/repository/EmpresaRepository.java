package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

	@Query("SELECT E FROM Empresa E, Funcionario F WHERE E.id = F.id.idEmpresa AND F.id.idUsuario = :idUsuario AND F.situacao = 'A'")
	public Empresa findByIdUsuario(@Param("idUsuario") Integer idUsuario);
}
