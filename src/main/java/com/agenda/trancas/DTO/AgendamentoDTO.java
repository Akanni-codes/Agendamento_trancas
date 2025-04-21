package com.agenda.trancas.DTO;

import java.time.LocalDateTime;

public record AgendamentoDTO(
        LocalDateTime dataAgendamento,
        Long clienteId,
        Long modeloId,
        Long materialId,
        Long localId
) {}

