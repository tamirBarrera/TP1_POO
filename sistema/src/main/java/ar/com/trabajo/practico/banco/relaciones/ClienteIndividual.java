package ar.com.trabajo.practico.banco.relaciones;

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
    private Integer dni;

    public ClienteIndividual(int numeroCliente, String nombre, String apellido, Integer dni, String genero) {
        super(numeroCliente);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
}
