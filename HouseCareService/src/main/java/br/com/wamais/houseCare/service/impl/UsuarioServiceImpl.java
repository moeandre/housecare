package br.com.wamais.houseCare.service.impl;

import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Usuario;
import br.com.wamais.houseCare.form.LoginForm;
import br.com.wamais.houseCare.repository.UsuarioRepository;
import br.com.wamais.houseCare.service.IUsuarioService;
import br.com.wamais.houseCare.util.MD5Util;

@Service
@Transactional
public class UsuarioServiceImpl extends AbstractService<Usuario, Integer> implements IUsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	public void superRepository(final UsuarioRepository repository) {

		super.setRepository(repository);
	}

	@Override
	public Usuario login(final LoginForm form) {

		if (!StringUtils.isEmpty(form.getPass())) {
			try {
				form.setPass(MD5Util.md5(form.getPass()));
			} catch (final NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}

		return this.repository.findByLoginAndSenha(form.getUser(), form.getPass());
	}

	@Override
	public Usuario validarSessao(final String uuid) {

		return this.repository.findByUUID(uuid);
	}

}
