package ar.com.trabajo.practico.banco.relaciones;

import ar.com.trabajo.practico.banco.herencia.Cliente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ClienteEmpresa extends Cliente {
    private String razonSocial;
    private Integer cuit;

    public ClienteEmpresa(int numeroCliente, String razonSocial, Integer cuit) {
        super(numeroCliente);
        this.razonSocial = razonSocial;
        this.cuit = cuit;
    }
}
