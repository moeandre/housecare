package br.com.wamais.houseCare.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum StatusFaturaEnum {

	ABERTA("A", "Aberta"),

	FECHADA("F", "Fechada"),

	CANCELADA("C", "Cancelada");

	public String codigo;
	public String descricao;

	private static final Map<String, StatusFaturaEnum> POR_CODIGO = new HashMap<String, StatusFaturaEnum>();

	static {

		POR_CODIGO.putAll(Arrays.asList(StatusFaturaEnum.values()).stream()
				.collect(Collectors.toMap(StatusFaturaEnum::getCodigo, statusFaturaEnum -> statusFaturaEnum)));

	}

	private StatusFaturaEnum(final String codigo, final String descricao) {

		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {

		return this.codigo;
	}

	public String getDescricao() {

		return this.descricao;
	}

	/**
	 * Lookup atraves do id
	 *
	 * @param codigo
	 *            da consulta
	 * @return Tipode consulta
	 */
	public static StatusFaturaEnum lookUpByCodigo(final String codigo) {

		StatusFaturaEnum retorno = StatusFaturaEnum.ABERTA;
		if (POR_CODIGO.containsKey(codigo)) {
			retorno = POR_CODIGO.get(codigo);
		}
		return retorno;
	}

}
