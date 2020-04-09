package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the sessao database table.
 *
 */
@Entity
@Table(name = "sessao")
public class Sessao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date expiracao;

	@Column(name = "id_usuario", nullable = false)
	private int idUsuario;

	@Column(nullable = false, length = 45)
	private String uuid;

	public Sessao() {

	}

	public int getId() {

		return this.id;
	}

	public void setId(final int id) {

		this.id = id;
	}

	public Date getExpiracao() {

		return this.expiracao;
	}

	public void setExpiracao(final Date expiracao) {

		this.expiracao = expiracao;
	}

	public int getIdUsuario() {

		return this.idUsuario;
	}

	public void setIdUsuario(final int idUsuario) {

		this.idUsuario = idUsuario;
	}

	public String getUuid() {

		return this.uuid;
	}

	public void setUuid(final String uuid) {

		this.uuid = uuid;
	}

}