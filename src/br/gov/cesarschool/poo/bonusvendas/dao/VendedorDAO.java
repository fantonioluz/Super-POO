package br.gov.cesarschool.poo.bonusvendas.dao;

import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.edu.cesarschool.next.oo.persistenciaobjetos.DAOGenerico;

public class VendedorDAO {
    private static final String ARQUIVO = "";
    private DAOGenerico<Vendedor> dao;

    public VendedorDAO() {
        this.dao = new DAOGenerico<>(Vendedor.class);
    }

    public boolean incluir(Vendedor vendedor) {
        Vendedor buscaVendedor = buscar(vendedor.getCpf());
        if(buscaVendedor != null){
            return false;
        } else {
            dao.incluir(vendedor, ARQUIVO + vendedor.getCpf());
            return true;
        }
    }

    public boolean alterar(Vendedor vendedor) {
        Vendedor buscaVendedor = buscar(vendedor.getCpf());
        if(buscaVendedor == null){
            return false;
        } else {
            dao.alterar(vendedor, ARQUIVO + vendedor.getCpf());
            return true;
        }
    }

    public boolean excluir(Vendedor vendedor) {
        Vendedor buscaVendedor = buscar(vendedor.getCpf());
        if(buscaVendedor == null){
            return false;
        } else {
            dao.excluir(ARQUIVO + vendedor.getCpf());
            return true;
        }
    }

    public Vendedor buscar(String cpf) {
        return dao.buscar(ARQUIVO + cpf);
    }

    public Vendedor[] buscarTodos() {
        return dao.buscarTodos();
    }
}
