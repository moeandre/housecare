package br.com.wamais.houseCare.repository.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.wamais.houseCare.domain.Usuario;
import br.com.wamais.houseCare.repository.UsuarioRepository;

public class UsuarioRepositoryTest extends AbstractTest {

	@Autowired
	private UsuarioRepository repository;

	@Test
	public void findOne() {
		boolean isOk = true;
		try {
			final Usuario amizade = repository.getOne(1);
			isOk = amizade != null;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		assertTrue(isOk);

	}

}
