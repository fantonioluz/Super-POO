package br.gov.cesarschool.poo.bonusvendas.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.gov.cesarschool.poo.bonusvendas.dao.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.dao.LancamentoBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusCredito;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusDebito;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.TipoResgate;


public class AcumuloResgateMediator {
    private static AcumuloResgateMediator instance;
    private CaixaDeBonusDAO repositorioCaixaDeBonus;
    private LancamentoBonusDAO repositorioLancamento;

    AcumuloResgateMediator() {
        repositorioCaixaDeBonus = new CaixaDeBonusDAO();
        repositorioLancamento = new LancamentoBonusDAO();
    }

    public static AcumuloResgateMediator getInstance() {
        if (instance == null){
            instance = new AcumuloResgateMediator();
        }
        return instance;
    }
   

    public long gerarCaixaDeBonus(Vendedor vendedor) {
        String cpf = vendedor.getCpf();
        cpf = cpf.substring(0, cpf.length() - 2);
        LocalDate dataAtual =LocalDate.now();
        String dataFormatada =  dataAtual.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        Long numeroDaCaixaDeBonus = Long.parseLong(cpf + dataFormatada);
    
    
    CaixaDeBonus caixaDeBonus = new CaixaDeBonus(numeroDaCaixaDeBonus);

    if(repositorioCaixaDeBonus.incluir(caixaDeBonus)){
        return numeroDaCaixaDeBonus;
    } else {
        return 0;
    }
        
 }

    public String acumularBonus(long numeroCaixaDeBonus, double valor){
        if(valor <= 0){
            return "Valor menor ou igual a zero";
        } 

        CaixaDeBonus caixaDeBonus = repositorioCaixaDeBonus.buscar(numeroCaixaDeBonus);
            
        if (caixaDeBonus == null){
            return "Caixa de bonus inexistente";
        }
        
        caixaDeBonus.creditar(valor);
        boolean flag = repositorioCaixaDeBonus.alterar(caixaDeBonus);
        
        if(!flag){
            return "ERRO: na alteração da caixa bonus";
        }
        LancamentoBonusCredito lancamentoBonusCredito = new LancamentoBonusCredito(numeroCaixaDeBonus, valor, java.time.LocalDateTime.now());
        lancamentoBonusCredito.setNumeroCaixaDeBonus(numeroCaixaDeBonus);
        lancamentoBonusCredito.setValor(valor);

        boolean flag2 = repositorioLancamento.incluir(lancamentoBonusCredito);

        if(!flag2){
            return "ERRO: falha ao incluir lançamento de bonus.";
        }

            return null;
        
    }

    public String resgatar(long numeroCaixaDeBonus, double valor, TipoResgate tipo){

        if(valor <= 0){
            return "Valor menor ou igual a zero";
        }

        CaixaDeBonus caixaDeBonus = repositorioCaixaDeBonus.buscar(numeroCaixaDeBonus);

        if (caixaDeBonus == null){
            return "Caixa de bonus inexistente";
        }

        if(caixaDeBonus.getSaldo() < valor){
            return "Saldo insuficiente";
        }
        
        caixaDeBonus.debitar(valor);
        boolean flag = repositorioCaixaDeBonus.alterar(caixaDeBonus);
        
        if(!flag){
            return "ERRO: na alteração da caixa bonus";
        }

        LancamentoBonusDebito lancamentoBonusResgate = new LancamentoBonusDebito(numeroCaixaDeBonus, valor, java.time.LocalDateTime.now(), tipo);
        lancamentoBonusResgate.setNumeroCaixaDeBonus(numeroCaixaDeBonus);
        lancamentoBonusResgate.getTipoResgate();

        boolean flag2 = repositorioLancamento.incluir(lancamentoBonusResgate);

        if(!flag2){
            return "ERRO: falha ao incluir lançamento de bonus.";
        }

            return null;

    }


}
