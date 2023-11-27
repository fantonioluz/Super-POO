package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.util.Comparador;

public class ComparadorVendedorRenda implements Comparador {

    private static ComparadorVendedorRenda instancia;

    private ComparadorVendedorRenda() {

    }

    public static ComparadorVendedorRenda getInstance() {
        if (instancia == null) {
            instancia = new ComparadorVendedorRenda();
        }
        return instancia;
    }

    @Override
    public int comparar(Object o1, Object o2) {


        if (o1 instanceof Vendedor && o2 instanceof Vendedor) {
            Vendedor vendedor1 = (Vendedor) o1;
            Vendedor vendedor2 = (Vendedor) o2;


            if (vendedor1.getRenda() > vendedor2.getRenda()) {
                return 1;
            } else if (vendedor1.getRenda() < vendedor2.getRenda()) {
                return -1;
            } else {
                return 0;
            }
        }

        return 0;
    }
}
