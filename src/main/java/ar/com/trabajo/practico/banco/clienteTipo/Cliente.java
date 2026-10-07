package ar.com.trabajo.practico.banco.clienteTipo;

import lombok.Getter;

import lombok.ToString;

@Getter
@ToString

public abstract class Cliente {
    private final int numeroCliente;

    public Cliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }
}
