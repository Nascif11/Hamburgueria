package Padrao.hamburgueria;

import Padrao.hamburgueria.ModoCozimento;
import Padrao.hamburgueria.FabricaIngredientes;

public abstract class Lanche {

    protected ModoCozimento modo;
    protected FabricaIngredientes fabrica;

    public Lanche(FabricaIngredientes fabrica, ModoCozimento modo) {
        this.fabrica = fabrica;
        this.modo = modo;
    }

    public abstract String descricao();
    public abstract double preco();

    public String montar() {
        return fabrica.criarPao() + ", " +
                fabrica.criarCarne() + ", " +
                fabrica.criarMolho() + " - " +
                modo.cozinhar();
    }
}