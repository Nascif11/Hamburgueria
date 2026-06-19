package Padrao.hamburgueria;

class Confirmado implements EstadoPedido {
    @Override
    public String getEstado() {
        return "Confirmado";
    }
}
