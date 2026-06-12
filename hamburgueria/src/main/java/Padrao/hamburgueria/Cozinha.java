package Padrao.hamburgueria;

public class Cozinha {

    public void executar(
            PedidoCommand command) {

        command.executar();
    }
}
