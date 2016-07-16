package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the atributo_papel database table.
 * 
 */
@Entity
@Table(name="atributo_papel")
public class AtributoPapel implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AtributoPapelPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date criacao;

	private String mascara;

	private String nome;

	private String validacao;

	public AtributoPapel() {
	}

	public AtributoPapelPK getId() {
		return this.id;
	}

	public void setId(AtributoPapelPK id) {
		this.id = id;
	}

	public Date getCriacao() {
		return this.criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public String getMascara() {
		return this.mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValidacao() {
		return this.validacao;
	}

	public void setValidacao(String validacao) {
		this.validacao = validacao;
	}

}