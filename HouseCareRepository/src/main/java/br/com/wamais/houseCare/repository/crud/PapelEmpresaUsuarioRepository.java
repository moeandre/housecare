package br.com.wamais.houseCare.repository.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.PapelEmpresaUsuario;
import br.com.wamais.houseCare.domain.PapelEmpresaUsuarioPK;

@Repository
public interface PapelEmpresaUsuarioRepository extends JpaRepository<PapelEmpresaUsuario, PapelEmpresaUsuarioPK> {

}
