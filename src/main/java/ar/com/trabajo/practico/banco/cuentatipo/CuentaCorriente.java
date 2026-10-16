package ar.com.trabajo.practico.banco.cuentatipo;

import java.time.LocalDate;

import ar.com.trabajo.practico.banco.Cheque;
import ar.com.trabajo.practico.banco.clientetipo.Cliente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class CuentaCorriente extends Cuenta {
    private double descubierto;

    public CuentaCorriente(int numeroCuenta, Cliente clienteAsociado, double descubierto) {
        super(numeroCuenta, clienteAsociado);
        this.descubierto = descubierto;
    }

    // Sobrescritura del metodo extraerEfectivo de la clase Cuenta
    public void extraerEfectivo(double monto) {
        if (monto <= 0) {
            System.out.println("El monto a extraer debe ser positivo.");
        } else if (getSaldoPesos() + this.descubierto < monto) {
            System.out.println("El monto a extraer es mayor al saldo disponible.");
        } else {
            setSaldoPesos(getSaldoPesos() - monto);
            System.out.printf("Extracción realizada de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
        }
    }

    public void depositarCheque(Cheque cheque) {
        if (cheque.getMonto() > 0) {
            depositarEfectivo(cheque.getMonto());
            System.out.printf("Depósito de %.2f realizado exitosamente. Saldo actual: %.2f%n", cheque.getMonto(),
                    getSaldoPesos(), "\n" + "En la fecha " + LocalDate.now());
        }
    }

}
