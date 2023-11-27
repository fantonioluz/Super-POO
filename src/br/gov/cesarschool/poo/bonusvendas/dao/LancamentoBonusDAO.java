package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;
import br.edu.cesarschool.next.oo.persistenciaobjetos.DAOGenerico;

public class LancamentoBonusDAO {
    private static final String ARQUIVO = "";
    private DAOGenerico dao;

    public LancamentoBonusDAO(){
        this.dao = new DAOGenerico(LancamentoBonus.class);
    }

    public String idLancamento(LancamentoBonus lancamentoBonus) {
        String dataString = lancamentoBonus.getDataHoraLancamento().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String idLancamentoString = String.valueOf(lancamentoBonus.getNumeroCaixaDeBonus()) + dataString;
        return idLancamentoString;
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
        Serializable[] rets = dao.buscarTodos(LancamentoBonus.class);
        LancamentoBonus[] lancamentoBonus = new LancamentoBonus[rets.length];
        for (int i = 0; i < rets.length; i++) {
            lancamentoBonus[i] = (LancamentoBonus) rets[i];
        }
        return lancamentoBonus;
    }
}
