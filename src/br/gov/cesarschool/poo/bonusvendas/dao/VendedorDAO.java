package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;

public class VendedorDAO {
    private DAOGenerico dao;

    public VendedorDAO(){
        this.dao = new DAOGenerico(Vendedor.class);
    }

    public boolean incluir(Vendedor vendedor) {
           return dao.incluir(vendedor);
    }

    public boolean alterar(Vendedor vendedor) {  
    	return dao.alterar(vendedor);
    }


    public Vendedor buscar(String cpf) {
        return (Vendedor)dao.buscar(cpf);
    }

    public Vendedor[] buscarTodos() {
        Serializable[] rets = dao.buscarTodos();
        Vendedor[] vendedor = new Vendedor[rets.length];
        for(int i = 0; i<rets.length; i++) {
            vendedor[i] = (Vendedor)rets[i];
        }
        return vendedor;
    }
}
