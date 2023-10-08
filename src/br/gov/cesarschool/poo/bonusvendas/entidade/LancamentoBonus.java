package br.gov.cesarschool.poo.bonusvendas.entidade;

public class LancamentoBonus {
    private long numeroCaixaDeBunus;
    private double valor;
    private java.time.LocalDateTime dataHoraLancamento;


    LancamentoBonus(long numeroCaixaDeBunus, double valor, java.time.LocalDateTime dataHoraLancamento) {
        this.numeroCaixaDeBunus = numeroCaixaDeBunus;
        this.valor = valor;
        this.dataHoraLancamento = dataHoraLancamento;
    }

    public long getNumeroCaixaDeBunus() {
        return numeroCaixaDeBunus;
    }
    public void setNumeroCaixaDeBunus(long numeroCaixaDeBunus) {
        this.numeroCaixaDeBunus = numeroCaixaDeBunus;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public java.time.LocalDateTime getDataHoraLancamento() {
        return dataHoraLancamento;
    }
    public void setDataHoraLancamento(java.time.LocalDateTime dataHoraLancamento) {
        this.dataHoraLancamento = dataHoraLancamento;
    }

    



}
