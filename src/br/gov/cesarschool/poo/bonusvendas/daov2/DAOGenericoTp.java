package br.gov.cesarschool.poo.bonusvendas.daov2;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;

import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoJaExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoNaoExistente;

public class DAOGenericoTp<T extends Registro> {
	CadastroObjetos cadastro;
	
	private String nomeEntidade;
	
	public DAOGenericoTp(Class<T> tipo, String nomeEntidade) {
		this.cadastro = new CadastroObjetos(tipo);
		this.nomeEntidade = nomeEntidade;
	}
	
    public void incluir(T reg) throws ExcecaoObjetoJaExistente{
      
		try {
			buscar(reg.getIdUnico());
			throw new ExcecaoObjetoJaExistente(nomeEntidade + " ja existente");
		} catch (ExcecaoObjetoNaoExistente e) {
			cadastro.incluir(reg, reg.getIdUnico());
		}
    }

    public void alterar(T reg) throws ExcecaoObjetoNaoExistente {
		try {
			buscar(reg.getIdUnico());
			throw new ExcecaoObjetoNaoExistente(nomeEntidade + " ja existente");
		} catch (ExcecaoObjetoNaoExistente e) {
			cadastro.alterar(reg, reg.getIdUnico());
		}
        
    }

    public  T buscar(String id) throws ExcecaoObjetoNaoExistente {
    	T objeto = (T) cadastro.buscar(id);
		return objeto;
		
    }
	
	public T[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(Registro.class);
		T[] regs = (T[]) new Registro[rets.length];
		for(int i=0; i<rets.length; i++) {
			regs[i] = (T)rets[i];
		}
		return regs;
	}
	
}