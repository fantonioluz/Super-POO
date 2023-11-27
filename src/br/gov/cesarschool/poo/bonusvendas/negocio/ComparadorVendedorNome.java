package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.util.Comparador;
import br.gov.cesarschool.poo.bonusvendas.util.Ordenadora;

public class ComparadorVendedorNome implements Comparador {

    private static ComparadorVendedorNome instancia;

    private ComparadorVendedorNome() {

    }

    public static ComparadorVendedorNome getInstance() {
        if (instancia == null) {
            instancia = new ComparadorVendedorNome();
        }
        return instancia;
    }

    @Override
    public int comparar(Object o1, Object o2) {


        if (o1 instanceof Vendedor && o2 instanceof Vendedor) {
            Vendedor vendedor1 = (Vendedor) o1;
            Vendedor vendedor2 = (Vendedor) o2;


            int resultadoComparacao = vendedor1.getNomeCompleto().compareTo(vendedor2.getNomeCompleto());

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
