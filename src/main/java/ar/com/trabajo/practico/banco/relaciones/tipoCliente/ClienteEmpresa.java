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
    // Herencia: Se hereda el constructor de la clase padre
    // Encapsulamiento: Se puede acceder a los atributos de la clase padre

    public ClienteEmpresa(int numeroCliente, String razonSocial, int cuit) {
        super(numeroCliente);

        if (numeroCliente <= 0 && numeroCliente > 999999 && cuit <= 0 && cuit > 11) {
            throw new IllegalArgumentException(
                    "El cuit debe ser positivo."); // Numero cliente no lo ingresa el ususario pero lo controlamos por
                                                   // las dudas.

        } else if (razonSocial.length() < 1 && razonSocial.length() > 30) { // Razon social la ingresa el usuario y la
                                                                            // controlamos.

            throw new IllegalArgumentException("La razon social no puede estar vacia ni tener mas de 30 digitos.");
        }

        this.razonSocial = razonSocial;
        this.cuit = cuit;
    }

}
