package ar.com.trabajo.practico.banco.relaciones;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Cheque {
    private double monto;
    private String bancoEmisor;
    private LocalDate fechaPago;

    public Cheque(double monto, String bancoEmisor, LocalDate fechaPago) {
        this.monto = monto;
        this.bancoEmisor = bancoEmisor;
        this.fechaPago = fechaPago;
    }

}
