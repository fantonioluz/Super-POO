package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.util.Comparador;

public class ComparadorCaixaDeBonusSaldoDec implements Comparador {

    private static ComparadorCaixaDeBonusSaldoDec instancia;

    private ComparadorCaixaDeBonusSaldoDec() {

    }

    public static ComparadorCaixaDeBonusSaldoDec getInstance() {
        if (instancia == null) {
            instancia = new ComparadorCaixaDeBonusSaldoDec();
        }
        return instancia;
    }

    @Override
    public int comparar(Object o1, Object o2) {

        if (o1 instanceof CaixaDeBonus && o2 instanceof CaixaDeBonus) {
            CaixaDeBonus caixa1 = (CaixaDeBonus) o1;
            CaixaDeBonus caixa2 = (CaixaDeBonus) o2;

            int resultadoComparacao = Double.compare(caixa2.getSaldo(), caixa1.getSaldo());

            if (resultadoComparacao > 0) {
                return 1; 
            } else if (resultadoComparacao < 0) {
                return -1; 
            } else {
                return 0;
            }
        }

        return 0;
    }
}
