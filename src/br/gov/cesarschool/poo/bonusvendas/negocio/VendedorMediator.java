package br.gov.cesarschool.poo.bonusvendas.negocio;
import java.time.Period;

import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.StringUtil;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.ValidadorCPF;

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
        

        if(StringUtil.ehNuloOuBranco(vendedor.getCpf())){
            return "CPF nao informado";
        }

        else if(ValidadorCPF.ehCpfValido(vendedor.getCpf()) == false){
            	return "CPF invalido";
         
        }

        if(StringUtil.ehNuloOuBranco(vendedor.getnomeCompleto())){
            return "Nome completo nao informado";
            
        }

        if(vendedor.getSexo() == null){
            return "Sexo nao informado";
        }


        if(vendedor.getdataNascimento() == null ){
            return "Data de nascimento nao informada";
        }

        int idade = Period.between(vendedor.getdataNascimento(), java.time.LocalDate.now()).getYears();

        if( idade < 18){
            return "Data de nascimento invalida";
        }

        if(vendedor.getrenda() < 0){
            return "Renda menor que zero";
        }

        if(vendedor.getendereco() == null){
            return "Endereco nao informado";
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
        
        if(StringUtil.ehNuloOuBranco(vendedor.getendereco().getCidade())){
            return "Cidade nao informada";
        }

        if(StringUtil.ehNuloOuBranco(vendedor.getendereco().getEstado())){
            return "Estado nao informado";
        }

        if(StringUtil.ehNuloOuBranco(vendedor.getendereco().getPais())){
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
            //verificar se vendor ja esta cadastrado
            Vendedor vendedorExistente = repositoriovendedor.buscar(vendedor.getCpf());
            if(vendedorExistente != null){
                ResultadoInclusaoVendedor resultado = new ResultadoInclusaoVendedor(0, "Vendedor ja existente");
                return resultado;
            }
            else{
                repositoriovendedor.incluir(vendedor);
                long numeroCaixaDeBonus = caixaDeBonusMediator.gerarCaixaDeBonus(vendedor);
                ResultadoInclusaoVendedor resultado = new ResultadoInclusaoVendedor(numeroCaixaDeBonus, null);
                return resultado;
            }

        } else {
            ResultadoInclusaoVendedor resultado = new ResultadoInclusaoVendedor(0, retorno);
            return resultado;
        }
    }

    public String alterar(Vendedor vendedor){
        String retorno = validar(vendedor);
        if(retorno == null) {
            //verificar se vendor ja esta cadastrado

            Vendedor vendedorExistente = repositoriovendedor.buscar(vendedor.getCpf());
            if(vendedorExistente == null){
                return "Vendedor inexistente";
            }
            else{
                repositoriovendedor.alterar(vendedor);
                String resultado = null;
                return resultado;
            }
            
        } else {
            
            return "Vendedor inexistente";
        }
    }

}
