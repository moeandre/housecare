package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByLoginAndSenha(String login, String senha);
	
	
	@Query(value="SELECT U.* FROM sessao S, usuario U WHERE S.id_usuario = U.id AND uuid = :uuid AND expiracao >= current_timestamp();", nativeQuery=true)
	public Usuario findByUUID(@Param("uuid") String uuid);

	// @Query("SELECT DISTINCT m FROM Mommy m JOIN m.amigas a WHERE m.id = :idMommy")
	// public List<Mommy> findByMommy(@Param("idMommy") Integer idMommy);
	//
	// @Query("SELECT m FROM Amizade a INNER JOIN a.mommy m WHERE m.id = :idMommy")
	// public List<Amizade> findByMommyId(@Param("idMommy") Integer idMommy);
	//
	//
}
