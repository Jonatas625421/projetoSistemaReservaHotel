package org.example;

import java.util.ArrayList;
import java.util.List;

public class SistemaReserva {
    private List<Reserva> reservas = new ArrayList<>();

    public boolean reservar(Reserva novaReserva) {
        for (Reserva r : reservas) {
            if (r.getQuarto().getNumero() == novaReserva.getQuarto().getNumero()
                    && r.getStatus() == Reserva.StatusReserva.ATIVA
                    && datasConflitam(r, novaReserva)) {
                    return false; // conflito
            }
        }
        reservas.add(novaReserva);
        return true;
    }

    private boolean datasConflitam(Reserva r1, Reserva r2) {
        return !(r2.getSaida().isBefore(r1. getEntrada()) || r2.getEntrada().isAfter(r1.getSaida()));
    }

}
