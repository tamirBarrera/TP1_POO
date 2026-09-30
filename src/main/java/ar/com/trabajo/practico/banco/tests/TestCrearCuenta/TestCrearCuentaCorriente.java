package ar.com.trabajo.practico.banco.tests.TestCrearCuenta;

import ar.com.trabajo.practico.banco.herencia.Cuenta;
import ar.com.trabajo.practico.banco.relaciones.tipoCuenta.CuentaCorriente;
import java.util.Scanner;

public class TestCrearCuentaCorriente {

    public static void main(String[] args) {
        System.out.println("Pruebas cuenta corriente");

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido cliente, ingrese su numero de cuenta: ");
        int numeroCuenta = sc.nextInt();

        double saldoPesos = 0;
        double descubierto = 200000;

        Cuenta cuentaCorriente = new CuentaCorriente(numeroCuenta, saldoPesos, descubierto, null);

        System.out.println("Cuenta corriente generada exitosamente: " + cuentaCorriente);

        System.out.println("Desea realizar un deposito o extraccion? Y/N");
        String respuesta = sc.nextLine();

        if (respuesta.toUpperCase() == "Y") {
            System.out.println(
                    "Si desea realizar un deposito presione D, si desea realizar una extraccion presione E");
            String respuesta2 = sc.nextLine();
            switch (respuesta2.toUpperCase()) {
                case "D":
                    System.out.println("Ingrese el monto a depositar");
                    double monto = sc.nextDouble();
                    cuentaCorriente.depositarEfectivo(monto);
                    System.out.println("El saldo actual es: " + cuentaCorriente.getSaldoPesos());
                    break;
                case "E":
                    System.out.println("Ingrese el monto a extraer");
                    double monto2 = sc.nextDouble();
                    cuentaCorriente.extraerEfectivo(monto2);
                    System.out.println("El saldo actual es: " + cuentaCorriente.getSaldoPesos());
                    break;
                default:
                    System.out.println("Respuesta invalida.");
                    break;
            }
        } else if (respuesta.toUpperCase() == "N") {
            System.out.println("Gracias por utilizar nuestros servicios.");
        } else {
            System.out.println("Respuesta invalida.");
        }
        sc.close();

    }
}
