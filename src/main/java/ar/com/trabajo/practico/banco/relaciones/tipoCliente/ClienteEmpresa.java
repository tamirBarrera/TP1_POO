package ar.com.trabajo.practico.banco.relaciones.tipoCliente;

import ar.com.trabajo.practico.banco.herencia.Cliente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ClienteEmpresa extends Cliente {
    private String razonSocial;
    private int cuit;

    public ClienteEmpresa(int numeroCliente, String razonSocial, int cuit) {
        super(numeroCliente);
        this.razonSocial = razonSocial;
        this.cuit = cuit;
    } 
    // Herencia: Se hereda el constructor de la clase padre
    // Encapsulamiento: Se puede acceder a los atributos de la clase padre
    
}
