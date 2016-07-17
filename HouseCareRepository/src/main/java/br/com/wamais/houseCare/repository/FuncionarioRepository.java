package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Funcionario;
import br.com.wamais.houseCare.domain.FuncionarioPK;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, FuncionarioPK> {

}
