package br.com.wamais.houseCare.service.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.wamais.houseCare.domain.Usuario;
import br.com.wamais.houseCare.form.LoginForm;
import br.com.wamais.houseCare.service.IUsuarioService;

public class UsuarioSeviceTest extends AbstractTest {

	@Autowired
	private IUsuarioService service;

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
	
	@Test
	public void loginTest() {

		boolean isOk = true;
		try {

			final LoginForm login = new LoginForm();
			login.setUser("296.031.058-64");
			login.setPass("12345");
			final Usuario usuario = service.login(login);
			isOk = usuario != null;
		} catch (final Exception e) {
			isOk = false;
			e.printStackTrace();
		}
		assertTrue(isOk);

	}
	
	@Test
	public void validarSessaoTest() {

		boolean isOk = true;
		try {

			final Usuario usuario = service.validarSessao("50322881-dd89-4406-a3c9-beefd246c34b");
			isOk = usuario != null;
		} catch (final Exception e) {
			isOk = false;
			e.printStackTrace();
		}
		assertTrue(isOk);

	}

}
