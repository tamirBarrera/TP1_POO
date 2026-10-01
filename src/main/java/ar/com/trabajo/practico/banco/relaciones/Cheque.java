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

        if (monto <= 0) {
            System.out.println("El monto debe ser positivo.");
        }

        if (bancoEmisor.length() < 1 && bancoEmisor.length() > 50) {
            System.out.println("El banco emisor debe tener entre 1 y 50 caracteres.");
        }

        if (fechaPago == null) {
            System.out.println("La fecha de pago no puede ser nula.");
        }
    }

}
