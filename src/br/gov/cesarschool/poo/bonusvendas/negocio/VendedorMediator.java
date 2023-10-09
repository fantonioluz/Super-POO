package br.gov.cesarschool.poo.bonusvendas.negocio;
import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.negocio.AcumuloResgateMediator;
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

    public ResultadoInclusaoVendedor incluir(Vendedor vendedor){

        

    }



}
