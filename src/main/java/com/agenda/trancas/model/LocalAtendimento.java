package com.agenda.trancas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LocalAtendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endereco;
    private String cidade;
    private String tipo; // Ex: domicílio, salão, etc.
}