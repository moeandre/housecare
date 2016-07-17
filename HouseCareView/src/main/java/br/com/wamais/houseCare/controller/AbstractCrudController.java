package br.com.wamais.houseCare.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import br.com.wamais.houseCare.service.ICrudService;

@Component
public abstract class AbstractCrudController<E, PK extends Serializable> extends AbstractController implements ICrudController<E, PK> {

	private transient ICrudService<E, PK> service;

	public ICrudService<E, PK> getService() {

		return this.service;
	}

	public void setService(final ICrudService<E, PK> service) {

		this.service = service;
	}

	public abstract void superService();
	
	@Override
	public Map<String, Object> listar() {

		final Map<String, Object> retval = new HashMap<String, Object>();
		retval.put("success", Boolean.TRUE);
		retval.put("results", this.getService().listarTodos());
		return retval;
	}

	@Override
	public Map<String, Object> detalhar(final PK primaryKey) {

		final Map<String, Object> retval = new HashMap<String, Object>();
		retval.put("success", Boolean.TRUE);
		retval.put("result", this.getService().obtemPorId(primaryKey));
		return retval;
	}

	@Override
	public Map<String, Object> criar(final E entity) {

		this.getService().alterar(entity);

		final Map<String, Object> retval = new HashMap<String, Object>();
		retval.put("success", Boolean.TRUE);
		retval.put("result", entity);
		return retval;
	}

	@Override
	public Map<String, Object> editar(final E entity, final PK primaryKey) {

		this.getService().alterar(entity);

		final Map<String, Object> retval = new HashMap<String, Object>();
		retval.put("success", Boolean.TRUE);
		return retval;
	}

	@Override
	public Map<String, Object> delete(final PK primaryKey) {

		this.getService().excluirPorId(primaryKey);

		final Map<String, Object> retval = new HashMap<String, Object>();
		retval.put("success", Boolean.TRUE);
		return retval;
	}

}
