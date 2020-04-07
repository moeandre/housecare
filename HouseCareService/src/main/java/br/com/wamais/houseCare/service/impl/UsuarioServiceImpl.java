package br.com.wamais.houseCare.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Usuario;
import br.com.wamais.houseCare.repository.UsuarioRepository;
import br.com.wamais.houseCare.service.IUsuarioService;
import br.com.wamais.houseCare.util.MD5Util;

@Service
@Transactional
public class UsuarioServiceImpl extends AbstractService<Usuario, Integer> implements IUsuarioService {

	@Autowired
	public void superRepository(final UsuarioRepository repository) {

		super.setRepository(repository);
	}

	@Override
	public Usuario alterar(final Usuario usuario) throws ConstraintViolationException {

		if (!StringUtils.isEmpty(usuario.getSenha())) {
			try {
				usuario.setSenha(MD5Util.md5(usuario.getSenha()));
			} catch (final NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}

		// Edita apenas as propriedades alteradas
		Usuario usuarioExistente = usuario;
		if (usuario.getId() != 0) {
			usuarioExistente = this.obtemPorId(usuario.getId());
			try {
				BeanUtils.copyProperties(usuario, usuarioExistente, getNullPropertyNames(usuario));
			} catch (final Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		usuarioExistente.setAlteracao(Calendar.getInstance().getTime());
		if (null == usuarioExistente.getCriacao()) {
			usuarioExistente.setCriacao(Calendar.getInstance().getTime());
		}

		return super.salvarComRetorno(usuarioExistente);
	}

	public static String[] getNullPropertyNames(final Object source) {

		final BeanWrapper src = new BeanWrapperImpl(source);
		final java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		final Set<String> emptyNames = new HashSet<String>();
		for (final java.beans.PropertyDescriptor pd : pds) {
			final Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null) {
				emptyNames.add(pd.getName());
			}
		}
		final String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

}
