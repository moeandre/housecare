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
	@Query(value = "SELECT U.* FROM sessao S, usuario U WHERE S.id_usuario = U.id AND uuid = :uuid AND expiracao >= current_timestamp();", nativeQuery = true)
	Usuario findByUUID(@Param("uuid") String uuid);
	
}
