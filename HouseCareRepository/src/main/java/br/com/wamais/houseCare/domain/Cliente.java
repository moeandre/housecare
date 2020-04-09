package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * The persistent class for the cliente database table.
 *
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClientePK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;

	@Column(nullable = false, length = 75)
	private String apelido;

	@Column(nullable = false, length = 14)
	private String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	private Date criacao;

	@Column(name = "estado_civil", length = 2)
	private String estadoCivil;

	@Column(nullable = false, length = 75)
	private String nacionalidade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date nascimento;

	@Column(length = 75)
	private String naturalidade;

	@Column(nullable = false, length = 75)
	private String nome;

	@Column(nullable = false, length = 75)
	private String sobrenome;

	@Transient
	private List<AtributoCliente> atributos;

	public Cliente() {

	}

	public ClientePK getId() {

		return this.id;
	}

	public void setId(final ClientePK id) {

		this.id = id;
	}

	public Date getAlteracao() {

		return this.alteracao;
	}

	public void setAlteracao(final Date alteracao) {

		this.alteracao = alteracao;
	}

	public String getApelido() {

		return this.apelido;
	}

	public void setApelido(final String apelido) {

		this.apelido = apelido;
	}

	public String getCpf() {

		return this.cpf;
	}

	public void setCpf(final String cpf) {

		this.cpf = cpf;
	}

	public Date getCriacao() {

		return this.criacao;
	}

	public void setCriacao(final Date criacao) {

		this.criacao = criacao;
	}

	public String getEstadoCivil() {

		return this.estadoCivil;
	}

	public void setEstadoCivil(final String estadoCivil) {

		this.estadoCivil = estadoCivil;
	}

	public String getNacionalidade() {

		return this.nacionalidade;
	}

	public void setNacionalidade(final String nacionalidade) {

		this.nacionalidade = nacionalidade;
	}

	public Date getNascimento() {

		return this.nascimento;
	}

	public void setNascimento(final Date nascimento) {

		this.nascimento = nascimento;
	}

	public String getNaturalidade() {

		return this.naturalidade;
	}

	public void setNaturalidade(final String naturalidade) {

		this.naturalidade = naturalidade;
	}

	public String getNome() {

		return this.nome;
	}

	public void setNome(final String nome) {

		this.nome = nome;
	}

	public String getSobrenome() {

		return this.sobrenome;
	}

	public void setSobrenome(final String sobrenome) {

		this.sobrenome = sobrenome;
	}

	public List<AtributoCliente> getAtributos() {

		return this.atributos;
	}

	public void setAtributos(final List<AtributoCliente> atributos) {

		this.atributos = atributos;
	}

}