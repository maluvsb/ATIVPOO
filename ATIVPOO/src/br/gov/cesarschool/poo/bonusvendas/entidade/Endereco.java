package br.gov.cesarschool.poo.bonusvendas.entidade;

public class Endereco {
	// Todos os atributos devem ser privados
	private String logradouro;
	private int numero;
	private String complemento;
	private String cep;
	private String cidade;
	private String estado;
	private String pais;
	
	// construtores inicializados
	public Endereco(String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		
	}
	
	// Getters e setter como públicos segundo o solicitado
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouto(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
}