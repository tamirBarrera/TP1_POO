package ar.com.trabajo.practico.banco.tests.testCrearCuenta;

import java.util.Scanner;

import ar.com.trabajo.practico.banco.cuentaTipo.Cuenta;
import ar.com.trabajo.practico.banco.cuentaTipo.CuentaCorriente;

public class TestCrearCuentaConvertibilidad {

    public static void main(String[] args) {
        System.out.println("Pruebas Cuenta de Convertibilidad");

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido cliente, ingrese su numero de cuenta: ");
        int numeroCuenta = sc.nextInt();
        sc.nextLine();

        Cuenta cuentaConvertibilidad = new CuentaCorriente(numeroCuenta, null);

        System.out.println("Cuenta de Convertibilidad generada exitosamente: " + cuentaConvertibilidad);

        System.out.println("Desea realizar un deposito o extraccion? Y/N");
        String respuesta = sc.nextLine();

        switch (respuesta.toUpperCase()) {
            case "Y":
                System.out.println(
                        "Si desea realizar un deposito presione D, si desea realizar una extraccion presione E");
                String respuesta2 = sc.nextLine();
                switch (respuesta2.toUpperCase()) {
                    case "D":
                        System.out.println("Ingrese el monto a depositar");
                        double monto = sc.nextDouble();
                        cuentaConvertibilidad.depositarEfectivo(monto);
                        System.out.println("El saldo actual es: " + cuentaConvertibilidad.getSaldoPesos());
                        sc.nextLine();
                        break;
                    case "E":
                        System.out.println("Ingrese el monto a extraer");
                        double monto2 = sc.nextDouble();
                        cuentaConvertibilidad.extraerEfectivo(monto2);
                        System.out.println("El saldo actual es: " + cuentaConvertibilidad.getSaldoPesos());
                        sc.nextLine();
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
