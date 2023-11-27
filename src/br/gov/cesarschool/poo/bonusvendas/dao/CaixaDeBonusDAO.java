package br.gov.cesarschool.poo.bonusvendas.dao;

import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.edu.cesarschool.next.oo.persistenciaobjetos.DAOGenerico;

public class CaixaDeBonusDAO {
    private static final String ARQUIVO = "";
    private DAOGenerico<CaixaDeBonus> dao;

    public CaixaDeBonusDAO(){
        this.dao = new DAOGenerico<>(CaixaDeBonus.class);
    }

    public boolean incluir(CaixaDeBonus caixaDeBonus) {
        CaixaDeBonus caixaDeBonusExistente = buscar(caixaDeBonus.getNumero());
        if (caixaDeBonusExistente != null) {
            return false;
        }
        else{
            dao.incluir(caixaDeBonus, ARQUIVO + String.valueOf(caixaDeBonus.getNumero()));
            return true;
        }
    }

    public boolean alterar(CaixaDeBonus caixaDeBonus) {
        CaixaDeBonus caixaDeBonusExistente = buscar(caixaDeBonus.getNumero());
        if (caixaDeBonusExistente == null) {
            return false;
        }
        else{
            dao.alterar(caixaDeBonus, ARQUIVO + String.valueOf(caixaDeBonus.getNumero()));
            return true;
        }
    }

    public boolean excluir(CaixaDeBonus caixaDeBonus) {
        CaixaDeBonus caixaDeBonusExistente = buscar(caixaDeBonus.getNumero());
        if (caixaDeBonusExistente == null) {
            return false;
        }
        else{
            dao.excluir(ARQUIVO + String.valueOf(caixaDeBonus.getNumero()));
            return true;
        }
    }

    public CaixaDeBonus buscar(long numero) {
        return dao.buscar(ARQUIVO + String.valueOf(numero));
    }

    public CaixaDeBonus[] buscarTodos() {
        return dao.buscarTodos();
    }
}
