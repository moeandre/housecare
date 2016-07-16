package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the cuidado database table.
 * 
 */
@Entity
public class Cuidado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date criacao;

	@Lob
	private String descricao;

	private byte manha;

	private byte noite;

	private String nome;

	private byte tarde;

	public Cuidado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAlteracao() {
		return this.alteracao;
	}

	public void setAlteracao(Date alteracao) {
		this.alteracao = alteracao;
	}

	public Date getCriacao() {
		return this.criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte getManha() {
		return this.manha;
	}

	public void setManha(byte manha) {
		this.manha = manha;
	}

	public byte getNoite() {
		return this.noite;
	}

	public void setNoite(byte noite) {
		this.noite = noite;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte getTarde() {
		return this.tarde;
	}

	public void setTarde(byte tarde) {
		this.tarde = tarde;
	}

}