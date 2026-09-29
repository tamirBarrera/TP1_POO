package ar.com.trabajo.practico.banco.relaciones;

import ar.com.trabajo.practico.banco.herencia.Cliente;
import ar.com.trabajo.practico.banco.herencia.Cuenta;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class CajaAhorro extends Cuenta {
    private double saldoPesos;
    private double tasaInteres;

    public CajaAhorro(int numeroCuenta, double saldoPesos, double tasaInteres, Cliente clienteAsociado) {
        super(numeroCuenta, saldoPesos, clienteAsociado);
        this.saldoPesos = saldoPesos;
        this.tasaInteres = tasaInteres;
    }

    public void depositarEfectivo(double saldoPesos) {
        depositarEfectivo(saldoPesos);
        System.out.printf("Depósito realizado de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
    }

    public void extraerEfectivo(double saldoPesos) {
        extraerEfectivo(saldoPesos);
        System.out.printf("Extracción realizada de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
    }

    public void cobrarInteres() {
        depositarEfectivo(getSaldoPesos() * 0.100);
        System.out.printf("Intereses cobrados de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
    }
}
