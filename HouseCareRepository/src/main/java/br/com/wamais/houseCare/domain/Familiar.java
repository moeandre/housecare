package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the familiar database table.
 * 
 */
@Entity
public class Familiar implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FamiliarPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date criacao;

	private String email;

	private String nome;

	private String parentesco;

	private byte responsavel;

	private String telefone;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ultimo_contato")
	private Date ultimoContato;

	public Familiar() {
	}

	public FamiliarPK getId() {
		return this.id;
	}

	public void setId(FamiliarPK id) {
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getParentesco() {
		return this.parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public byte getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(byte responsavel) {
		this.responsavel = responsavel;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getUltimoContato() {
		return this.ultimoContato;
	}

	public void setUltimoContato(Date ultimoContato) {
		this.ultimoContato = ultimoContato;
	}

}