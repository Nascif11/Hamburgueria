package Padrao.hamburgueria;

public class PreparacaoWrap extends Preparacao {

    @Override
    protected String abrirBase() {
        return "Massa de wrap";
    }

    @Override
    protected String adicionarRecheio() {
        return "Frango";
    }

    @Override
    protected String finalizar() {
        return "Wrap pronto";
    }
}
