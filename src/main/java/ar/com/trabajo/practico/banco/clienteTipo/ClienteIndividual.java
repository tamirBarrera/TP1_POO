package ar.com.trabajo.practico.banco.clienteTipo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class ClienteIndividual extends Cliente {
    private String nombre;
    private String apellido;
    private String dni;
    private String genero;

    public ClienteIndividual(int numeroCliente, String nombre, String apellido, String dni, String genero) {
        super(numeroCliente);
        this.nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
        this.apellido = apellido.substring(0, 1).toUpperCase() + apellido.substring(1);
        this.dni = dni;
        this.genero = genero;

        if (nombre.length() > 1 && nombre.length() < 50) {
            System.out.println("Nombre ingresado de manera correcta");
            if (apellido.length() > 1 && apellido.length() < 50) {
                System.out.println("Apellido ingresado de manera correcta");

                if (dni.length() < 7 && dni.length() > 8) {
                    System.out.println("Dni ingresado de manera correcta");
                    if (genero == "M" || genero == "F") {
                        System.out.println("Genero ingresado de manera correcta");
                    } else {
                        System.out.println("Error: Genero ingresado de manera incorrecta, ingresar 'M' o 'F'");
                    }
                } else {
                    System.out.println("Error: Dni ingresado de manera incorrecta, debe tener entre 7 y 8 digitos");
                }
            } else {
                System.out
                        .println("Error: Apellido ingresado de manera incorrecta, debe tener entre 2 y 50 caracteres");
            }
        } else {
            System.out.println("Error: Nombre invalido, debe tener entre 2 y 50 caracteres");
        }

    } // Reusabilidad: Se reutiliza el constructor de la clase padre para obtener el
      // numero de cliente
      // Herencia: Se hereda el constructor de la clase padre
      // Encapsulamiento: Se puede acceder a los atributos de la clase padre
}
