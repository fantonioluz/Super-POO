package br.gov.cesarschool.poo.bonusvendas.negociov2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.gov.cesarschool.poo.bonusvendas.negocio.ComparadorCaixaDeBonusSaldoDec;
import br.gov.cesarschool.poo.bonusvendas.negocio.ComparadorLancamentoBonusDHDec;
import br.gov.cesarschool.poo.bonusvendas.daov2.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.daov2.LancamentoBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusCredito;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusDebito;
import br.gov.cesarschool.poo.bonusvendas.entidade.TipoResgate;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoJaExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoNaoExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoValidacao;
import br.gov.cesarschool.poo.bonusvendas.util.Ordenadora;

public class AcumuloResgateMediator {
	private static final String CAIXA_DE_BONUS_INEXISTENTE = "Caixa de bonus inexistente";
	private static final String VALOR_MENOR_OU_IGUAL_A_ZERO = "Valor menor ou igual a zero";
	private static AcumuloResgateMediator instancia;
	public static AcumuloResgateMediator getInstancia() {
		if (instancia == null) {
			instancia = new AcumuloResgateMediator();
		}
		return instancia;
	}
	private CaixaDeBonusDAO repositorioCaixaDeBonus;
	private LancamentoBonusDAO repositorioLancamento;
	private AcumuloResgateMediator() {
		repositorioCaixaDeBonus = new CaixaDeBonusDAO();
		repositorioLancamento = new LancamentoBonusDAO();
	}
	
	
	public CaixaDeBonus[] listaCaixaDeBonusPorSaldoMaior(double saldoInicial) {
		CaixaDeBonus[] todasAsCaixas = repositorioCaixaDeBonus.buscarTodos();
		CaixaDeBonus[] caixasFiltradas = Arrays.stream(todasAsCaixas).filter(caixa -> caixa.getSaldo() >= saldoInicial).toArray(CaixaDeBonus[]::new);
		Ordenadora.ordenar(caixasFiltradas, ComparadorCaixaDeBonusSaldoDec.getInstance());
		return caixasFiltradas;
	}
	
    public LancamentoBonus[] listaLancamentosPorFaixaData(LocalDate d1, LocalDate d2) {
        LancamentoBonus[] todosOsLancamentos = repositorioLancamento.buscarTodos();

        List<LancamentoBonus> lancamentosFiltrados = new ArrayList<>();

        for (LancamentoBonus lancamento : todosOsLancamentos) {
            LocalDate dataHoraLancamento = lancamento.getDataHoraLancamento().toLocalDate();
            if (!dataHoraLancamento.isBefore(d1) && !dataHoraLancamento.isAfter(d2)) {
                lancamentosFiltrados.add(lancamento);
            }
        }

    
        Collections.sort(lancamentosFiltrados, ComparadorLancamentoBonusDHDec.getInstance());

        return lancamentosFiltrados.toArray(new LancamentoBonus[0]);
    }
	
	
	
	public long gerarCaixaDeBonus(Vendedor vendedor) throws ExcecaoObjetoJaExistente {
		LocalDate dataAtual = LocalDate.now();
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		long numero = Long.parseLong(vendedor.getCpf().substring(0, 9) + 
				dataAtual.format(customFormatter));
		CaixaDeBonus caixa = new CaixaDeBonus(numero);
		repositorioCaixaDeBonus.incluir(caixa);
		return numero;
				 
	}
	 public void acumularBonus(long numeroCaixaDeBonus, double valor) throws ExcecaoObjetoNaoExistente, ExcecaoValidacao {
        if (valor <= 0) {
            throw new ExcecaoValidacao("Valor menor ou igual a zero");
        }

        CaixaDeBonus caixa = repositorioCaixaDeBonus.buscar(numeroCaixaDeBonus);

        if (caixa == null) {
            throw new ExcecaoObjetoNaoExistente("Caixa de bonus inexistente");
        }

        caixa.creditar(valor);
        repositorioCaixaDeBonus.alterar(caixa);

        try {
            LancamentoBonusCredito lancamento = new LancamentoBonusCredito(numeroCaixaDeBonus, valor, LocalDateTime.now());
            repositorioLancamento.incluir(lancamento);
        } catch (ExcecaoObjetoJaExistente e) {
            throw new ExcecaoValidacao("Inconsistencia no cadastro de lancamento");
        }
    }
	 public void resgatar(long numeroCaixaDeBonus, double valor, TipoResgate tipoResgate) throws ExcecaoObjetoNaoExistente, ExcecaoValidacao {
        if (valor <= 0) {
            throw new ExcecaoValidacao("Valor menor ou igual a zero");
        }

        CaixaDeBonus caixa = repositorioCaixaDeBonus.buscar(numeroCaixaDeBonus);

        if (caixa == null) {
            throw new ExcecaoObjetoNaoExistente("Caixa de bonus inexistente");
        }

        if (caixa.getSaldo() < valor) {
            throw new ExcecaoValidacao("Saldo insuficiente");
        }

        caixa.debitar(valor);
        repositorioCaixaDeBonus.alterar(caixa);

        try {
            LancamentoBonusDebito lancamento = new LancamentoBonusDebito(numeroCaixaDeBonus, valor, LocalDateTime.now(), tipoResgate);
            repositorioLancamento.incluir(lancamento);
        } catch (ExcecaoObjetoJaExistente e) {
            throw new ExcecaoValidacao("Inconsistencia no cadastro de lancamento");
        }
    }
}
