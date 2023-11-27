package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;

public class LancamentoBonusDAO {
    private DAOGenerico dao;

    public LancamentoBonusDAO(){
        this.dao = new DAOGenerico(LancamentoBonus.class);
    }

    public boolean incluir(LancamentoBonus lancamentoBonus) {
            return dao.incluir(lancamentoBonus);
    }

    public boolean alterar(LancamentoBonus lancamentoBonus) {
            return dao.alterar(lancamentoBonus);
    }

    public LancamentoBonus buscar(String idLancamento) {
        return (LancamentoBonus) dao.buscar(idLancamento);
    }

    public LancamentoBonus[] buscarTodos() {
        Serializable[] rets = dao.buscarTodos();
        LancamentoBonus[] lancamentoBonus = new LancamentoBonus[rets.length];
        for (int i = 0; i < rets.length; i++) {
            lancamentoBonus[i] = (LancamentoBonus) rets[i];
        }
        return lancamentoBonus;
    }
}
