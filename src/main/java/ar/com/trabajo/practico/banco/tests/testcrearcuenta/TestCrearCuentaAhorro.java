package ar.com.trabajo.practico.banco.tests.testcrearcuenta;

import java.util.Scanner;

import ar.com.trabajo.practico.banco.clientetipo.ClienteIndividual;
import ar.com.trabajo.practico.banco.cuentatipo.CajaAhorro;

public class TestCrearCuentaAhorro {

    // Método auxiliar para buscar si existe alguna cuenta con el número ingresado
    private static CajaAhorro buscarCuenta(CajaAhorro[] cuentas, int numeroCuenta) {
        for (CajaAhorro c : cuentas) {
            if (c.getNumeroCuenta() == numeroCuenta) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println("Pruebas cuenta de ahorro");

        // Instancias de prueba
        ClienteIndividual cliente1 = new ClienteIndividual(1234567, "Juan", "Perez", "42996907", "M");
        ClienteIndividual cliente2 = new ClienteIndividual(7654321, "Maria", "Lopez", "43890956", "F");

        CajaAhorro cuentaAhorro1 = new CajaAhorro(123456789, cliente1, 0.1);
        CajaAhorro cuentaAhorro2 = new CajaAhorro(987654321, cliente2, 0.15);

        CajaAhorro[] cuentas = { cuentaAhorro1, cuentaAhorro2 };

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido cliente, ingrese su numero de cuenta: ");
        int numeroCuenta = sc.nextInt();

        // Validación: se busca si coincide con el número de cuenta de cualquier
        // instancia
        CajaAhorro cuentaSeleccionada = buscarCuenta(cuentas, numeroCuenta);

        // El condicional while repite hasta que se ingrese un numeroCuenta de cualquier
        // instancia existente
        while (cuentaSeleccionada == null) {
            System.out.println("Número de cuenta inválido. Ingrese un número de cuenta válido:");
            numeroCuenta = sc.nextInt();
            cuentaSeleccionada = buscarCuenta(cuentas, numeroCuenta);
        }

        sc.nextLine(); // Limpieza del buffer tras leer el entero

        System.out.println("Cuenta de Ahorro inicializada exitosamente: " + cuentaSeleccionada.toString());

        System.out.println("Desea realizar un deposito, extraccion o cobrar interes? Y/N");
        String respuesta = sc.nextLine();

        switch (respuesta.toUpperCase()) {
            case "Y":
                System.out.println(
                        "Si desea realizar un deposito presione D, si desea realizar una extraccion presione E, si desea cobrar interes presione C");
                String respuesta2 = sc.nextLine();
                switch (respuesta2.toUpperCase()) {
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
                    case "C":
                        cuentaSeleccionada.cobrarInteres();
                        System.out.println("El saldo actual es: " + cuentaSeleccionada.getSaldoPesos());
                        break;
                    default:
                        System.out.println("Respuesta invalida.");
                        break;
                }
                break;
            case "N":
                System.out.println("Gracias por utilizar nuestros servicios.");
                break;
            default:
                System.out.println("Respuesta invalida.");
                break;
        }
        sc.close();

    }

}
