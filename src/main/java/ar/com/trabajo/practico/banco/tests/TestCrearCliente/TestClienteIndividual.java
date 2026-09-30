package ar.com.trabajo.practico.banco.tests.TestCrearCliente;

import java.util.Scanner;
import ar.com.trabajo.practico.banco.herencia.Cliente;
import ar.com.trabajo.practico.banco.relaciones.tipoCliente.ClienteIndividual;

public class TestClienteIndividual {

    public static void main(String[] args) {
        System.out.println("------Iniciando Pruebas------");

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del cliente");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el apellido del cliente");
        String apellido = sc.nextLine();
        System.out.println("Ingrese el DNI del cliente");
        int dni = sc.nextInt();
        System.out.println("Ingrese su genero Masculino/Femenino con M o F");
        String genero = sc.nextLine();

        sc.close();

        // Generar valor int aleatorio para numeroCliente entre 1 y 999999
        int numeroCliente = (int) (Math.random() * 999999) + 1;

        Cliente cliente = new ClienteIndividual(numeroCliente, nombre, apellido, dni, genero);
        System.out.println("Cliente generado exitosamente: " + cliente);
    }

}
