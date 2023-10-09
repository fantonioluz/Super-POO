package br.gov.cesarschool.poo.bonusvendas.negocio.geral;

public class ValidadorCPF {
    private ValidadorCPF() {
    }

    public static boolean ehCpfValido(String cpf){
        if(StringUtil.ehNuloOuBranco(cpf)){
            return false;
        }
        if(cpf.length() != 11){
            return false;
        }
        if(!cpf.matches("[0-9]+")){
            return false;
        }
        if(cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333")
        || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777")
        || cpf.equals("88888888888") || cpf.equals("99999999999")){
            return false;
        }
        int soma = 0;
        int resto = 0;
        for(int i = 0; i < 9; i++){
            soma += Integer.parseInt(cpf.substring(i, i+1)) * (10 - i);
        }
        resto = 11 - (soma % 11);
        if(resto == 10 || resto == 11){
            resto = 0;
        }
        if(resto != Integer.parseInt(cpf.substring(9, 10))){
            return false;
        }
        soma = 0;
        for(int i = 0; i < 10; i++){
            soma += Integer.parseInt(cpf.substring(i, i+1)) * (11 - i);
        }
        resto = 11 - (soma % 11);
        if(resto == 10 || resto == 11){
            resto = 0;
        }
        if(resto != Integer.parseInt(cpf.substring(10, 11))){
            return false;
        }
        return true;
    }


}
