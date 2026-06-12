package Padrao.hamburgueria;

public class Produto extends ItemCardapio {

    private double preco;

    public Produto(String nome, double preco) {
        super(nome);
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return preco;
    }
}
