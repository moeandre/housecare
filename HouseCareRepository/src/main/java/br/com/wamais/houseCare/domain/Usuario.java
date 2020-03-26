package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the usuario database table.
 *
 */
@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date criacao;

	private String email;

	private String login;

	private String nome;

	@JsonIgnore
	private String senha;

	private String telefone;

	@Transient
	private List<Empresa> empresas;

	@Transient
	private Empresa empresa;

	@Transient
	private List<AtributoPapel> atributos;

	@Transient
	private List<Papel> papeis;

	@Transient
	private Sessao sessao;

	public Empresa getEmpresa() {

		return empresa;
	}

	public void setEmpresa(Empresa empresa) {

		this.empresa = empresa;
	}

	public List<Empresa> getEmpresas() {

		return this.empresas;
	}

	public void setEmpresas(final List<Empresa> empresas) {

		this.empresas = empresas;
	}

	public List<AtributoPapel> getAtributos() {

		return this.atributos;
	}

	public void setAtributos(final List<AtributoPapel> atributos) {

		this.atributos = atributos;
	}

	public List<Papel> getPapeis() {

		return this.papeis;
	}

	public void setPapeis(final List<Papel> papeis) {

		this.papeis = papeis;
	}

	public Sessao getSessao() {

		return this.sessao;
	}

	public void setSessao(final Sessao sessao) {

		this.sessao = sessao;
	}

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

	public String getLogin() {

		return this.login;
	}

	public void setLogin(final String login) {

		this.login = login;
	}

	public String getNome() {

		return this.nome;
	}

	public void setNome(final String nome) {

		this.nome = nome;
	}

	public String getSenha() {

		return this.senha;
	}

	public void setSenha(final String senha) {

		this.senha = senha;
	}

	public String getTelefone() {

		return this.telefone;
	}

	public void setTelefone(final String telefone) {

		this.telefone = telefone;
	}

}