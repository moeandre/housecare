package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * The persistent class for the medicamento database table.
 * 
 */
@Entity
public class Medicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String medida;

	private int quantidade;

	private String volume;

	public Medicamento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedida() {
		return this.medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getVolume() {
		return this.volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

}