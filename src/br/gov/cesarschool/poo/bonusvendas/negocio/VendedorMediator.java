package br.gov.cesarschool.poo.bonusvendas.negocio;
import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;

public class VendedorMediator {
    private static VendedorMediator instance;
    VendedorDAO repositoriovendedor;
    AcumuloResgateMediator caixaDeBonusMediator;

    public static VendedorMediator getInstance() {
        if (instance == null) {
            instance = new VendedorMediator();
        }
        return instance;
    }

}
