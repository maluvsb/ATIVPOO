package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;
import java.io.Serializable;

public class CaixaDeBonus implements Serializable {
	//atributos privados
	private long numero;
	private double saldo;
	private LocalDateTime dataHoraAtualizacao;

	public CaixaDeBonus(long numero) {
		this.numero = numero;
		this.saldo = 0.0;
		this.dataHoraAtualizacao = LocalDateTime.now();
		
	}
	
	//só getters públicos, void creditar e debitar para adicional o saldo atual, e atualizar dataHoraAtualizacao com a data atual.
	
	public long getNumero() {
		return numero;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public LocalDateTime getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}
	
	public void creditar(double valor) {
		this.saldo += valor;
		this.dataHoraAtualizacao = LocalDateTime.now();
	}
	
	public void debitar(double valor) {
		this.saldo -= valor;
		this.dataHoraAtualizacao = LocalDateTime.now();
	}
}

