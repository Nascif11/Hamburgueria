package Padrao.hamburgueria;

public class Wrap extends Lanche {

    public Wrap(FabricaIngredientes fabrica,
                ModoCozimento modo) {

        super(fabrica, modo);
    }

    @Override
    public String descricao() {
        return "Wrap";
    }

    @Override
    public double preco() {
        return 18.0;
    }
}
