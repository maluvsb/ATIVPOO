package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class CaixaDeBonusDAO {
	private static final String BRANCO ="";
	private CadastroObjetos cadastro = new CadastroObjetos(CaixaDeBonus.class);
	public boolean incluir(CaixaDeBonus caixabonus) {
		CaixaDeBonus caixabonusBusca = buscar(caixabonus.getNumero());
		if(caixabonusBusca != null) {
			return false;
		} else {
			cadastro.incluir(caixabonus, BRANCO + caixabonus.getNumero());
			return true;
		}
	}
	public boolean alterar(CaixaDeBonus caixabonus) {
		CaixaDeBonus caixabonusBusca = buscar(caixabonus.getNumero());
		if(caixabonusBusca == null) {
			return false;
		} else {
			cadastro.alterar(caixabonus, BRANCO + caixabonus.getNumero());
			return true;
		}
	}
	public CaixaDeBonus buscar(long Numero) {
		return (CaixaDeBonus)cadastro.buscar(BRANCO + Numero);
	}
	public CaixaDeBonus[] buscarTodos() {
		Serializable[] resultados = cadastro.buscarTodos(CaixaDeBonus.class);
		CaixaDeBonus[] caixasEncontradas = new CaixaDeBonus[resultados.length];
		for(int i=0; i<resultados.length; i++) {
			caixasEncontradas[i] = (CaixaDeBonus)resultados[i];
		}
		return caixasEncontradas;
	}
}
