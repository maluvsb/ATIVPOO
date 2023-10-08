package br.gov.cesarschool.poo.bonusvendas.entidade;

public class LancamentoBonusDebito extends LancamentoBonus {
    private TipoResgate tipoResgate;

    public LancamentoBonusDebito(long numeroCaixaDeBonus, double valor, TipoResgate tipoResgate) {
        super(numeroCaixaDeBonus, valor);
        this.tipoResgate = tipoResgate;
    }

    public TipoResgate getTipoResgate() {
        return tipoResgate;
    }
}