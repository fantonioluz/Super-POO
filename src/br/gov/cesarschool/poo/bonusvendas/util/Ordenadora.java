package br.gov.cesarschool.poo.bonusvendas.util


public class Ordenadora{

  private Ordendora(){

   }
   public static void ordenar(Object[] lista, Comparador comp){
       int tamanho = lista.length;

        for (int i = 0; i < tamanho - 1; i++) {
            for (int k = i + 1; k < tamanho; k++) {
                if (comp.comparar(lista[i], lista[k]) > 0) {
                    Object temp = lista[i];
                    lista[i] = lista[k];
                    lista[k] = temp;
                }
            }
        }  

   }
}

