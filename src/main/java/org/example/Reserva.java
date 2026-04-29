package org.example;

import java.time.LocalDate;

public class Reserva {
    private String Cliente;
    private Quarto quarto;
    private LocalDate entrada;
    private LocalDate saida;
    private StatusReserva status;

    public Reserva(String cliente, Quarto quarto, LocalDate entrada, LocalDate saida) {
        if (saida.isBefore(entrada)){
            throw new IllegalArgumentException("Data de saída deve ser posterior à entrada");
        }
        this.Cliente = cliente;
        this.quarto = quarto;
        this.entrada = entrada;
        this.saida = saida;
        this.status = StatusReserva.ATIVA;
    }

    public Quarto getQuarto() { return quarto; }
    public LocalDate getEntrada() { return entrada; }
    public LocalDate getSaida() { return saida; }
    public StatusReserva getStatus() { return status; }

    public void cancelar() {
        this.status = StatusReserva.CANCELADA;
    }

    public enum StatusReserva{
        ATIVA,
        CANCELADA
    }

}
