package br.com.wamais.houseCare.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.service.ICrudService;

public abstract class AbstractService<E, PK extends Serializable> implements ICrudService<E, PK> {

	private JpaRepository<E, PK> repository;
	
	public JpaRepository<E, PK> getRepository() {

		return this.repository;
	}

	public void setRepository(final JpaRepository<E, PK> repository) {

		this.repository = repository;
	}

	@Override
	@Transactional
	public void salvar(final E entity) {

		this.getRepository().saveAndFlush(entity);
	}

	@Override
	@Transactional
	public E salvarComRetorno(final E entity) {

		return this.getRepository().saveAndFlush(entity);
	}

	@Override
	@Transactional
	public E alterar(final E entity) {

		return this.getRepository().saveAndFlush(entity);
	}

	@Override
	@Transactional
	public List<E> alterar(final List<E> entities) {

		return this.getRepository().save(entities);
	}

	@Override
	@Transactional
	public E obtemPorId(final PK primaryKey) {

		return this.getRepository().findOne(primaryKey);
	}

	@Override
	@Transactional
	public void excluirPorId(final PK primaryKey) {

		this.getRepository().delete(primaryKey);
	
	}

	@Override
	@Transactional
	public Collection<E> pesquisarTodos() {

		return this.getRepository().findAll();
	}

	@Override
	@Transactional
	public Page<E> pesquisarTodos(final Pageable pageable) {

		return this.getRepository().findAll(pageable);
	}

	@Override
	@Transactional
	public Collection<E> listarTodos() {

		return this.getRepository().findAll();
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