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
    private String cuit;
    // Herencia: Se hereda el constructor de la clase padre
    // Encapsulamiento: Se puede acceder a los atributos de la clase padre

    public ClienteEmpresa(int numeroCliente, String razonSocial, String cuit) {
        super(numeroCliente);
        this.razonSocial = razonSocial;
        this.cuit = cuit;

        if (numeroCliente <= 0 && numeroCliente > 999999 && cuit.length() < 11 && cuit.length() > 11) {
            System.out.println("El cuit debe tener 11 digitos."); // Numero cliente no lo ingresa el ususario pero lo
                                                                  // controlamos por
                                                                  // las dudas.
        } else if (razonSocial.length() < 1 && razonSocial.length() > 30) { // Razon social la ingresa el usuario y la
                                                                            // controlamos.

            System.out.println("La razon social no puede estar vacia ni tener mas de 30 digitos.");
        } else {
            System.out.println("Cliente dado de alta correctamente.");
        }
    }
}
