package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The persistent class for the usuario database table.
 *
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date criacao;

	@Column(nullable = false, length = 100)
	@Email
	private String email;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false, length = 45)
	@JsonIgnore
	private String senha;

	@Column(length = 15)
	private String telefone;

	@Transient
	private List<Empresa> empresas;

	@Transient
	private Empresa empresa;

	@Transient
	private List<Papel> papeis;

	@Transient
	private List<AtributoUsuario> atributos;

	@Transient
	private Sessao sessao;

	public Usuario() {

	}

	public int getId() {

		return this.id;
	}

	public void setId(final int id) {

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

	@JsonIgnore
	public String getSenha() {

		return this.senha;
	}

	@JsonProperty
	public void setSenha(final String senha) {

		this.senha = senha;
	}

	public String getTelefone() {

		return this.telefone;
	}

	public void setTelefone(final String telefone) {

		this.telefone = telefone;
	}

	public List<Empresa> getEmpresas() {

		return this.empresas;
	}

	public void setEmpresas(final List<Empresa> empresas) {

		this.empresas = empresas;
	}

	public Empresa getEmpresa() {

		return this.empresa;
	}

	public void setEmpresa(final Empresa empresa) {

		this.empresa = empresa;
	}

	public List<Papel> getPapeis() {

		return this.papeis;
	}

	public void setPapeis(final List<Papel> papeis) {

		this.papeis = papeis;
	}

	public List<AtributoUsuario> getAtributos() {

		return this.atributos;
	}

	public void setAtributos(final List<AtributoUsuario> atributos) {

		this.atributos = atributos;
	}

	public Sessao getSessao() {

		return this.sessao;
	}

	public void setSessao(final Sessao sessao) {

		this.sessao = sessao;
	}

}