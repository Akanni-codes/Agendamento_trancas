package com.agenda.trancas.DTO;

public record ClienteDTO(
        String nome,
        String telefone,
        String email,
        String cpf,
        String endereco
) {}
