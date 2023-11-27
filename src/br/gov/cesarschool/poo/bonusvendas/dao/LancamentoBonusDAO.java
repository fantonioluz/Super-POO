package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class LancamentoBonusDAO {
    private static final String ARQUIVO = "";
    private CadastroObjetos cadastro = new CadastroObjetos(LancamentoBonus.class);

    public String idLancamento(LancamentoBonus lancamentoBonus) {
        String dataString = lancamentoBonus.getDataHoraLancamento().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String idLancamentoString = String.valueOf(lancamentoBonus.getNumeroCaixaDeBonus()) + dataString;
        return idLancamentoString;
    }

    public boolean incluir(LancamentoBonus lancamentoBonus) {
        String buscaLancamento = idLancamento(lancamentoBonus);
        LancamentoBonus buscaLancamentoObj = buscar(buscaLancamento);

        if (buscaLancamentoObj != null) {
            return false;
        } else {
            cadastro.incluir(lancamentoBonus, ARQUIVO + buscaLancamento);
            return true;
        }
    }

    public boolean alterar(LancamentoBonus lancamentoBonus) {
        String buscaLancamento = idLancamento(lancamentoBonus);
        LancamentoBonus buscaLancamentoObj = buscar(buscaLancamento);

        if (buscaLancamentoObj == null) {
            return false;
        } else {
            cadastro.alterar(lancamentoBonus, ARQUIVO + buscaLancamento);
            return true;
        }
    }

    public boolean excluir(LancamentoBonus lancamentoBonus) {
        String buscaLancamento = idLancamento(lancamentoBonus);
        LancamentoBonus buscaLancamentoObj = buscar(buscaLancamento);

        if (buscaLancamentoObj == null) {
            return false;
        } else {
            cadastro.excluir(ARQUIVO + buscaLancamento);
            return true;
        }
    }

    public LancamentoBonus buscar(String idLancamento) {
        return (LancamentoBonus) cadastro.buscar(ARQUIVO + idLancamento);
    }

    public LancamentoBonus[] buscarTodos() {
        Serializable[] rets = cadastro.buscarTodos(LancamentoBonus.class);
        LancamentoBonus[] lancamentoBonus = new LancamentoBonus[rets.length];
        for (int i = 0; i < rets.length; i++) {
            lancamentoBonus[i] = (LancamentoBonus) rets[i];
        }
        return lancamentoBonus;
    }
}
