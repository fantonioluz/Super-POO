package br.gov.cesarschool.poo.bonusvendas.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.gov.cesarschool.poo.bonusvendas.dao.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.dao.LancamentoBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusCredito;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;


public class AcumuloResgateMediator {
    private static AcumuloResgateMediator instance;
    private CaixaDeBonusDAO repositorioCaixaDeBonus;
    private LancamentoBonusDAO repositorioLancamento;

    private AcumuloResgateMediator() {
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
        String cpf = vendedor.getcpf();
        LocalDate dataAtual =LocalDate.now();
        String dataFormatada =  dataAtual.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        Long numeroDaCaixaDeBonus = Long.parseLong(cpf) + Long.parseLong(dataFormatada);
    
    
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

            if(flag == false){
                return "ERRO: na alteração da caixa bônus";
            }


            LancamentoBonusCredito lancamentoCredito = new LancamentoBonusCredito();


    }


}
