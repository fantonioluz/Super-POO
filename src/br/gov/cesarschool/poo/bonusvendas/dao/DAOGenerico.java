package br.gov.cesarschool.poo.bonusvendas.dao;
import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;

public class DAOGenerico {
	CadastroObjetos cadastro;

	public DAOGenerico(Class<?> tipo) {
	
		this.cadastro = new CadastroObjetos(tipo);
	}
	
	public boolean incluir (Registro reg) {
		Registro busca = buscar(reg.getIdUnico());
		if(busca != null) {
			return false;
		}
		cadastro.incluir(reg, reg.getIdUnico());
		return  true;
	}
	
	public boolean alterar( Registro reg) {
		Registro busca = buscar(reg.getIdUnico());
		if(busca == null) {
			return false;
		}
		cadastro.alterar(reg, reg.getIdUnico());
		return true;
	}
	
	public Registro buscar(String id) {
		return (Registro)cadastro.buscar(id);
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
