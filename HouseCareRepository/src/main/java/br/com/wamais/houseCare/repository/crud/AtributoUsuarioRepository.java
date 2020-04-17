package br.com.wamais.houseCare.repository.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.AtributoUsuario;
import br.com.wamais.houseCare.domain.AtributoUsuarioPK;

@Repository
public interface AtributoUsuarioRepository extends JpaRepository<AtributoUsuario, AtributoUsuarioPK> {

}
