package br.com.wamais.houseCare.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Sessao;
import br.com.wamais.houseCare.domain.Usuario;
import br.com.wamais.houseCare.form.LoginForm;
import br.com.wamais.houseCare.repository.UsuarioRepository;
import br.com.wamais.houseCare.service.IEmpresaService;
import br.com.wamais.houseCare.service.ILoginService;
import br.com.wamais.houseCare.service.IPapelService;
import br.com.wamais.houseCare.service.ISessaoService;
import br.com.wamais.houseCare.util.MD5Util;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private ISessaoService sService;

	@Autowired
	private IPapelService pService;
	
	@Autowired
	private IEmpresaService eService;
	
	@Override
	public Usuario login(final LoginForm form) {

		if (!StringUtils.isEmpty(form.getPass())) {
			try {
				form.setPass(MD5Util.md5(form.getPass()));
			} catch (final NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}

		final Usuario usuario = this.repository.findByEmailAndSenha(form.getUser(), form.getPass());

		if (null != usuario) {
			final Sessao sessao = this.gerarSessao(usuario);
			usuario.setSessao(sessao);
			
			usuario.setPapeis(pService.findByIdUsuario(usuario.getId()));
			usuario.setEmpresa(eService.findByIdUsuario(usuario.getId()));
			
			
		}

		return usuario;
	}

	@Override
	public Usuario validarSessao(final String uuid) {

		return this.repository.findByUUID(uuid);
	}

	private Sessao gerarSessao(final Usuario usuario) {

		this.sService.deleteByIdUsuario(usuario.getId());

		final Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 7);

		final Sessao sessao = new Sessao();
		sessao.setIdUsuario(usuario.getId());
		sessao.setUuid(UUID.randomUUID().toString());
		sessao.setExpiracao(c.getTime());

		return this.sService.salvarComRetorno(sessao);

	}
}
