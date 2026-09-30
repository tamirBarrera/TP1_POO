package ar.com.trabajo.practico.banco.relaciones.tipoCuenta;

import ar.com.trabajo.practico.banco.herencia.Cliente;
import ar.com.trabajo.practico.banco.herencia.Cuenta;
import ar.com.trabajo.practico.banco.relaciones.Cheque;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class CuentaCorriente extends Cuenta {
    private double descubierto;

    public CuentaCorriente(int numeroCuenta, double saldoPesos, double descubierto, Cliente clienteAsociado) {
        super(numeroCuenta, saldoPesos, clienteAsociado);

        if (saldoPesos < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo.");
        }
        this.descubierto = 200000;
    }

    public void depositarCheque(Cheque cheque) {
        if (cheque.getMonto() > 0) {
            depositarEfectivo(cheque.getMonto());
            System.out.printf("Depósito de %.2f realizado exitosamente. Saldo actual: %.2f%n", cheque.getMonto(),
                    getSaldoPesos());
        }
    }

    public void extraerEfectivo(double montoAextraer) {
        if (montoAextraer <= 0) {
            throw new IllegalArgumentException("El monto a extraer debe ser positivo.");
        } else if (montoAextraer > getSaldoPesos() + descubierto) {
            throw new IllegalArgumentException("El monto a extraer es mayor al saldo disponible.");
        } else {
            setSaldoPesos(getSaldoPesos() - montoAextraer);

            System.out.printf("Extracción realizada de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
        }
    }

    public void depositarEfectivo(double montoAdepositar) {
        if (montoAdepositar > 0) {
            setSaldoPesos(getSaldoPesos() + montoAdepositar);
            System.out.printf("Depósito realizado de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
        } else {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        }

    }

}
