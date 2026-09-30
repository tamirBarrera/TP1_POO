package ar.com.trabajo.practico.banco.herencia;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public abstract class Cuenta {
    private final int numeroCuenta; // numero de cuenta, no se puede modificar
    private Cliente clienteAsociado; // polimorfismo para referenciar a la clase abstracta y obtener los datos del
                                     // cliente (atributos de la clase Cliente) y obtener los datos del cliente
                                     // (Nombre, apellido y DNI)
    protected double saldoPesos; // saldo en pesos de la cuenta

    public Cuenta(int numeroCuenta, double saldoPesos, Cliente clienteAsociado) {
        this.numeroCuenta = numeroCuenta;
        this.saldoPesos = 0.0;
        this.clienteAsociado = clienteAsociado; // cliente asociado a la cuenta
    }

    public abstract void depositarEfectivo(double monto);

    public abstract void extraerEfectivo(double monto);
}
