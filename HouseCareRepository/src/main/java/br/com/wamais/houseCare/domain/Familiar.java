package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.validation.Valid;

/**
 * The persistent class for the familiar database table.
 *
 */
@Entity
@Table(name = "familiar")
public class Familiar implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_familiar", unique = true, nullable = false)
	private int idFamiliar;

	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;

	@Column(length = 75)
	private String bairro;

	@Column(length = 9)
	private String cep;

	@Column(length = 45)
	private String complemento;

	@Column(length = 14)
	private String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date criacao;

	@Column(length = 75)
	private String email;

	@Column(name = "envio_fatura", length = 1)
	private String envioFatura;

	@Column(length = 2)
	private String estado;

	@Column(name = "id_contato")
	private Integer idContato;

	@Column(name = "id_empresa", nullable = false)
	private int idEmpresa;

	@Column(length = 150)
	private String logradouro;

	@Column(length = 75)
	private String municipio;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(length = 6)
	private String numero;

	@Column(length = 14)
	private String rg;

	@Column(nullable = false, length = 15)
	private String telefone;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ultimo_contato")
	private Date ultimoContato;

	@Transient
	private Parentesco parentesco;

	@Transient
	@Valid
	private List<Parentesco> parentescos;

	@Transient
	private List<AtributoFamiliar> atributos;

	public Familiar() {

		this.parentescos = new ArrayList<Parentesco>();
	}

	public int getIdFamiliar() {

		return this.idFamiliar;
	}

	public void setIdFamiliar(final int idFamiliar) {

		this.idFamiliar = idFamiliar;
	}

	public Date getAlteracao() {

		return this.alteracao;
	}

	public void setAlteracao(final Date alteracao) {

		this.alteracao = alteracao;
	}

	public String getBairro() {

		return this.bairro;
	}

	public void setBairro(final String bairro) {

		this.bairro = bairro;
	}

	public String getCep() {

		return this.cep;
	}

	public void setCep(final String cep) {

		this.cep = cep;
	}

	public String getComplemento() {

		return this.complemento;
	}

	public void setComplemento(final String complemento) {

		this.complemento = complemento;
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

	public String getEmail() {

		return this.email;
	}

	public void setEmail(final String email) {

		this.email = email;
	}

	public String getEnvioFatura() {

		return this.envioFatura;
	}

	public void setEnvioFatura(final String envioFatura) {

		this.envioFatura = envioFatura;
	}

	public String getEstado() {

		return this.estado;
	}

	public void setEstado(final String estado) {

		this.estado = estado;
	}

	public int getIdEmpresa() {

		return this.idEmpresa;
	}

	public void setIdEmpresa(final int idEmpresa) {

		this.idEmpresa = idEmpresa;
	}

	public String getLogradouro() {

		return this.logradouro;
	}

	public void setLogradouro(final String logradouro) {

		this.logradouro = logradouro;
	}

	public String getMunicipio() {

		return this.municipio;
	}

	public void setMunicipio(final String municipio) {

		this.municipio = municipio;
	}

	public String getNome() {

		return this.nome;
	}

	public void setNome(final String nome) {

		this.nome = nome;
	}

	public String getNumero() {

		return this.numero;
	}

	public void setNumero(final String numero) {

		this.numero = numero;
	}

	public String getRg() {

		return this.rg;
	}

	public void setRg(final String rg) {

		this.rg = rg;
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

	public List<AtributoFamiliar> getAtributos() {

		return this.atributos;
	}

	public void setAtributos(final List<AtributoFamiliar> atributos) {

		this.atributos = atributos;
	}

	public Integer getIdContato() {

		return this.idContato;
	}

	public void setIdContato(final Integer idContato) {

		this.idContato = idContato;
	}

	public Parentesco getParentesco() {

		return this.parentesco;
	}

	public void setParentesco(final Parentesco parentesco) {

		this.parentesco = parentesco;
		this.parentescos.add(parentesco);

	}

	public List<Parentesco> getParentescos() {

		return this.parentescos;
	}

	public void setParentescos(final List<Parentesco> parentescos) {

		this.parentescos = parentescos;
	}
	
	public void addParentesco(final Parentesco parentesco) {

		this.parentescos.add(parentesco);
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + this.idFamiliar;
		return result;
	}

	@Override
	public boolean equals(final Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Familiar other = (Familiar) obj;
		if (this.idFamiliar != other.idFamiliar) {
			return false;
		}
		return true;
	}

}