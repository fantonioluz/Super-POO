package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;

public class LancamentoBonusDebito extends LancamentoBonus {

    TipoResgate tipoResgate;

    public LancamentoBonusDebito(long numeroCaixaDeBunus, double valor, LocalDateTime dataHoraLancamento,
            TipoResgate tipoResgate) {
        super(numeroCaixaDeBunus, valor, dataHoraLancamento);
        this.tipoResgate = tipoResgate;
    }

    public TipoResgate getTipoResgate() {
        return tipoResgate;
    }

    

    
}
