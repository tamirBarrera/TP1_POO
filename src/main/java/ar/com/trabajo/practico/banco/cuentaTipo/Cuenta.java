package ar.com.trabajo.practico.banco.cuentaTipo;

import ar.com.trabajo.practico.banco.clienteTipo.Cliente;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter(AccessLevel.PROTECTED)
@ToString

public abstract class Cuenta {
    private final int numeroCuenta; // numero de cuenta, no se puede modificar
    private final Cliente clienteAsociado; // polimorfismo para referenciar a la clase abstracta y obtener los datos del
    // // cliente (atributos de la clase Cliente) y obtener los datos del cliente                           
    // // (Nombre, apellido y DNI)
    private double saldoPesos; // saldo en pesos de la cuenta

    public Cuenta(int numeroCuenta, Cliente clienteAsociado) {
        this.numeroCuenta = numeroCuenta;
        this.clienteAsociado = clienteAsociado; // cliente asociado a la cuenta
    }

    public abstract void depositarEfectivo(double monto);

    public abstract void extraerEfectivo(double monto);
}
