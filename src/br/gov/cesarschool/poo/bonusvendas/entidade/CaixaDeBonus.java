package br.gov.cesarschool.poo.bonusvendas.entidade;


public class CaixaDeBonus {
    private long numero;
    private double saldo;
    private java.time.LocalDate dataHoraAtualizacao;

    public CaixaDeBonus(long numero) {
        this.numero = numero;
    }

    public long getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public java.time.LocalDate getDataHoraAtualizacao() {
        return dataHoraAtualizacao;
    }
    
    void creditar(double valor) {
        saldo += valor;
        dataHoraAtualizacao = java.time.LocalDate.now();
    }

    void debitar(double valor) {
        saldo -= valor;
        dataHoraAtualizacao = java.time.LocalDate.now();
    }

}
