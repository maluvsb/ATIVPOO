package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;

public class LancamentoBonus {
	// todas as classes devem ser privadas
	
	private long numeroCaixaDeBonus;
	private double valor;
	private LocalDateTime dataHoraLancamento;
	
	// construtor deve inicializar todos os atributos
	public LancamentoBonus (long numeroCaixaDeBonus, double valor){
		this.numeroCaixaDeBonus = numeroCaixaDeBonus;
		this.valor = valor;
		this.dataHoraLancamento = LocalDateTime.now();
	}
	
	// métodos gets públicos para todos os atributos
	
	public long getNumeroCaixaDeBonus() {
		return numeroCaixaDeBonus;
	}
	
	public double getValor () {
		return valor;
	}
	
	public LocalDateTime getDataHoraLancamento() {
		return dataHoraLancamento;
	}
}