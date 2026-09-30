package ar.com.trabajo.practico.banco.tests.TestCrearCuenta;

import java.util.Scanner;

import ar.com.trabajo.practico.banco.herencia.Cuenta;
import ar.com.trabajo.practico.banco.relaciones.tipoCuenta.CajaAhorro;

public class TestCrearCuentaAhorro {

    public static void main(String[] args) {
        System.out.println("Pruebas cuenta de ahorro");

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido cliente, ingrese su numero de cuenta: ");
        int numeroCuenta = sc.nextInt();

        double saldoPesos = 0;
        double tasaInteres = 0.25; // El valor del interes se lo doy manualmente para que varie
                                   // en vez de hacerlo static final.

        Cuenta cuentaAhorro = new CajaAhorro(numeroCuenta, saldoPesos, tasaInteres, null);

        System.out.println("Cuenta de Ahorro generada exitosamente: " + cuentaAhorro);

        System.out.println("Desea realizar un deposito o extraccion? Y/N");
        String respuesta = sc.nextLine();

        switch (respuesta.toUpperCase()) {
            case "Y":
                System.out.println(
                        "Si desea realizar un deposito presione D, si desea realizar una extraccion presione E");
                String respuesta2 = sc.nextLine();
                switch (respuesta2) {
                    case "D":
                        System.out.println("Ingrese el monto a depositar");
                        double monto = sc.nextDouble();
                        cuentaAhorro.depositarEfectivo(monto);
                        monto = +saldoPesos;
                        System.out.println("El saldo actual es: " + saldoPesos);
                        break;
                    case "E":
                        System.out.println("Ingrese el monto a extraer");
                        double monto2 = sc.nextDouble();
                        cuentaAhorro.extraerEfectivo(monto2);
                        monto2 = -saldoPesos;
                        System.out.println("El saldo actual es: " + saldoPesos);
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
