package ar.com.trabajo.practico.banco.tests.TestCrearCuenta;

import ar.com.trabajo.practico.banco.relaciones.Cheque;
import ar.com.trabajo.practico.banco.herencia.Cuenta;
import ar.com.trabajo.practico.banco.relaciones.tipoCuenta.CuentaCorriente;

import java.time.LocalDate;
import java.util.Scanner;

public class TestCrearCuentaCorriente {

    public static void main(String[] args) {
        System.out.println("Pruebas cuenta corriente");

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido cliente, ingrese su numero de cuenta: ");
        int numeroCuenta = sc.nextInt();
        sc.nextLine();

        double saldoPesos = 0;
        double descubierto = 200000;

        CuentaCorriente cuentaCorriente = new CuentaCorriente(numeroCuenta, saldoPesos, descubierto, null);

        System.out.println("Cuenta corriente ingresada correctamente: ");

        System.out.println("Desea realizar un deposito o extraccion? Y/N");
        String respuesta = sc.nextLine();

        if (respuesta.equals("Y") || respuesta.equals("y")) {

            System.out.println(
                    "Si desea realizar un deposito presione D, si desea realizar una extraccion presione E, si desea depositar un cheque presione C");

            String respuesta2 = sc.nextLine();
            switch (respuesta2.toUpperCase()) {
                case "C":
                    System.out.println("Ingrese el monto del cheque a depositar");
                    double monto3 = sc.nextDouble();
                    Cheque nuevoCheque1 = new Cheque(monto3, "Banco Provincia", LocalDate.now());
                    cuentaCorriente.depositarCheque(nuevoCheque1);
                    System.out.println("La fecha del cheque es: " + LocalDate.now() + "\n" + "El saldo actual es: "
                            + cuentaCorriente.getSaldoPesos());
                    break;

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
        } else if (respuesta.equals("N") || respuesta.equals("n")) {
            System.out.println("Gracias por utilizar nuestros servicios.");
        } else {
            System.out.println("Respuesta invalida.");
        }
        sc.close();

    }
}
