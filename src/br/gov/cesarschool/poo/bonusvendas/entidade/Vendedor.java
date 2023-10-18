package br.gov.cesarschool.poo.bonusvendas.entidade;

import br.gov.cesarschool.poo.bonusvendas.entidade.geral.*;

import java.time.LocalDateTime;

import java.io.Serializable;

public class Vendedor implements Serializable{
	//atributos privados
	private String cpf;
	private String nomeCompleto;
	private Sexo sexo;
	private LocalDateTime dataNascimento;
	private double renda;
	private Endereco endereco;
	
	//construtor deve inicializar todos os atributos das classes
	public Vendedor (String cpf, String nomeCompleto, Sexo sexo, LocalDateTime dataNascimento, double renda, Endereco endereco) {
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.renda = renda;
		this.endereco = endereco;
	}
	
	//set's públicos, exceto cpf, gets públicos, método int que calcula idade dataAtual - datadeNascimento
	
	public String getCpf () {
		return cpf;
	}
	
	public String getNomeCompleto () {
		return nomeCompleto;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public Sexo getSexo () {
		return sexo;
	}
	
	public void setSexo (Sexo sexo) {
		this.sexo = sexo;
	}
	
	public LocalDateTime getDataNascimento () {
		return dataNascimento;
	}
	
	public void setDataNascimento (LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public double getRenda () {
		return renda;
	}
	
	public void setRenda (double renda) {
		this.renda = renda;
	}
	
	public Endereco getEndereco () {
		return endereco;
	}
	
	public void setEndereco (Endereco endereco) {
		this.endereco = endereco;
	}
	
	public int calcularIdade() {
        LocalDateTime dataAtual = LocalDateTime.now();
        return dataAtual.getYear() - dataNascimento.getYear();
    }
}