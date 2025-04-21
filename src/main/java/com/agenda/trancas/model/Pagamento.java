package com.agenda.trancas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorPago;

    private LocalDateTime dataPagamento;

    private String metodoPagamento; // Ex: PIX, cartão, dinheiro

    private Boolean confirmado;

    @OneToOne
    private Agendamento agendamento;
}