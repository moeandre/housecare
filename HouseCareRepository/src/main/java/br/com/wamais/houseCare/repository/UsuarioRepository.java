package br.com.wamais.houseCare.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByEmailAndSenha(String email, String senha);

	@Cacheable(value = "findByUUID")
	@Query("SELECT U FROM Sessao S, Usuario U WHERE S.idUsuario = U.id AND S.uuid = :uuid AND S.expiracao >= current_timestamp();")
	Usuario findByUUID(@Param("uuid") String uuid);
	
}
