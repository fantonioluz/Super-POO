package br.gov.cesarschool.poo.bonusvendas.daov2;

import java.io.Serializable;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoJaExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoNaoExistente;

public class CaixaDeBonusDAO {
    private static final String BRANCO = "";
    private DAOGenerico dao;

    public CaixaDeBonusDAO() {
    	dao = new DAOGenerico(CaixaDeBonus.class, "Caixa");
    }

    public void incluir(CaixaDeBonus caixaBonus) throws ExcecaoObjetoJaExistente{
    	dao.incluir(caixaBonus);
    }

    public void alterar(CaixaDeBonus caixaBonus) throws ExcecaoObjetoNaoExistente {
    	dao.alterar(caixaBonus);
    }

    public CaixaDeBonus buscar(long codigo) throws ExcecaoObjetoNaoExistente {
        return (CaixaDeBonus) dao.buscar(BRANCO + codigo);
    }

    public CaixaDeBonus[] buscarTodos() {
        Serializable[] rets = dao.buscarTodos();
        CaixaDeBonus[] caixaBonus = new CaixaDeBonus[rets.length];
        for (int i = 0; i < rets.length; i++) {
            caixaBonus[i] = (CaixaDeBonus) rets[i];
        }
        return caixaBonus;
    }
}
