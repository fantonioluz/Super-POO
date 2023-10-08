package br.gov.cesarschool.poo.bonusvendas.entidade.geral;

public enum Sexo {
    FEMININO(1, "Feminino"),
    MASCULINO(2, "Masculino");

    private final int codigo;
    private final String descricao;

    Sexo(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
