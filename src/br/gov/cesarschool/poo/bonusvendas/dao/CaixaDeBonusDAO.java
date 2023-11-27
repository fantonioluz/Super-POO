package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.edu.cesarschool.next.oo.persistenciaobjetos.DAOGenerico;

public class CaixaDeBonusDAO {
    private static final String ARQUIVO = "";
    private DAOGenerico dao;

    public CaixaDeBonusDAO(){
        this.dao = new DAOGenerico(CaixaDeBonus.class);
    }

    public boolean incluir(CaixaDeBonus caixaDeBonus) {
        return dao.incluir(caixaDeBonus);
    }

    public boolean alterar(CaixaDeBonus caixaDeBonus) {
        return dao.alterar(caixaDeBonus);
    }

    public CaixaDeBonus buscar(long numero) {
        return (CaixaDeBonus)dao.buscar(numero);
    }

    public CaixaDeBonus[] buscarTodos() {
        Serializable[] rets = dao.buscarTodos(CaixaDeBonus.class);
        CaixaDeBonus[] caixaDeBonus = new CaixaDeBonus[rets.length];
        for (int i = 0; i < rets.length; i++) {
            caixaDeBonus[i] = (CaixaDeBonus) rets[i];
        }
        return caixaDeBonus;
    }
}
