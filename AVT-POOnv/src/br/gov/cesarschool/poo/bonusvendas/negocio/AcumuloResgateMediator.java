package br.gov.cesarschool.poo.bonusvendas.negocio;

import java.text.SimpleDateFormat;
import java.util.Date;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.TipoResgate;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusCredito;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusDebito;
import br.gov.cesarschool.poo.bonusvendas.dao.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.dao.LancamentoBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;

public class AcumuloResgateMediator {
	private static AcumuloResgateMediator instance;
	private CaixaDeBonusDAO repositorioCaixaDeBonus;
	private LancamentoBonusDAO repositorioLancamento;
	
	private AcumuloResgateMediator() {
		repositorioCaixaDeBonus = new CaixaDeBonusDAO();
		repositorioLancamento = new LancamentoBonusDAO();
	}
	
	public static AcumuloResgateMediator getInstance() {
		if(instance == null) {
			instance = new AcumuloResgateMediator();
		}
		return instance;
	}
	
	public long gerarCaixaDeBonus(Vendedor vendedor) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String dataAtual = dateFormat.format(new Date());
		
		String cpfCompleto = vendedor.getCpf();
		String cpfSemUltimosDigitos = cpfCompleto.substring(0, cpfCompleto.length()-2);
		
		String numeroCaixaDeBonus = cpfSemUltimosDigitos + dataAtual;
		
		long numeroLong = Long.parseLong(numeroCaixaDeBonus);  //DÚVIDAS SE ISTO DÁ CERTO OU NÃO
		
		boolean inclusaoBemSucedida = repositorioCaixaDeBonus.incluir(new CaixaDeBonus(numeroLong));
		
		if(inclusaoBemSucedida) {
			return numeroLong;
		} else {
			return 0;
		}
	}
	
	public String acumularBonus(long numeroCaixaDeBonus, double valor) {
		if(valor <= 0.0) {
			return "Valor menor ou igual a zero";
		}
		
		CaixaDeBonus caixaDeBonus = repositorioCaixaDeBonus.buscar(numeroCaixaDeBonus);
		if(caixaDeBonus == null) {
			return "Caixa de bonus inexistente";
		}
		caixaDeBonus.creditar(valor);
		repositorioCaixaDeBonus.alterar(caixaDeBonus);
		repositorioLancamento.incluir(new LancamentoBonusCredito(numeroCaixaDeBonus, valor));
		return null;
	}
	
	public String resgatar(long numeroCaixaDeBonus, double valor, TipoResgate tipo) {
		if(valor <= 0.0) {
			return "Valor menor ou igual a zero";
		}
		
		CaixaDeBonus caixaDeBonus = repositorioCaixaDeBonus.buscar(numeroCaixaDeBonus);
		if(caixaDeBonus == null) {
			return "Caixa de bônus inexistente";
		}
		if(caixaDeBonus.getSaldo() < valor) {
			return "Saldo insuficiente";
		}
		caixaDeBonus.debitar(valor);
		repositorioCaixaDeBonus.alterar(caixaDeBonus);
		repositorioLancamento.incluir(new LancamentoBonusDebito(numeroCaixaDeBonus, valor, tipo)); //ele fala na especificação mediator "LancamentoBonusResgate" mas o unico lançamento que faz o que se pede no método é o LancamentoBonusDebito
		return null;
	}
}
