package br.gov.cesarschool.poo.bonusvendas.negocio.geral;

public class StringUtil {

    private StringUtil() {
        }

    public static boolean ehNuloOuBranco(String str){
        if(str == null || str.isEmpty()){
            return true;
        }
        return false;

    }
}