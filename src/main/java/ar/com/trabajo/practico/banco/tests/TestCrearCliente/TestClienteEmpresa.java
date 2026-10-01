package ar.com.trabajo.practico.banco.tests.TestCrearCliente;

import java.util.Scanner;
import ar.com.trabajo.practico.banco.herencia.Cliente;
import ar.com.trabajo.practico.banco.relaciones.tipoCliente.ClienteEmpresa;

public class TestClienteEmpresa {

    public static void main(String[] args) {
        System.out.println("Pruebas cliente empresa");

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese razón social de la empresa");
        String razonSocial = sc.nextLine();
        System.out.println("Ingrese el CUIT de la empresa");
        String cuit = sc.nextLine();
        sc.close();

        // Generar valor int aleatorio para numeroCliente entre 1 y 999999
        int numeroCliente = (int) (Math.random() * 999999) + 1;

        Cliente cliente = new ClienteEmpresa(numeroCliente, razonSocial, cuit);
        System.out.println("Cliente Empresa generado exitosamente: " + cliente);
    }

}
