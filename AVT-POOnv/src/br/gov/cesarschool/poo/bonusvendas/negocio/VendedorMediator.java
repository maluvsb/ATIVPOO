package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.ValidadorCPF;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.StringUtil;

public class VendedorMediator {
	private static VendedorMediator instance;
	private VendedorDAO repositorioVendedor;
	private AcumuloResgateMediator caixaDeBonusMediator;
	
	private VendedorMediator() {
		repositorioVendedor = new VendedorDAO();
		caixaDeBonusMediator = AcumuloResgateMediator.getInstance();
	}
	
	public static VendedorMediator getInstance() {
		if(instance == null) {
			instance = new VendedorMediator();
		}
		return instance;
	}
	
	public ResultadoInclusaoVendedor incluir(Vendedor vendedor) {
		String validacao = validar(vendedor);
		if(validacao != null) {
			return new ResultadoInclusaoVendedor(0,validacao);
		}
		
		if(!repositorioVendedor.incluir(vendedor)) {
			return new ResultadoInclusaoVendedor(0, "Vendedor já existente");
		}
		
		long numeroCaixaDeBonus = caixaDeBonusMediator.gerarCaixaDeBonus(vendedor);
		if (numeroCaixaDeBonus == 0) {
			return new ResultadoInclusaoVendedor(0, "Caixa de bonus não foi gerada");
		}
		return new ResultadoInclusaoVendedor(numeroCaixaDeBonus, null);
	}
	
	public String alterar(Vendedor vendedor) {
		String validacao = validar(vendedor);
		if(validacao != null) {
			return validacao;
		}
		if(repositorioVendedor.buscar(vendedor.getCpf())==null) {
			return "Vendedor inexistente";
		}
		repositorioVendedor.alterar(vendedor);
		return null;
	}
	
	public String validar(Vendedor vendedor) {
		if(vendedor.getCpf()==null) {
			return "CPF não informado";
		} else if(!ValidadorCPF.ehCpfValido(vendedor.getCpf())) {
			return "CPF inválido";
		} 
		if(StringUtil.ehNuloOuBranco(vendedor.getNomeCompleto())) {
			return "Nome completo não informado";
		}
		if(vendedor.getSexo()==null) {
			return "Sexo não informado";
		}
		if(vendedor.getDataNascimento()==null) {
			return "Data de nascimento não informada";
		} else if(vendedor.calcularIdade()<=17) {
			return "Data de nascimento inválida";
		}
		if(vendedor.getRenda()<0.0) {
			return "Renda menor que zero";
		}
		if(vendedor.getEndereco()==null) {
			return "Endereço não informado";
		}
		if(StringUtil.ehNuloOuBranco(vendedor.getEndereco().getLogradouro())) {
			return "Logradouro não informado";
		} else if(vendedor.getEndereco().getLogradouro().length()<4) {
			return "Logradouro tem menos de 04 caracteres";
		}
		if(vendedor.getEndereco().getNumero()<0) {
			return "Numero menor que zero";
		}
		if(StringUtil.ehNuloOuBranco(vendedor.getEndereco().getCidade())) {
			return "Cidade não informada";
		}
		if(StringUtil.ehNuloOuBranco(vendedor.getEndereco().getEstado())) {
			return "Estado não informado";
		}
		if(StringUtil.ehNuloOuBranco(vendedor.getEndereco().getPais())) {
			return "País não informado";
		}
		return null;
	}
}
