package br.gov.cesarschool.poo.bonusvendas.dao;

import java.time.format.DateTimeFormatter;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;
import br.edu.cesarschool.next.oo.persistenciaobjetos.DAOGenerico;

public class LancamentoBonusDAO {
    private static final String ARQUIVO = "";
    private DAOGenerico<LancamentoBonus> dao;

    public LancamentoBonusDAO() {
        this.dao = new DAOGenerico<>(LancamentoBonus.class);
    }

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
            dao.incluir(lancamentoBonus, ARQUIVO + buscaLancamento);
            return true;
        }
    }

    public boolean alterar(LancamentoBonus lancamentoBonus) {
        String buscaLancamento = idLancamento(lancamentoBonus);
        LancamentoBonus buscaLancamentoObj = buscar(buscaLancamento);

        if (buscaLancamentoObj == null) {
            return false;
        } else {
            dao.excluir(ARQUIVO + buscaLancamento);
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
        return dao.buscar(ARQUIVO + idLancamento);
    }

    public LancamentoBonus[] buscarTodos() {
        return dao.buscarTodos();
    }
}
