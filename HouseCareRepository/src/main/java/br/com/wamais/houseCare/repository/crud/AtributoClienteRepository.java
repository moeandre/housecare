package br.com.wamais.houseCare.repository.crud;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.AtributoCliente;

@Repository
public interface AtributoClienteRepository extends JpaRepository<AtributoCliente, Integer> {

	@Cacheable(value = "AtributoCliente.findByChave")
	@Query("SELECT A FROM AtributoCliente A WHERE A.chave = :chave AND A.idCliente = :idCliente AND A.idEmpresa = :idEmpresa")
	AtributoCliente findByChave(@Param("chave") String chave, @Param("idCliente") Integer idCliente, @Param("idEmpresa") Integer idEmpresa);
	
}
