package Padrao.hamburgueria;

public class SemDesconto extends Desconto {

    @Override
    public double calcular(double valor) {
        return valor;
    }
}
