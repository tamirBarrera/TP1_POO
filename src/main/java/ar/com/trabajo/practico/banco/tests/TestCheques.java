package ar.com.trabajo.practico.banco.tests;

import ar.com.trabajo.practico.banco.relaciones.Cheque;
import java.time.LocalDate;
import java.util.Scanner;

public class TestCheques {

    public static void main(String[] args) {

        System.out.println("Prueba cheques");
        Scanner sc = new Scanner(System.in);

        System.out.println("Desea emitir un cheque? Y/N");
        String respuesta = sc.nextLine();

        switch (respuesta) {
            case "Y":
                System.out.println("Ingrese el monto a emitir");
                double monto = sc.nextDouble();
                sc.nextLine();
                System.out.println("Ingrese el banco emisor");
                String bancoEmisor = sc.nextLine();
                System.out.println("Ingrese la fecha de pago en formato AAAA-MM-DD (Anualidad, mes y dia)");
                LocalDate fechaPago = LocalDate.parse(sc.nextLine());

                Cheque cheque1 = new Cheque(monto, bancoEmisor, fechaPago);

                System.out.println("Cheque creado con exito!! " + cheque1.toString());

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
