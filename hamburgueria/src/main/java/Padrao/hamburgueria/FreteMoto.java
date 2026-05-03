package Padrao.hamburgueria;

public class FreteMoto implements Frete {
    public double calcular(double valor) {
        return valor * 0.1;
    }
}