package br.com.wamais.houseCare.service.test;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.wamais.houseCare.domain.Usuario;
import br.com.wamais.houseCare.service.IUsuarioService;

public class UsuarioSeviceTest extends AbstractTest {

	@Autowired
	private IUsuarioService service;

	@Test
	public void alterarTest() {

		boolean isOk = true;
		try {

			final Usuario usuario = service.obtemPorId(1);
			usuario.setAlteracao(Calendar.getInstance().getTime());
			service.alterar(usuario);
			isOk = null != usuario;
		} catch (final Exception e) {
			isOk = false;
			e.printStackTrace();
		}
		assertTrue(isOk);

	}

	@Test
	public void obtemPorIdTest() {

		boolean isOk = true;
		try {

			final Usuario usuario = service.obtemPorId(1);
			isOk = null != usuario;
		} catch (final Exception e) {
			isOk = false;
			e.printStackTrace();
		}
		assertTrue(isOk);

	}

}
