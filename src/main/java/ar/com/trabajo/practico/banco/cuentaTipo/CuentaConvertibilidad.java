package ar.com.trabajo.practico.banco.cuentatipo;

import ar.com.trabajo.practico.banco.clientetipo.Cliente;
import ar.com.trabajo.practico.banco.clientetipo.ClienteEmpresa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class CuentaConvertibilidad extends CuentaCorriente {

    private double saldoDolares;

    public CuentaConvertibilidad(int numeroCuenta, Cliente clienteAsociado, double descubierto) {
        super(numeroCuenta, clienteAsociado, descubierto);

        // validacion para que la cuenta convertibilidad sea creada unicamente por
        // empresas y retorne un objeto nulo si no lo es

        if (!(clienteAsociado instanceof ClienteEmpresa)) {
            throw new IllegalArgumentException("La cuenta convertibilidad solo puede ser abierta por empresas");
        } else {
            System.out.println("Cuenta de convertibilidad creada exitosamente");
        }

    }

    public void depositarDolares(double monto) {
        if (monto > 0) {
            saldoDolares += monto;
            System.out.printf("Depósito de %.2f realizado exitosamente. Saldo actual: %.2f%n", monto, getSaldoPesos());
        } else {
            System.out.println("El monto a depositar debe ser positivo.");
        }
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

    public void convertirPesosADolares(double monto, double tasaConversionCompra) {
        if (monto > 0 && getSaldoPesos() >= monto) {
            double dolaresConvertidos = monto / tasaConversionCompra;
            setSaldoPesos(getSaldoPesos() - monto);
            setSaldoDolares(getSaldoDolares() + dolaresConvertidos);

            System.out.printf("Conversion de %.2f pesos a %.2f dolares realizada exitosamente. Nuevo saldo: %.2f",
                    monto, dolaresConvertidos, getSaldoPesos());
        } else {
            System.out.println("Saldo insuficiente para realizar la conversión.");
        }

    }

    public void convertirDolaresAPesos(double monto, double tasaConversionVenta) {
        if (monto > 0 && saldoDolares >= monto) {
            double pesosConvertidos = monto * tasaConversionVenta;
            setSaldoPesos(getSaldoPesos() + pesosConvertidos);
            setSaldoDolares(getSaldoDolares() - monto);
            System.out.printf("Conversion de %.2f dolares a %.2f pesos realizada exitosamente. Nuevo saldo: %.2f",
                    monto, pesosConvertidos, getSaldoPesos());
        } else {
            System.out.println("Saldo insuficiente para realizar la conversión.");
        }

    }

}
