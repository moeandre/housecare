package br.com.wamais.houseCare.repository.crud;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Configuracao;
import br.com.wamais.houseCare.domain.ConfiguracaoPK;

@Repository
public interface ConfiguracaoRepository extends JpaRepository<Configuracao, ConfiguracaoPK> {

	@Cacheable(value = "Configuracao.findByChave")
	@Query("SELECT C FROM Configuracao C WHERE C.chave = :chave AND C.id.idEmpresa = :idEmpresa")
	Configuracao findByChave(@Param("chave") String chave, @Param("idEmpresa") Integer idEmpresa);
}
