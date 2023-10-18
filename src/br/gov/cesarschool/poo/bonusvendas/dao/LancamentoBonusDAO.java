package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;
import java.time.LocalDateTime;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class LancamentoBonusDAO {
	//identificador unico do lançamento bonus é o número da baixa de bonus concatenado com a data e hora de lançamento
	private static final String BRANCO = "";
	private CadastroObjetos cadastro = new CadastroObjetos(LancamentoBonus.class);
	public boolean incluir(LancamentoBonus lancBonus) {
		LancamentoBonus lancBonusBusca = buscar(lancBonus.getDataHoraLancamento(), lancBonus.getNumeroCaixaDeBonus());
		if(lancBonusBusca != null) {
			return false;
		} else {
			cadastro.incluir(lancBonus, BRANCO + lancBonus.getDataHoraLancamento() + lancBonus.getNumeroCaixaDeBonus());
			return true;
		}
	}
	public boolean alterar(LancamentoBonus lancBonus) {
		LancamentoBonus lancBonusBusca = buscar(lancBonus.getDataHoraLancamento(), lancBonus.getNumeroCaixaDeBonus());
		if(lancBonusBusca == null) {
			return false;
		} else {
			cadastro.alterar(lancBonus, BRANCO + lancBonus.getDataHoraLancamento() + lancBonus.getNumeroCaixaDeBonus());
			return true;
		}
	}
	public LancamentoBonus buscar(LocalDateTime DataHoraLancamento, long NumeroCaixaDeBonus) {
		return (LancamentoBonus)cadastro.buscar(BRANCO + DataHoraLancamento + NumeroCaixaDeBonus);
	}
	public LancamentoBonus[] buscarTodos() {
		Serializable[] resultados = cadastro.buscarTodos(LancamentoBonus.class);
		LancamentoBonus[] LancamentosEncontrados = new LancamentoBonus[resultados.length];
		for( int i=0; i<resultados.length; i++) {
			LancamentosEncontrados[i] = (LancamentoBonus)resultados[i];
		}
		return LancamentosEncontrados;
	}
}
