package Padrao.hamburgueria;

public class Hamburguer extends Lanche {

    public Hamburguer(FabricaIngredientes f, ModoCozimento m) {
        super(f, m);
    }

    public String descricao() { return "Hambúrguer"; }
    public double preco() { return 20.0; }
}