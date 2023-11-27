package br.gov.cesarschool.poo.bonusvendas.daov2;

import java.io.Serializable;

import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoJaExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoNaoExistente;

public class VendedorDAO {
    private DAOGenerico dao;

    public VendedorDAO() {
    	dao = new DAOGenerico(Vendedor.class, "Vendedor");
    }

    public void incluir(Vendedor vend) throws ExcecaoObjetoJaExistente{
    	dao.incluir(vend);
    }

    public void alterar(Vendedor vend) throws ExcecaoObjetoNaoExistente {
    	dao.alterar(vend);
    }

    public Vendedor buscar(String cpf) throws ExcecaoObjetoNaoExistente {
        return (Vendedor) dao.buscar(cpf);
    }

    public Vendedor[] buscarTodos() {
        Serializable[] rets = dao.buscarTodos();
        Vendedor[] vends = new Vendedor[rets.length];
        for (int i = 0; i < rets.length; i++) {
            vends[i] = (Vendedor) rets[i];
        }
        return vends;
    }
}