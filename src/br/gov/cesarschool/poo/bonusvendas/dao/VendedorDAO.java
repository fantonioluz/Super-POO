package br.gov.cesarschool.poo.bonusvendas.dao;

import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.edu.cesarschool.next.oo.persistenciaobjetos.DAOGenerico;

public class VendedorDAO {
    private static final String ARQUIVO = "";
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
    	
    }
}
