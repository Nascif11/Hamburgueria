package Padrao.hamburgueria;

public class ExtraQueijo extends LancheDecorator {

    public ExtraQueijo(Lanche lanche) {
        super(lanche);
    }

    public String descricao() {
        return lanche.descricao() + " + Queijo";
    }

    public double preco() {
        return lanche.preco() + 5;
    }
}