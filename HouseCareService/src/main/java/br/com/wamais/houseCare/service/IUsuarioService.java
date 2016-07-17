package br.com.wamais.houseCare.service;

import br.com.wamais.houseCare.domain.Usuario;
import br.com.wamais.houseCare.form.LoginForm;

public interface IUsuarioService extends ICrudService<Usuario, Integer> {

	public abstract Usuario login(LoginForm form);
	
	public abstract Usuario validarSessao(String uuid);

}
