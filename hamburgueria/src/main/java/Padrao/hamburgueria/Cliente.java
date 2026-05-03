package Padrao.hamburgueria;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String status;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void update(Observable o, Object arg) {
        status = nome + " recebeu atualização: " + o.toString();
    }

    public String getStatus() {
        return status;
    }
}