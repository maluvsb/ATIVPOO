package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
public class VendedorDAO {
	private static final String BRANCO = "";
	private CadastroObjetos cadastro = new CadastroObjetos(Vendedor.class);
	public boolean incluir(Vendedor vend) {
		Vendedor vendBusca = buscar(vend.getCpf());
		if(vendBusca != null) {
			return false;
		} else {
			cadastro.incluir(vend, BRANCO + vend.getCpf());
			return true;
		}
	}
	public boolean alterar(Vendedor vend) {
		Vendedor vendBusca = buscar(vend.getCpf());
		if (vendBusca == null) {
			return false;
		} else {
			cadastro.alterar(vend, BRANCO + vend.getCpf());
			return true;
		}
	}
	public Vendedor buscar(String cpf) {
		return (Vendedor)cadastro.buscar(BRANCO + cpf);
	}
	public Vendedor[] buscarTodos() {
		Serializable[] resultados = cadastro.buscarTodos(Vendedor.class);
		Vendedor[] vendedoresEncontrados = new Vendedor[resultados.length];
		for(int i=0; i<resultados.length; i++) {
			vendedoresEncontrados[i] = (Vendedor)resultados[i];
		}
		return vendedoresEncontrados;
	}
}
