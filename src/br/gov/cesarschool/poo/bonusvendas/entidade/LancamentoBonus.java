package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;

public class LancamentoBonus extends Registro {
	private long numeroCaixaDeBonus;
	private double valor; 
	private LocalDateTime dataHoraLancamento;
	public LancamentoBonus(long numeroCaixaDeBonus, double valor, LocalDateTime dataHoraLancamento) {
		super();
		this.numeroCaixaDeBonus = numeroCaixaDeBonus;
		this.valor = valor;
		this.dataHoraLancamento = dataHoraLancamento;
	}
	public long getNumeroCaixaDeBonus() {
		return numeroCaixaDeBonus;
	}
	public double getValor() {
		return valor;
	}
	public LocalDateTime getDataHoraLancamento() {
		return dataHoraLancamento;
	}
	@Override
	public String getIdUnico() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		return this.getNumeroCaixaDeBonus() + this.getDataHoraLancamento().format(format);
	}
}
