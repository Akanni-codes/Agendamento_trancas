package com.agenda.trancas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataAgendamento;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private ModeloTranca modelo;

    @ManyToOne
    private Material material;

    @ManyToOne
    private LocalAtendimento local;

    private Double valorTotal;

    private Boolean sinalPago;

    @OneToOne(mappedBy = "agendamento", cascade = CascadeType.ALL)
    private Pagamento pagamento;
}