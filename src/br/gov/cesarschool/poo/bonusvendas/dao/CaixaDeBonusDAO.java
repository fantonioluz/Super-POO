package br.gov.cesarschool.poo.bonusvendas.dao;
import java.io.Serializable;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;


public class CaixaDeBonusDAO {
    private static final String ARQUIVO = "";
    private CadastroObjetos cadastro = new CadastroObjetos(CaixaDeBonus.class);

    public boolean incluir(CaixaDeBonus caixaDeBonus) {
        CaixaDeBonus caixaDeBonusExistente = buscar(caixaDeBonus.getNumero());
        if (caixaDeBonusExistente != null) {
            return false;
        }
        else{
            cadastro.incluir(caixaDeBonus, ARQUIVO + caixaDeBonus.getNumero());
            return true;
        }
    }

    public boolean alterar(CaixaDeBonus caixaDeBonus) {
        if (caixaDeBonus == null) {
            return false;
        }
        else{
            cadastro.alterar(caixaDeBonus, ARQUIVO + caixaDeBonus.getNumero());
            return true;
        }
    }

    public boolean excluir(CaixaDeBonus caixaDeBonus) {
        if (caixaDeBonus == null) {
            return false;
        }
        else{
            cadastro.excluir(ARQUIVO + caixaDeBonus.getNumero());
            return true;
        }
    }

    public CaixaDeBonus buscar(long numero) {
        return (CaixaDeBonus) cadastro.buscar(ARQUIVO + numero);
    }
}
