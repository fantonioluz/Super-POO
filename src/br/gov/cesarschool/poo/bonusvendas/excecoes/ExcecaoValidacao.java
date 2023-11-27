package br.gov.cesarschool.poo.bonusvendas.excecoes;

import java.util.ArrayList;
import java.util.List;

public class ExcecaoValidacao extends Exception {


    private List<ErroValidacao> errosValidacao;


    public ExcecaoValidacao(String mensagem) {
        super(mensagem);
        this.errosValidacao = new ArrayList<>();
    }


    public ExcecaoValidacao(List<ErroValidacao> errosValidacao) {
        super("Erros de validação encontrados");
        if (errosValidacao != null) {
            this.errosValidacao = new ArrayList<>(errosValidacao);
        } else {
            this.errosValidacao = new ArrayList<>();
        }
    }


    public List<ErroValidacao> getErrosValidacao() {
        return errosValidacao;
    }
}
