package br.gov.cesarschool.poo.bonusvendas.negocio;
import java.time.Period;

import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.negocio.AcumuloResgateMediator;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.StringUtil;
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

        int idade = Period.between(vendedor.getdataNascimento(), java.time.LocalDate.now()).getYears();

        if( idade < 18){
            return "Data de nascimento invalida";
        }

        if(vendedor.getrenda() < 0){
            return "Renda menor que zero";
        }

        if(vendedor.getendereco() == null){
            return "Endereço não informado";
        }

        
        if(StringUtil.ehNuloOuBranco(vendedor.getendereco().getLogradouro())){
            return "Logradouro nao informado";
        }

        if(vendedor.getendereco().getLogradouro().length() < 4) {
            return "Logradouro tem menos de 04 caracteres";
        }

        if(vendedor.getendereco().getNumero() < 0){
            return "Numero menor que zero";
        }
        
        if(vendedor.getendereco().getCidade() == null  || vendedor.getendereco().getCidade().isEmpty()){
            return "Cidade nao informada";
        }

        if(vendedor.getendereco().getEstado() == null  || vendedor.getendereco().getEstado().isEmpty()){
            return "Estado nao informado";
        }

        if(vendedor.getendereco().getPais() == null  || vendedor.getendereco().getPais().isEmpty()){
            return "Pais nao informado";
        }

        return null;

    }

    public Vendedor buscar(String cpf){
        return repositoriovendedor.buscar(cpf);

    }

    public ResultadoInclusaoVendedor incluir(Vendedor vendedor) {
        String retorno = validar(vendedor);
        if(retorno == null) { //null é retorno se os dados estão validos
            repositoriovendedor.incluir(vendedor);
            
            long numeroCaixaDeBonus = caixaDeBonusMediator.gerarCaixaDeBonus(vendedor);

            ResultadoInclusaoVendedor resultado = new ResultadoInclusaoVendedor(numeroCaixaDeBonus, null);

            return resultado;
        } else {
            ResultadoInclusaoVendedor resultado = new ResultadoInclusaoVendedor(0, retorno);
            return resultado;
        }
    }

}
