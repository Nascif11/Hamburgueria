package Padrao.hamburgueria;

public class Cozinha {

    public void executar(
            PedidoCommand command) {

        command.executar();
    }
    public void prepararHamburguer() {
        Preparacao preparo = new PreparacaoHamburguer();
    }

    public void prepararWrap() {
        Preparacao preparo = new PreparacaoWrap();

    }

}
