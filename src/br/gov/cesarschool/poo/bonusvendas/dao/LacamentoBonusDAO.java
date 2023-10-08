package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusCredito;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusDebito;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class LacamentoBonusDAO {
    private static final String ARQUIVO = "";
    private CadastroObjetos cadastro = new CadastroObjetos(LancamentoBonus.class);

    public String idLancamento(LancamentoBonus lancamentoBonus){
        String dataString = lancamentoBonus.getDataHoraLancamento().format(DateTimeFormatter.ofPattern("yyyymmddhhmmss"));
        String idLancamentoString = String.valueOf(lancamentoBonus.getNumeroCaixaDeBunus()) + dataString;
        return idLancamentoString;
    }

    

    public boolean incluir(LancamentoBonus lancamentoBonus) { 
        LancamentoBonus buscaLancamento = buscar(lancamentoBonus);
        if(buscaLancamento!= null){
            return false;
        } else {
            cadastro.incluir(lancamentoBonus, ARQUIVO + buscaLancamento);
            return true;
        }
    }

    public boolean alterar(LancamentoBonus lancamentoBonus) {
        lancamentoBonus buscaLancamento = buscar(lancamentoBonus);
        if(buscaLancamento == null){
            return false;
        } else {
            cadastro.alterar(lancamentoBonus, buscaLancamento);
            return true;
        }
    }

    public boolean excluir(LancamentoBonus lancamentoBonus) {
        String buscaLancamento = buscar(lancamentoBonus);
        if(buscaLancamento == null){
            return false;
        } else {
            cadastro.excluir(buscaLancamento);
            return true;
        }
    }

    public LancamentoBonus buscar(LancamentoBonus lancamentoBonus) {
        String codigo = idLancamento(lancamentoBonus);
        
        return (LancamentoBonus)cadastro.buscar(codigo);
    }

    public LancamentoBonus [] buscarTodos() {
        Serializable[] rets = cadastro.buscarTodos(LancamentoBonus.class);
        LancamentoBonus[] lancamentoBonus = new LancamentoBonus[rets.length];
        for(int i = 0; i<rets.length; i++) {
            lancamentoBonus[i] = (LancamentoBonus)rets[i];
        }
        return lancamentoBonus;
    }
}

