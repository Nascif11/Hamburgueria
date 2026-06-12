package Padrao.hamburgueria;

public class WrapFactory extends LancheFactory {

    @Override
    public Lanche criarLanche() {

        return new Wrap(
                new FabricaGourmet(),
                new NoForno()
        );
    }
}
