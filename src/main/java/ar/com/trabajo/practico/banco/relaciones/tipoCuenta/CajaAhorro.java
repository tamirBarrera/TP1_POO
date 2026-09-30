package ar.com.trabajo.practico.banco.relaciones.tipoCuenta;

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
        if (saldoPesos <= 0) {
            throw new IllegalArgumentException("El saldo debe ser positivo.");
        }
        if (tasaInteres <= 0) {
            throw new IllegalArgumentException("La tasa de interes debe ser positiva.");
        }
        this.saldoPesos = saldoPesos;
        this.tasaInteres = tasaInteres; // El valor del interes se lo doy manualmente para que varie
                                        // en vez de hacerlo static final.
    }

    public void depositarEfectivo(double montoAdepositar) {
        if (montoAdepositar <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        }
        setSaldoPesos(getSaldoPesos() + montoAdepositar);
        System.out.printf("Depósito realizado de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
    }

    public void extraerEfectivo(double montoAextraer) {
        if (montoAextraer <= 0) {
            throw new IllegalArgumentException("El monto a extraer debe ser positivo.");
        }
        setSaldoPesos(getSaldoPesos() - montoAextraer);
        System.out.printf("Extracción realizada de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
    }

    public void cobrarInteres() {
        depositarEfectivo(saldoPesos * 0.100);
        System.out.printf("Intereses cobrados de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
    }
}
