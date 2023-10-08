package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;

public class LancamentoBonusCredito extends LancamentoBonus {
    
public LancamentoBonusCredito(long numeroCaixaDeBunus, double valor, LocalDateTime dataHoraLancamento) {
        super(numeroCaixaDeBunus, valor, dataHoraLancamento);
    }

}
