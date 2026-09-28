package ar.com.trabajo.practico.banco.herencia;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public abstract class Cliente {
    private int numeroCliente;

    public Cliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }
}
