package ar.com.trabajo.practico.banco.cuentatipo;

import ar.com.trabajo.practico.banco.clientetipo.Cliente;
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

    public void cobrarInteres() {
        depositarEfectivo(getSaldoPesos() * tasaInteres);
        System.out.printf("Intereses cobrados de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
    }
    
}
