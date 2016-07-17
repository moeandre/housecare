package br.com.wamais.houseCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wamais.houseCare.domain.Inventario;
import br.com.wamais.houseCare.domain.InventarioPK;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, InventarioPK> {

}
