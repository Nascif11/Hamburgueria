package Padrao.hamburgueria;

public abstract class ItemCardapio {

    protected String nome;

    public ItemCardapio(String nome) {
        this.nome = nome;
    }

    public abstract double getPreco();

    public String getNome() {
        return nome;
    }
}
