package Padrao.hamburgueria;

public class DescontoCupom extends Desconto {

    @Override
    public double calcular(double valor) {

        if (valor >= 50) {
            return valor * 0.9;
        }

        return proximo.calcular(valor);
    }
}