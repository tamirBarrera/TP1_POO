package ar.com.trabajo.practico.banco.cuentatipo;

import ar.com.trabajo.practico.banco.clientetipo.Cliente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public abstract class Cuenta { // cliente (atributos de la clase Cliente)
    private final int numeroCuenta; // numero de cuenta, no se puede modificar
    private final Cliente clienteAsociado; // el atributo clienteAsociado es una referencia a un objeto de la clase
                                        // Cliente, es final porque no se puede cambiar el cliente asociado a la cuenta
    private double saldoPesos; // saldo en pesos de la cuenta inicializa en 0

    public Cuenta(int numeroCuenta, Cliente clienteAsociado) {
        this.numeroCuenta = numeroCuenta;
        this.clienteAsociado = clienteAsociado; 
    }

    public void depositarEfectivo(double monto) {
        if (monto <= 0) {
            System.out.println("El monto a depositar debe ser positivo.");
        } else {
            this.saldoPesos += monto;
            System.out.printf("Depósito realizado de manera exitosa!!!. Nuevo saldo: %.2f", saldoPesos);
        }
    }

    public void extraerEfectivo(double monto) {
        if (monto <= 0) {
            System.out.println("El monto a extraer debe ser positivo.");
        } else if (monto > this.saldoPesos) {
            System.out.println("El monto a extraer es mayor al saldo disponible.");
        } else {
            this.saldoPesos -= monto;

            System.out.printf("Extracción realizada de manera exitosa!!!. Nuevo saldo: %.2f", saldoPesos);
        }
    }

}
