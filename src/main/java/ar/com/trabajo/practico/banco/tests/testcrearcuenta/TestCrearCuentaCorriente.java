package ar.com.trabajo.practico.banco.tests.testcrearcuenta;

import java.time.LocalDate;
import java.util.Scanner;

import ar.com.trabajo.practico.banco.Cheque;
import ar.com.trabajo.practico.banco.clientetipo.ClienteIndividual;
import ar.com.trabajo.practico.banco.cuentatipo.CuentaCorriente;

public class TestCrearCuentaCorriente {

    private static CuentaCorriente buscarCuenta(CuentaCorriente[] cuentas, int numeroCuenta) {
        for (CuentaCorriente c : cuentas) {
            if (c.getNumeroCuenta() == numeroCuenta) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        ClienteIndividual cliente1 = new ClienteIndividual(1234567, "Juan", "Perez", "42996907", "M");
        ClienteIndividual cliente2 = new ClienteIndividual(7654321, "Maria", "Gomez", "32123456", "F");

        CuentaCorriente cuentaCorriente1 = new CuentaCorriente(123456789, cliente1, 100000);
        CuentaCorriente cuentaCorriente2 = new CuentaCorriente(987654321, cliente2, 250000);
        CuentaCorriente[] cuentas = { cuentaCorriente1, cuentaCorriente2 };

        System.out.println("Pruebas cuenta corriente");

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido cliente, ingrese su numero de cuenta: ");
        int numeroCuenta = sc.nextInt();
        // Validación: se busca si coincide con el número de cuenta de cualquier
        // instancia
        CuentaCorriente cuentaSeleccionada = buscarCuenta(cuentas, numeroCuenta);

        // El condicional while repite hasta que se ingrese un numeroCuenta de cualquier
        // instancia existente
        while (cuentaSeleccionada == null) {
            System.out.println("Número de cuenta inválido. Ingrese un número de cuenta válido:");
            numeroCuenta = sc.nextInt();
            cuentaSeleccionada = buscarCuenta(cuentas, numeroCuenta);
        }

        System.out.println("Cuenta corriente ingresada correctamente: ");

        System.out.println("Desea realizar un deposito o extraccion? Y/N");
        String respuesta = sc.nextLine();

        if (respuesta.equalsIgnoreCase("Y")) {

            System.out.println(
                    "Si desea realizar un deposito presione D, si desea realizar una extraccion presione E, si desea depositar un cheque presione C");

            String respuesta2 = sc.nextLine();
            switch (respuesta2.toUpperCase()) {
                case "C":
                    System.out.println("Ingrese el monto del cheque a depositar");
                    double monto3 = sc.nextDouble();
                    Cheque nuevoCheque1 = new Cheque(monto3, "Banco Provincia", LocalDate.now());
                    cuentaSeleccionada.depositarCheque(nuevoCheque1);
                    System.out.println("La fecha del cheque es: " + LocalDate.now() + "\n" + "El saldo actual es: "
                            + cuentaSeleccionada.getSaldoPesos());
                    break;

                case "D":
                    System.out.println("Ingrese el monto a depositar");
                    double monto = sc.nextDouble();
                    cuentaSeleccionada.depositarEfectivo(monto);
                    System.out.println("El saldo actual es: " + cuentaSeleccionada.getSaldoPesos());
                    break;
                case "E":
                    System.out.println("Ingrese el monto a extraer");
                    double monto2 = sc.nextDouble();
                    cuentaSeleccionada.extraerEfectivo(monto2);
                    System.out.println("El saldo actual es: " + cuentaSeleccionada.getSaldoPesos());
                    break;
                default:
                    System.out.println("Respuesta invalida.");
                    break;
            }
        } else if (respuesta.equalsIgnoreCase("N")) {
            System.out.println("Gracias por utilizar nuestros servicios.");
        } else {
            System.out.println("Respuesta invalida.");
        }
        sc.close();

    }
}
