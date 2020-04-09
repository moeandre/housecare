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

/**
 * The persistent class for the empresa database table.
 *
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date atualizacao;

	@Column(nullable = false, length = 18)
	private String cnpj;

	@Temporal(TemporalType.TIMESTAMP)
	private Date criacao;

	@Column(length = 100)
	private String dominio;

	@Column(nullable = false, length = 100)
	private String email;

	@Column(name = "nome_fantasia", length = 100)
	private String nomeFantasia;

	@Column(name = "razao_social", nullable = false, length = 100)
	private String razaoSocial;

	@Column(nullable = false, length = 2)
	private String situacao;

	@Column(nullable = false, length = 15)
	private String telefone;

	@Transient
	private List<Configuracao> configuracaos;

	public Empresa() {

	}

	public int getId() {

		return this.id;
	}

	public void setId(final int id) {

		this.id = id;
	}

	public Date getAtualizacao() {

		return this.atualizacao;
	}

	public void setAtualizacao(final Date atualizacao) {

		this.atualizacao = atualizacao;
	}

	public String getCnpj() {

		return this.cnpj;
	}

	public void setCnpj(final String cnpj) {

		this.cnpj = cnpj;
	}

	public Date getCriacao() {

		return this.criacao;
	}

	public void setCriacao(final Date criacao) {

		this.criacao = criacao;
	}

	public String getDominio() {

		return this.dominio;
	}

	public void setDominio(final String dominio) {

		this.dominio = dominio;
	}

	public String getEmail() {

		return this.email;
	}

	public void setEmail(final String email) {

		this.email = email;
	}

	public String getNomeFantasia() {

		return this.nomeFantasia;
	}

	public void setNomeFantasia(final String nomeFantasia) {

		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {

		return this.razaoSocial;
	}

	public void setRazaoSocial(final String razaoSocial) {

		this.razaoSocial = razaoSocial;
	}

	public String getSituacao() {

		return this.situacao;
	}

	public void setSituacao(final String situacao) {

		this.situacao = situacao;
	}

	public String getTelefone() {

		return this.telefone;
	}

	public void setTelefone(final String telefone) {

		this.telefone = telefone;
	}

	public List<Configuracao> getConfiguracaos() {

		return this.configuracaos;
	}

	public void setConfiguracaos(final List<Configuracao> configuracaos) {

		this.configuracaos = configuracaos;
	}

}