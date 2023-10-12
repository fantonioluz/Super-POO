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
        
        

        if(vendedor.getCpf() == null || vendedor.getCpf().isEmpty()){
            return "CPF nao informado";
        }

        else if(ValidadorCPF.ehCpfValido(vendedor.getCpf()) == false){
            if(vendedor.getCpf() == null || vendedor.getCpf().isEmpty()){
                return "CPF nao informado";
            }else {
            	return "CPF invalido";
            }
            
        }

        if(vendedor.getnomeCompleto() == null || vendedor.getnomeCompleto().isEmpty()){
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

    public String alterar(Vendedor vendedor){
        String retorno = validar(vendedor);
        if(retorno == null) { 
            repositoriovendedor.alterar(vendedor);

            String resultado = null;

            return resultado;
        } else {
            
            return "Vendedor inexistente";
        }
    }

}
