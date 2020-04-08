package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClientePK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;

	@NotNull(message = "Por favor, informe o apelido")
	private String apelido;

	@NotNull(message = "Por favor, informe o cpf")
	private String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	private Date criacao;

	@NotNull(message = "Por favor, informe a nacionalidade")
	private String nacionalidade;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull(message = "Por favor, informe o nascimento")
	@Past
	private Date nascimento;

	private String naturalidade;

	@NotNull(message = "Por favor, informe o nome")
	private String nome;

	@NotNull(message = "Por favor, informe o sobrenome")
	private String sobrenome;

	public Cliente() {
	}

	public ClientePK getId() {
		return this.id;
	}

	public void setId(ClientePK id) {
		this.id = id;
	}

	public Date getAlteracao() {
		return this.alteracao;
	}

	public void setAlteracao(Date alteracao) {
		this.alteracao = alteracao;
	}

	public String getApelido() {
		return this.apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getCriacao() {
		return this.criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public String getNacionalidade() {
		return this.nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Date getNascimento() {
		return this.nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getNaturalidade() {
		return this.naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

}