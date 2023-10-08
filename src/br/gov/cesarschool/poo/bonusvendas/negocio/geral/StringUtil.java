package br.gov.cesarschool.poo.bonusvendas.negocio.geral;

public class StringUtil {

    private StringUtil() {
        }

    public static boolean ehNuloOuBranco(String str){
         String strSemEspaco = str.trim();
        if(str == null || strSemEspaco.isEmpty()){
            return true;
        }

    }
}