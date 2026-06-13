package Padrao.hamburgueria;

public abstract class Desconto {

    protected Desconto proximo;

    public void setProximo(Desconto proximo) {
        this.proximo = proximo;
    }

    public abstract double calcular(double valor);
}