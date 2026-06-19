package Padrao.hamburgueria;

class SaiuParaEntrega implements EstadoPedido {
    @Override
    public String getEstado() {
        return "Saiu para Entrega";
    }
}