package ar.com.trabajo.practico.banco.herencia;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public abstract class Cuenta {
    private final int numeroCuenta; // numero de cuenta, no se puede modificar
    private Cliente clienteAsociado; // datos de la cuenta del cliente
    private double saldoPesos;  // saldo en pesos de la cuenta

    public Cuenta(int numeroCuenta, double saldoPesos, Cliente clienteAsociado) {
        this.numeroCuenta = numeroCuenta;
        this.saldoPesos = saldoPesos;
        this.clienteAsociado = clienteAsociado; // cliente asociado a la cuenta
    }

    public void depositarEfectivo(double monto) {
        if (monto > 0) {
            saldoPesos += monto;
            System.out.printf("Depósito de %.2f realizado exitosamente.", monto);
        }
    }

    public void extraerEfectivo(double monto) {
        if (monto > 0 && saldoPesos >= monto) {
            saldoPesos -= monto;
            System.out.printf("Extracción de %.2f realizada exitosamente.", monto);
        } else {
            System.out.println("Saldo insuficiente para realizar la extracción.");
        }
    }

}
