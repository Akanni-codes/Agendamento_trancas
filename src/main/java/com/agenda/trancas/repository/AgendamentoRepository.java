package com.agenda.trancas.repository;

import com.agenda.trancas.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {}
