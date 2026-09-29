package ar.com.trabajo.practico.banco.relaciones;

import ar.com.trabajo.practico.banco.herencia.Cliente;
import ar.com.trabajo.practico.banco.herencia.Cuenta;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class CuentaConvertibilidad extends Cuenta {

    private double saldoDolares;
    private double saldoPesos;

    public CuentaConvertibilidad(int numeroCuenta, double saldoPesos, double saldoDolares, Cliente cliente) {
        super(numeroCuenta, saldoPesos, cliente);
        this.saldoPesos = saldoPesos;
        this.saldoDolares = saldoDolares;
        if (!(cliente instanceof ClienteEmpresa)){
            System.out.println("La cuenta convertibilidad solo puede ser abierta por empresas");
        }

    }

    public void depositarDolares(double monto) {
        saldoDolares += monto;

        System.out.printf("Depósito de %.2f realizado exitosamente. Saldo actual: %.2f%n", monto, getSaldoPesos());
    }

    public void extraerDolares(double monto) {
        if (monto > 0 && saldoDolares >= monto) {
            saldoDolares -= monto;
            System.out.printf("Extracción de %.2f realizada exitosamente. Saldo actual: %.2f%n", monto,
                    getSaldoPesos());
        } else {
            System.out.println("Saldo insuficiente para realizar la extracción.");
        }
    }

    public void extraerEfectivo(double monto) {
        extraerEfectivo(monto);
        System.out.printf("Extracción realizada de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
    }

    public void depositarEfectivo(double monto) {
        depositarEfectivo(monto);
        System.out.printf("Depósito realizado de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
    }

    public void convertirPesosADolares(double monto, double tasaConverion){
        if (monto > 0 && saldoPesos >= monto){
            double dolaresConvertidos = monto / tasaConverion;
            this.saldoPesos -= monto;
            this.saldoDolares += dolaresConvertidos;

            System.out.printf("Conversion de %.2f pesos a %.2f dolares realizada exitosamente. Nuevo saldo: %.2f",
                    monto, dolaresConvertidos, getSaldoPesos());
        } else {
            System.out.println("Saldo insuficiente para realizar la conversión.");
        }
        
        
    }

    public void convertirDolaresAPesos(double monto, double tasaConverion){
        if (monto > 0 && saldoDolares >= monto){
            double pesosConvertidos = monto * tasaConverion;
            this.saldoDolares -= monto;
            this.saldoPesos += pesosConvertidos;

            System.out.printf("Conversion de %.2f dolares a %.2f pesos realizada exitosamente. Nuevo saldo: %.2f",
                    monto, pesosConvertidos, getSaldoDolares());
        } else {
            System.out.println("Saldo insuficiente para realizar la conversión.");
        }
        
    }



}
