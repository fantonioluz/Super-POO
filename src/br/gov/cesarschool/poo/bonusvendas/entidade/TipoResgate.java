package br.gov.cesarschool.poo.bonusvendas.entidade;

public enum TipoResgate {
    SERVICO(1, "Servico"),
    PRODUTO(2, "Produto"),
    CASH(3, "Cash");

    private final int codigo;
    private final String descricao;

    TipoResgate(int codigo, String descricao) {
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
