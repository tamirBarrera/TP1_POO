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
    private double tasaConverion;

    public CuentaConvertibilidad(int numeroCuenta, double saldoPesos, double saldoDolares, Cliente clienteAsociado,
            double descubierto, double tasaConverion) {
        super(numeroCuenta, saldoPesos, descubierto, clienteAsociado);
        if (saldoPesos < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo.");
        }
        if (saldoDolares < 0) {
            throw new IllegalArgumentException("El saldo en dolares no puede ser negativo.");
        }

        this.saldoDolares = saldoDolares;
        this.tasaConverion = 1500.60;

        if (!(clienteAsociado instanceof ClienteEmpresa)) {
            throw new IllegalArgumentException("La cuenta convertibilidad solo puede ser abierta por empresas");
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
            throw new IllegalArgumentException("Saldo insuficiente para realizar la extracción.");
        }
    }

    public void extraerEfectivo(double montoAextraer) {
        if (montoAextraer <= 0) {
            throw new IllegalArgumentException("El monto a extraer debe ser positivo.");
        } else if (getSaldoPesos() + getDescubierto() < montoAextraer) {
            throw new IllegalArgumentException("El monto a extraer es mayor al saldo disponible.");
        } else {
            setSaldoPesos(getSaldoPesos() - montoAextraer);
            System.out.printf("Extracción realizada de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
        }
    }

    public void depositarEfectivo(double montoAdepositar) {
        if (montoAdepositar <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        }
        setSaldoPesos(saldoPesos + montoAdepositar);
        System.out.printf("Depósito realizado de manera exitosa!!!. Nuevo saldo: %.2f", getSaldoPesos());
    }

    public void convertirPesosADolares(double monto, double tasaConverion) {
        if (monto > 0 && saldoPesos >= monto) {
            double dolaresConvertidos = monto / tasaConverion;
            setSaldoPesos(saldoPesos - monto);
            setSaldoDolares(saldoDolares + dolaresConvertidos);

            System.out.printf("Conversion de %.2f pesos a %.2f dolares realizada exitosamente. Nuevo saldo: %.2f",
                    monto, dolaresConvertidos, saldoPesos);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para realizar la conversión.");
        }

    }

    public void convertirDolaresAPesos(double monto, double tasaConverion) {
        if (monto > 0 && saldoDolares >= monto) {
            double pesosConvertidos = monto * tasaConverion;
            setSaldoPesos(saldoPesos + pesosConvertidos);
            setSaldoDolares(saldoDolares - monto);
            System.out.printf("Conversion de %.2f dolares a %.2f pesos realizada exitosamente. Nuevo saldo: %.2f",
                    monto, pesosConvertidos, saldoDolares);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para realizar la conversión.");
        }

    }

}
