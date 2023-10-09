package br.gov.cesarschool.poo.bonusvendas.negocio;
import java.time.Period;

import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.negocio.AcumuloResgateMediator;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.ValidadorCPF;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;

public class VendedorMediator {
    private static VendedorMediator instance;
    VendedorDAO repositoriovendedor;
    AcumuloResgateMediator caixaDeBonusMediator;

    VendedorMediator() {
        repositoriovendedor = new VendedorDAO();
        caixaDeBonusMediator = new AcumuloResgateMediator();
    }

    public static VendedorMediator getInstance() {
        if (instance == null) {
            instance = new VendedorMediator();
        }
        return instance;
    }

    private String validar(Vendedor vendedor){
        
        //deve validar os dados do vendedor recebidos no objeto. Se os dados estiverem válidos, deve incluir o vendedor no repositorioVendedor, gerar número da caixa de bônus através do caixaDeBonusMediator, e retornar um objeto do tipo ResultadoInclusaoVendedor com número da caixa de bônus gerado e mensagem de erro nula. Se algum dado estiver inválido, deve retornar um objeto do tipo ResultadoInclusaoVendedor com número da caixa de bônus zero e mensagem informando o que não foi validado.

        if(vendedor.getcpf() == null || vendedor.getcpf().isEmpty()){
            return "CPF não informado";
        }

        if(ValidadorCPF.ehCpfValido(vendedor.getcpf()) == false){
            return "CPF inválido";
        }

        if(vendedor.getnomeCompleto() == null || vendedor.getnomeCompleto().isEmpty()){
            return "Nome não informado";
        }

        if(vendedor.getSexo() == null){
            return "Sexo não informado";
        }


        if(vendedor.getdataNascimento() == null ){
            return "Data de nascimento não informada";
        }

        if(Period.between(vendedor.getdataNascimento(), java.time.LocalDate.now()).getYears() < 18){
            return "Data de nascimento invalida";
        }

        if(vendedor.getrenda() < 0){
            return "Renda menor que zero";
        }

        if(vendedor.getendereco() == null ){
            return "Endereço não informado";
        }

        



    }



}
