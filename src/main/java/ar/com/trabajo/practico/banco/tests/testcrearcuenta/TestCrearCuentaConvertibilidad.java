package ar.com.trabajo.practico.banco.tests.testcrearcuenta;

import java.util.Scanner;

import ar.com.trabajo.practico.banco.clientetipo.ClienteEmpresa;
import ar.com.trabajo.practico.banco.clientetipo.ClienteIndividual;
import ar.com.trabajo.practico.banco.cuentatipo.CuentaConvertibilidad;

public class TestCrearCuentaConvertibilidad {

    private static CuentaConvertibilidad buscarCuenta(CuentaConvertibilidad[] cuentas, int numeroCuenta) {
        for (CuentaConvertibilidad c : cuentas) {
            if (c.getNumeroCuenta() == numeroCuenta) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        ClienteEmpresa cliente3 = new ClienteEmpresa(123, "Empresa 1", "12345678901");
        ClienteEmpresa cliente4 = new ClienteEmpresa(456, "Empresa 2", "98765432109");

        ClienteIndividual cliente1 = new ClienteIndividual(1234567, "Juan", "Perez", "42996907", "M");

        CuentaConvertibilidad cuentaConvertibilidad1 = new CuentaConvertibilidad(123456789, cliente3, 100000);
        CuentaConvertibilidad cuentaConvertibilidad2 = new CuentaConvertibilidad(987654321, cliente4, 250000);

        CuentaConvertibilidad[] cuentas = { cuentaConvertibilidad1, cuentaConvertibilidad2 };

        System.out.println("Test: intento de crear cuenta con ClienteIndividual");
        try {
            CuentaConvertibilidad cuentaPrueba = new CuentaConvertibilidad(555555, cliente1, 50000);
            System.out.println(cuentaPrueba.toString());
            System.out.println("Se creó la cuenta correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error!!: La cuenta no se puede crear siendo cliente Individual.");
        }

        

        System.out.println("Pruebas Cuenta de Convertibilidad");

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido cliente, ingrese su numero de cuenta: ");
        int numeroCuenta = sc.nextInt();
        // Validación: se busca si coincide con el número de cuenta de cualquier
        // instancia
        CuentaConvertibilidad cuentaSeleccionada = buscarCuenta(cuentas, numeroCuenta);

        // El condicional while repite hasta que se ingrese un numeroCuenta de cualquier
        // instancia existente
        while (cuentaSeleccionada == null) {
            System.out.println("Número de cuenta inválido. Ingrese un número de cuenta válido:");
            numeroCuenta = sc.nextInt();
            cuentaSeleccionada = buscarCuenta(cuentas, numeroCuenta);
        }

        System.out.println("Cuenta de Convertibilidad inicializada exitosamente: ");

        System.out.println("------------------------------");

        System.out.println("Desea realizar un deposito, extraccion o conversion? Y/N");
        String respuesta = sc.nextLine();

        switch (respuesta.toUpperCase()) {
            case "Y":
                System.out.println(
                        "Si desea realizar un deposito presione D, si desea realizar una extraccion presione E, si desea realizar una conversion pesos a dolares presione PD, si desea realizar una conversion dolares a pesos presione DP");
                String respuesta2 = sc.nextLine();
                switch (respuesta2.toUpperCase()) {
                    // tambien usa descubierto pero no aplica a dolares
                    case "D":
                        System.out.println("Ingrese el monto a depositar");
                        double monto = sc.nextDouble();
                        cuentaSeleccionada.depositarEfectivo(monto);
                        System.out.println("El saldo actual es: " + cuentaSeleccionada.getSaldoPesos());
                        sc.nextLine();
                        break;
                    case "E":
                        // preguntar si desea extraer pesos o dolares
                        System.out.println("Desea extraer pesos (P) o dolares (D)?");
                        String respuesta3 = sc.nextLine();
                        switch (respuesta3.toUpperCase()) {
                            case "P":
                                // usa descubierto
                                System.out.println("Ingrese el monto a extraer");
                                double monto2 = sc.nextDouble();
                                cuentaSeleccionada.extraerEfectivo(monto2 + cuentaSeleccionada.getDescubierto());
                                System.out.println("El saldo actual es: " + cuentaSeleccionada.getSaldoPesos());
                                break;
                            case "D":
                                // no usa descubierto
                                System.out.println("Ingrese el monto a extraer");
                                double monto4 = sc.nextDouble();
                                cuentaSeleccionada.extraerDolares(monto4);
                                System.out.println("El saldo actual es: " + cuentaSeleccionada.getSaldoDolares());
                                break;
                            default:
                                System.out.println("Respuesta invalida.");
                                break;
                        }
                        sc.nextLine();
                        break;
                    case "PD":
                        System.out.println("Ingrese el monto en pesos a convertir");
                        double monto3 = sc.nextDouble();
                        System.out.println("Ingrese la tasa de conversion");
                        double tasaConversion = sc.nextDouble();
                        cuentaSeleccionada.convertirPesosADolares(monto3, tasaConversion);
                        System.out.println("El saldo actual es: " + cuentaSeleccionada.getSaldoPesos());
                        sc.nextLine();
                        break;
                    case "DP":
                        System.out.println("Ingrese el monto en dolares a convertir");
                        double monto4 = sc.nextDouble();
                        System.out.println("Ingrese la tasa de conversion");
                        double tasaConversion2 = sc.nextDouble();
                        cuentaSeleccionada.convertirDolaresAPesos(monto4, tasaConversion2);
                        System.out.println("El saldo actual es: " + cuentaSeleccionada.getSaldoPesos());
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
