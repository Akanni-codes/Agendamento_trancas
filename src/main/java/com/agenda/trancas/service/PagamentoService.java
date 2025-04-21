package com.agenda.trancas.service;

import com.agenda.trancas.DTO.PagamentoDTO;
import com.agenda.trancas.model.Agendamento;
import com.agenda.trancas.model.Pagamento;
import com.agenda.trancas.repository.AgendamentoRepository;
import com.agenda.trancas.repository.PagamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepo;
    private final AgendamentoRepository agendamentoRepo;

    public PagamentoService(PagamentoRepository pagamentoRepo, AgendamentoRepository agendamentoRepo) {
        this.pagamentoRepo = pagamentoRepo;
        this.agendamentoRepo = agendamentoRepo;
    }

    @Transactional
    public Pagamento registrarPagamento(PagamentoDTO dto) {
        Agendamento agendamento = agendamentoRepo.findById(dto.agendamentoId()).orElseThrow();

        Pagamento pagamento = new Pagamento();
        pagamento.setAgendamento(agendamento);
        pagamento.setValorPago(dto.valorPago());
        pagamento.setMetodoPagamento(dto.metodoPagamento());

        if (dto.valorPago() >= (agendamento.getValorTotal() * 0.3)) {
            agendamento.setSinalPago(true);
        }

        agendamentoRepo.save(agendamento);
        return pagamentoRepo.save(pagamento);
    }
}
