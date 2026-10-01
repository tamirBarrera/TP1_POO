package ar.com.trabajo.practico.banco.relaciones.tipoCuenta;

import ar.com.trabajo.practico.banco.herencia.Cliente;
import ar.com.trabajo.practico.banco.relaciones.tipoCliente.ClienteEmpresa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class CuentaConvertibilidad extends CuentaCorriente {

    private double saldoDolares;

    public CuentaConvertibilidad(int numeroCuenta, double saldoPesos, double saldoDolares, Cliente clienteAsociado,
            double descubierto, double tasaConverion) {
        super(numeroCuenta, saldoPesos, descubierto, clienteAsociado);
        if (saldoPesos < 0) {
            System.out.println("El saldo no puede ser negativo.");
        }
        if (saldoDolares < 0) {
            System.out.println("El saldo en dolares no puede ser negativo.");
        }

        this.saldoDolares = saldoDolares;

        if (!(clienteAsociado instanceof ClienteEmpresa)) {
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
        if (monto <= 0) {
            System.out.println("El monto a extraer debe ser positivo.");
        } else if (getSaldoPesos() + getDescubierto() < monto) {
            System.out.println("El monto a extraer es mayor al saldo disponible.");
        } else {
            setSaldoPesos(getSaldoPesos() - monto);
            System.out.printf("Extracción realizada de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
        }
    }

    public void depositarEfectivo(double monto) {
        if (monto <= 0) {
            System.out.println("El monto a depositar debe ser positivo.");
        }
        setSaldoPesos(saldoPesos + monto);
        System.out.printf("Depósito realizado de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
    }

    public void convertirPesosADolares(double monto, double tasaConverionCompra) {
        if (monto > 0 && saldoPesos >= monto) {
            double dolaresConvertidos = monto / tasaConverionCompra;
            setSaldoPesos(saldoPesos - monto);
            setSaldoDolares(saldoDolares + dolaresConvertidos);

            System.out.printf("Conversion de %.2f pesos a %.2f dolares realizada exitosamente. Nuevo saldo: %.2f",
                    monto, dolaresConvertidos, saldoPesos);
        } else {
            System.out.println("Saldo insuficiente para realizar la conversión.");
        }

    }

    public void convertirDolaresAPesos(double monto, double tasaConverionVenta) {
        if (monto > 0 && saldoDolares >= monto) {
            double pesosConvertidos = monto * tasaConverionVenta;
            setSaldoPesos(saldoPesos + pesosConvertidos);
            setSaldoDolares(saldoDolares - monto);
            System.out.printf("Conversion de %.2f dolares a %.2f pesos realizada exitosamente. Nuevo saldo: %.2f",
                    monto, pesosConvertidos, saldoDolares);
        } else {
            System.out.println("Saldo insuficiente para realizar la conversión.");
        }

    }

}
