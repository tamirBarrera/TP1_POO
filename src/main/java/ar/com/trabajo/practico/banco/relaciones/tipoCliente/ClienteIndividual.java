package ar.com.trabajo.practico.banco.relaciones.tipoCliente;

import ar.com.trabajo.practico.banco.herencia.Cliente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class ClienteIndividual extends Cliente {
    private String nombre;
    private String apellido;
    private int dni;

    public ClienteIndividual(int numeroCliente, String nombre, String apellido, int dni, String genero) {
        super(numeroCliente);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    } // Reusabilidad: Se reutiliza el constructor de la clase padre para obtener el
      // numero de cliente
      // Herencia: Se hereda el constructor de la clase padre
      // Encapsulamiento: Se puede acceder a los atributos de la clase padre
}
