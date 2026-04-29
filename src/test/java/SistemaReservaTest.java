package org.example;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaReservaTest {

    @Test
    void deveCriarReservaValida() {
        SistemaReserva sistema = new SistemaReserva();
        Quarto quarto = new Quarto(101);
        Reserva reserva = new Reserva("Jonatas", quarto,
                LocalDate.of(2026, 4, 29),
                LocalDate.of(2026,4,30));

        assertTrue(sistema.reservar(reserva));
    }

    @Test
    void deveRejeitarDatasInvalidas() {
        Quarto quarto = new Quarto(102);
        assertThrows(IllegalArgumentException.class, () -> {
            new Reserva("Maria", quarto,
                    LocalDate.of(2026,4,30),
                    LocalDate.of(2026,4,29));
        });
    }

    @Test
    void deveRejeitarConflitoDeReservas() {
        SistemaReserva sistema = new SistemaReserva();
        Quarto quarto = new Quarto(103);

        Reserva r1 = new Reserva("Carlos", quarto,
                LocalDate.of(2026,5,1),
                LocalDate.of(2026,5,5));

        Reserva r2 = new Reserva("Ana", quarto,
                LocalDate.of(2026,5,3),
                LocalDate.of(2026,5,6));

        sistema.reservar(r1);
        assertFalse(sistema.reservar(r2));
    }

    @Test
    void deveLiberarQuartoAoCancelar() {
        SistemaReserva sistema = new SistemaReserva();
        Quarto quarto = new Quarto(104);

        Reserva r1 = new Reserva("Pedro", quarto,
                LocalDate.of(2026,5,1),
                LocalDate.of(2026,5,5));
        sistema.reservar(r1);
        r1.cancelar();

        Reserva r2 = new Reserva("Julia", quarto,
                LocalDate.of(2026,5,3),
                LocalDate.of(2026,5,6));
        assertTrue(sistema.reservar(r2));
    }
}
