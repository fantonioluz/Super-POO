package br.gov.cesarschool.poo.bonusvendas.negocio;

import java.time.LocalDateTime;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;
import br.gov.cesarschool.poo.bonusvendas.util.Comparador;

public class ComparadorLancamentoBonusDHDec implements Comparador{
	private static final ComparadorLancamentoBonusDHDec instancia = new ComparadorLancamentoBonusDHDec();
	
	
	private ComparadorLancamentoBonusDHDec() {
		
	}
	
	public static ComparadorLancamentoBonusDHDec getInstance() {
		return instancia;
	}

	@Override
	public int comparar(Object o1, Object o2) {
		LancamentoBonus lancamento1 = (LancamentoBonus) o1;
		LancamentoBonus lancamento2 = (LancamentoBonus) o2;
		
		LocalDateTime dataHoraLancamento1 = lancamento1.getDataHoraLancamento();
		LocalDateTime dataHoraLancamento2 = lancamento2.getDataHoraLancamento();
		
		if(dataHoraLancamento1.compareTo(dataHoraLancamento2)> 0) {
			return -1;
		}else if(dataHoraLancamento1.compareTo(dataHoraLancamento2) == 0) {
			return 0;
		}
		return 1;
	}
	
	
}
