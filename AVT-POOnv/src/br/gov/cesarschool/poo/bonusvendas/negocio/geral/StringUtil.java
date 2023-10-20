package br.gov.cesarschool.poo.bonusvendas.negocio.geral;

public class StringUtil {
	public StringUtil() {
		
	}
	public static boolean ehNuloOuBranco(String str) {
		return str == null || str.trim().isEmpty();
	}
}
