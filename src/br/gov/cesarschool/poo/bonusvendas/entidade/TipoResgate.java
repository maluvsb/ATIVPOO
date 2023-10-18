package br.gov.cesarschool.poo.bonusvendas.entidade;

public enum TipoResgate {
	PRODUTO(1, "Produto"),
	SERVICO(2, "Serviço"),
	CASH(3, "Cash");
	
	private final int codigo;
	private final String descricao;
	
	TipoResgate(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
