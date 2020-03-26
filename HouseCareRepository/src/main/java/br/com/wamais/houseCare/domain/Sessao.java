package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the sessao database table.
 * 
 */
@Entity
public class Sessao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date expiracao;

	@Column(name="id_usuario")
	@JsonIgnore
	private int idUsuario;

	private String uuid;

	public Sessao() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getExpiracao() {
		return this.expiracao;
	}

	public void setExpiracao(Date expiracao) {
		this.expiracao = expiracao;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}