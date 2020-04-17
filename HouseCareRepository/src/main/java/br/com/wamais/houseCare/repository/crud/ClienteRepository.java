package br.com.wamais.houseCare.repository.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Cliente;
import br.com.wamais.houseCare.domain.ClientePK;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, ClientePK> {

	List<Cliente> findByIdIdEmpresa(Integer idEmpresa);
}
