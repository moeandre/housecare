package br.com.wamais.houseCare.controller;

import java.io.Serializable;
import java.util.Map;

public interface ICrudController<E, PK extends Serializable> extends IController {

	public abstract Map<String, Object> listar();

	public abstract Map<String, Object> detalhar(PK primaryKey);

	public abstract Map<String, Object> criar(E entity);

	public abstract Map<String, Object> editar(E entity, PK primaryKey);

	public abstract Map<String, Object> delete(PK primaryKey);

}