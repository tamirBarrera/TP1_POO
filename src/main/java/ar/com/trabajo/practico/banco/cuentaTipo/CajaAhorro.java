package ar.com.trabajo.practico.banco.cuentaTipo;

import ar.com.trabajo.practico.banco.clienteTipo.Cliente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class CajaAhorro extends Cuenta {
    private double tasaInteres;

    public CajaAhorro(int numeroCuenta, Cliente clienteAsociado, double tasaInteres) {
        super(numeroCuenta, clienteAsociado);
        this.tasaInteres = tasaInteres;
    }

    public CajaAhorro(int numeroCuenta, Cliente clienteAsociado) {
        super(numeroCuenta, clienteAsociado);
    }

    public void depositarEfectivo(double montoAdepositar) {
        if (montoAdepositar <= 0) {
            System.out.println("El monto a depositar debe ser positivo.");
        } else {
            setSaldoPesos(getSaldoPesos() + montoAdepositar);
            System.out.printf("Depósito realizado de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
        }
    }

    public void extraerEfectivo(double montoAextraer) {
        if (montoAextraer <= 0) {
            System.out.println("El monto a extraer debe ser positivo y mayor al saldo disponible.");
        } else if (montoAextraer > getSaldoPesos()) {
            System.out.println("El monto a extraer es mayor al saldo disponible.");
        } else {
            setSaldoPesos(getSaldoPesos() - montoAextraer);
            System.out.printf("Extracción realizada de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
        }

    }

    public void cobrarInteres() {
        depositarEfectivo(getSaldoPesos() * tasaInteres);
        System.out.printf("Intereses cobrados de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
    }
}
