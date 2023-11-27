package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.util.Ordenadora.Comparador;

public class ComparadorVendedorNome implements Comparador {

    private static ComparadorVendedorNome instancia;

    private ComparadorVendedorNome() {
    }

    public static ComparadorVendedorNome getInstancia() {
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

            return vendedor1.getNome().compareTo(vendedor2.getNome());
        }

  
        return 0;
    }
}




