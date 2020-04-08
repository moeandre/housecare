package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * The persistent class for the familiar database table.
 *
 */
@Entity
@Table(name="familiar")
public class Familiar implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FamiliarPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date criacao;

	@NotBlank
	private String nome;

	@NotBlank
	private String parentesco;

	@NotBlank
	private String telefone;

	@Email
	private String email;

	private byte responsavel;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ultimo_contato")
	private Date ultimoContato;

	@Transient
	private Cliente cliente;

	public Familiar() {

	}

	public FamiliarPK getId() {

		return this.id;
	}

	public void setId(final FamiliarPK id) {

		this.id = id;
	}

	public Date getAlteracao() {

		return this.alteracao;
	}

	public void setAlteracao(final Date alteracao) {

		this.alteracao = alteracao;
	}

	public Date getCriacao() {

		return this.criacao;
	}

	public void setCriacao(final Date criacao) {

		this.criacao = criacao;
	}

	public String getEmail() {

		return this.email;
	}

	public void setEmail(final String email) {

		this.email = email;
	}

	public String getNome() {

		return this.nome;
	}

	public void setNome(final String nome) {

		this.nome = nome;
	}

	public String getParentesco() {

		return this.parentesco;
	}

	public void setParentesco(final String parentesco) {

		this.parentesco = parentesco;
	}

	public byte getResponsavel() {

		return this.responsavel;
	}

	public void setResponsavel(final byte responsavel) {

		this.responsavel = responsavel;
	}

	public String getTelefone() {

		return this.telefone;
	}

	public void setTelefone(final String telefone) {

		this.telefone = telefone;
	}

	public Date getUltimoContato() {

		return this.ultimoContato;
	}

	public void setUltimoContato(final Date ultimoContato) {

		this.ultimoContato = ultimoContato;
	}

	public Cliente getCliente() {

		return this.cliente;
	}

	public void setCliente(final Cliente cliente) {

		this.cliente = cliente;
	}

}