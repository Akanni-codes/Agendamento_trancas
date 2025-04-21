package com.agenda.trancas.DTO;

public record PagamentoDTO(
        Long agendamentoId,
        Double valorPago,
        String metodoPagamento
) {}
