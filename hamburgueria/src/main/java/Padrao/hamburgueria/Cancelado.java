package Padrao.hamburgueria;

class Cancelado implements EstadoPedido {
    @Override
    public String getEstado() {
        return "Cancelado";
    }
}
