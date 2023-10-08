package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;

import java.util.List;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class VendedorDAO {
    private CadastroObjetos cadastro = new CadastroObjetos(Vendedor.class);

    public boolean incluir(Vendedor vendedor) {
        Vendedor buscaVendedor = buscar(vendedor.getcpf());
        if(buscaVendedor != null){
            return false;
        } else {
            cadastro.incluir(vendedor, vendedor.getcpf());
            return true;
        }
    }

    public boolean alterar(Vendedor vendedor) {
        Vendedor buscaVendedor = buscar(vendedor.getcpf());
        if(buscaVendedor == null){
            return false;
        } else {
            cadastro.alterar(vendedor, vendedor.getcpf());
            return true;
        }
    }

    public boolean excluir(Vendedor vendedor) {
        Vendedor buscaVendedor = buscar(vendedor.getcpf());
        if(buscaVendedor == null){
            return false;
        } else {
            cadastro.excluir(vendedor.getcpf());
            return true;
        }
    }

    public Vendedor buscar(String cpf) {
        return (Vendedor)cadastro.buscar(cpf);
    }

    public Vendedor[] buscarTodos() {
        Serializable[] rets = cadastro.buscarTodos(Vendedor.class);
        Vendedor[] vendedor = new Vendedor[rets.length];
        for(int i = 0; i<rets.length; i++) {
            vendedor[i] = (Vendedor)rets[i];
        }
        return vendedor;
    }
}
