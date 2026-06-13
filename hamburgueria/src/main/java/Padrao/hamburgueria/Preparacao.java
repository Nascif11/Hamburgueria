package Padrao.hamburgueria;

public abstract class Preparacao {

    public final String preparar() {
        return abrirBase()
                + " | "
                + adicionarRecheio()
                + " | "
                + finalizar();
    }

    protected abstract String abrirBase();
    protected abstract String adicionarRecheio();
    protected abstract String finalizar();
}