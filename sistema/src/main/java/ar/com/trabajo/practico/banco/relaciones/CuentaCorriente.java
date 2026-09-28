package ar.com.trabajo.practico.banco.relaciones;

import ar.com.trabajo.practico.banco.herencia.Cuenta;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class CuentaCorriente extends Cuenta {
    private double saldoPesos;
    private double descubierto;

    public CuentaCorriente(int numeroCuenta, double saldoPesos, double descubierto) {
        super(numeroCuenta);
        this.saldoPesos = saldoPesos;
        this.descubierto = descubierto;
    }

    public void depositarCheque(Cheque cheque) {
        depositarEfectivo(monto);
        System.out.printf("Depósito de %.2f realizado exitosamente. Saldo actual: %.2f%n", monto, getSaldoPesos());
    }

    public void extraerEfectivo(double saldoPesos) {
        extraerEfectivo(saldoPesos);

        System.out.printf("Extracción realizada de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
    }

    public void depositarEfectivo(double saldoPesos) {
        depositarEfectivo(saldoPesos);

        System.out.printf("Depósito realizado de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
    }

}
