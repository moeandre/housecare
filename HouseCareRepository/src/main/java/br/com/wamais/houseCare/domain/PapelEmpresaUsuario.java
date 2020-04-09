package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The persistent class for the papel_empresa_usuario database table.
 *
 */
@Entity
@Table(name = "papel_empresa_usuario")
public class PapelEmpresaUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PapelEmpresaUsuarioPK id;

	public PapelEmpresaUsuario() {

	}

	public PapelEmpresaUsuarioPK getId() {

		return this.id;
	}

	public void setId(final PapelEmpresaUsuarioPK id) {

		this.id = id;
	}

}