package Padrao.hamburgueria;

public class HamburguerFactory extends LancheFactory {

    @Override
    public Lanche criarLanche() {

        return new Hamburguer(
                new FabricaClassica(),
                new NaChapa()
        );
    }
}
