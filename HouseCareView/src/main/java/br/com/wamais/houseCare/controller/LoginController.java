package br.com.wamais.houseCare.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.wamais.houseCare.domain.Usuario;
import br.com.wamais.houseCare.form.LoginForm;
import br.com.wamais.houseCare.service.ILoginService;

@RestController
@Transactional
@RequestMapping("/login")
public class LoginController extends AbstractController {

	@Autowired
	private transient ILoginService service;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Object> criar(@RequestBody LoginForm login, final HttpServletResponse response) {

		final Map<String, Object> retval = new HashMap<String, Object>();
		final Usuario usuario = this.service.login(login);
		if (null != usuario && usuario.getId() > 0) {
			retval.put("success", Boolean.TRUE);
			retval.put("account", usuario);
		} else {
			retval.put("success", Boolean.FALSE);
			retval.put("message", "Usuário ou Senha inválidos.");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}

		return retval;
	}

}
