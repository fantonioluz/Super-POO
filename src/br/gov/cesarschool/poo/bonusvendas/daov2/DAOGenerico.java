package br.gov.cesarschool.poo.bonusvendas.daov2;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoJaExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoNaoExistente;

public class DAOGenerico {
	CadastroObjetos cadastro;
	
	private String nomeEntidade;
	
	public DAOGenerico(Class<?> tipo, String nomeEntidade) {
		this.cadastro = new CadastroObjetos(tipo);
		this.nomeEntidade = nomeEntidade;
	}
	
    public void incluir(Registro reg) throws ExcecaoObjetoJaExistente{
      
		try {
			buscar(reg.getIdUnico());
			throw new ExcecaoObjetoJaExistente(nomeEntidade + " ja existente");
		} catch (ExcecaoObjetoNaoExistente e) {
			cadastro.incluir(reg, reg.getIdUnico());
		}
    }

    public void alterar(Registro reg) throws ExcecaoObjetoNaoExistente {
        Registro busca = buscar(reg.getIdUnico());
        if (busca == null) {
            throw new ExcecaoObjetoNaoExistente(nomeEntidade + " nao existente");
        }
        cadastro.alterar(reg, reg.getIdUnico());
    }

    public Registro buscar(String id) throws ExcecaoObjetoNaoExistente {
        Registro objeto = (Registro) cadastro.buscar(id);
        if (objeto == null) {
            throw new ExcecaoObjetoNaoExistente(nomeEntidade + " nao existente");
        }
        return objeto;
    }
	
	public Registro[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(Registro.class);
		Registro[] regs = new Registro[rets.length];
		for(int i=0; i<rets.length; i++) {
			regs[i] = (Registro)rets[i];
		}
		return regs;
	}
	
}