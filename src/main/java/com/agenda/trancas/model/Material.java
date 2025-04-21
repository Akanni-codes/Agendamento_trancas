package com.agenda.trancas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Boolean fornecidoPeloCliente;
}