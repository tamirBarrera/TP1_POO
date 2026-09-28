package ar.com.trabajo.practico.banco.herencia;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public abstract class Cuenta {
    private int numeroCuenta;
    private double saldo;

    public Cuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

    public void depositarEfectivo(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.printf("Depósito de %.2f realizado exitosamente.", monto);
        }
    }

    public void extraerEfectivo(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            System.out.printf("Extracción de %.2f realizada exitosamente.", monto);
        } else {
            System.out.println("Saldo insuficiente para realizar la extracción.");
        }
    }

}
